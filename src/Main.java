import java.awt.*;
import java.lang.reflect.Array;

public class Main {
        /**
         * Checks Square in front of piece to see if it has a piece on it
         * @return true if piece false if not
         */
        public static boolean checkFront(int [] movementCoords ,Piece[][] pieces){
            int y1 = movementCoords[0];
            int x1 = movementCoords[1];
            int y2 = movementCoords[2];
            int x2 = movementCoords[3];
            boolean returnVal = false;
            //Each one is for pieces at different side of the board
            if (pieces[y1][x1].isOrange()){
                    if (pieces[y1-1][x1] != null){
                            returnVal = true;
                    }
            }else {
                    if (pieces[y1+1][x1] != null) {
                            returnVal = true;
                    }
            }
            return returnVal;
        }

        /**
         * Checks Left Diagonal of a piece to see if that square has piece on it
         * @param movementCoords movementCoords List
         * @param pieces piece list
         * @return true if piece in
         */
        public static boolean checkLeftDiagonal(int [] movementCoords ,Piece[][] pieces){
            int y1 = movementCoords[0];
            int x1 = movementCoords[1];
            int y2 = movementCoords[2];
            int x2 = movementCoords[3];
            boolean returnVal = false;
            //Each one is for pieces at different side of the board
            if (pieces[y1][x1].isOrange()){
                if (pieces[y1 - 1][x1 - 1] != null){
                    if (!pieces[y1 - 1][x1 - 1].isOrange()){
                        returnVal = true;
                    }
                }
            }else {
                    if (pieces[y1 + 1][x1 + 1] != null){
                        if (pieces[y1 + 1][x1 + 1].isOrange()){
                            returnVal = true;
                        }
                    }
            }
            return returnVal;
        }

        /**
         * Checks to see if there is a piece in the square diagonal and to right of selected piece
         * @param movementCoords movementCoords
         * @param pieces piece list
         * @return true if piece false if not
         */
        public static boolean checkRightDiagonal(int [] movementCoords ,Piece[][] pieces){
            int y1 = movementCoords[0];
            int x1 = movementCoords[1];
            boolean returnVal = false;
            //Each one is for pieces at different side of the board
            if (pieces[y1][x1].isOrange()) {
                if (y1 > 0 && x1 < 7){
                    if (pieces[y1 - 1][x1 + 1] != null){
                        if (!pieces[y1 - 1][x1 + 1].isOrange()) {
                            returnVal = true;
                        }
                    }
                }else {
                    returnVal = false;
                }
            }else {
                    if (pieces[y1+1][x1-1] != null){
                        if (pieces[y1+1][x1-1].isOrange()){
                            returnVal = true;
                        }
                    }
            }
            return returnVal;
        }

        /**
         * Finds squares to turn red
         * @param blankSquares BlankSquare list of all coordinates on board
         * @param movementCoords Int [] movementCoords of piece
         * @param piece
         * @return
         */
        private static void displayPieceMoves(BlankSquare[][] blankSquares,int[] movementCoords,Piece piece,Piece[][] pieces) {
            System.out.println("NEW DISPLAY");
            System.out.println("Y " + movementCoords[0] + " X " + movementCoords[1] + " Player coordinates");
            boolean kReset = false;
            int j = 0;
            int k = 0;
            for (int i = 0; i < 64; i++) {
                movementCoords[2] = j;
                movementCoords[3] = k;
                System.out.println("X " + k + " Y " + j);
                //This is to stop it from highlighting pieces of same colour as the current piece but also make sur eit highlights enemy pieces as possible moves
                if (piece.checkMovement(movementCoords,pieces,blankSquares)) {
                    System.out.println("CHECK MOVEMENT TRUE");
                    if (blankSquares[j][k].getComponentCount() == 1){
                        Component[] Components = blankSquares[j][k].getComponents();
                        if (Components[0] instanceof Piece){
                            if (piece.isOrange()){
                                if (!((Piece) Components[0]).isOrange()){
                                    blankSquares[j][k].setColour(Color.GREEN);
                                    blankSquares[j][k].repaint();
                                    
                                }
                            } else if (!piece.isOrange()) {
                                if (((Piece) Components[0]).isOrange()){
                                    blankSquares[j][k].setColour(Color.GREEN);
                                    blankSquares[j][k].repaint();
                                }
                            }
                        }

                    }else {
                        blankSquares[j][k].setColour(Color.GREEN);
                        blankSquares[j][k].repaint();
                        
                    }
                }


                if (k == 7 && j != 7) {
                    k = 0;
                    kReset = true;
                    j++;
                }

                if (!kReset) {
                    k++;
                }
                kReset = false;
            }
        }
    public static void main(String[] args) {
        Board board = new Board("Chess Game", 1000, 1000);

        int turn = 0;
        //Main Event Loop
        while (true) {

            int [] movementCoords = new int[4];
            Piece[][] pieces = board.getPieces();
            //Resets all values in pieces to false before checks
            int p = 0;
            int q = 0;
            for (int i = 0; i < 64; i++) {
                boolean reset = false;
                if (pieces[q][p] != null){
                    pieces[q][p].setPressed(false);
                }

                if (p == 7) {
                    q++;
                    p = 0;
                    reset = true;
                }
                if (!reset) {
                    p++;
                }

            }
            //Checks to see when a piece has been pressed and adds its coordinates to array
            int j = 0;
            int k = 0;
            boolean piecePressed = false;
            while (!piecePressed) {
                boolean reset = false;
                if (pieces[k][j] != null) {

                    if (turn % 2 == 0){
                        if (pieces[k][j].isPressed()){

                            if (pieces[k][j].isOrange()){
                                System.out.println("Orange Yellow turn");
                                pieces[k][j].setPressed(false);

                            } else if (!pieces[k][j].isOrange()) {
                                System.out.println("Orange orange turn");
                                pieces[k][j].setPressed(false);
                                movementCoords[0] = k;
                                movementCoords[1] = j;
                                displayPieceMoves(board.getBlankSquares(), movementCoords,pieces[k][j],pieces);
                                piecePressed = true;
                                System.out.println("piece break");

                            }
                        }
                    } else if (turn % 2 != 0) {
                        if (pieces[k][j].isPressed()){

                            if (!pieces[k][j].isOrange()){
                                System.out.println("Yellow - orange Turn");
                                pieces[k][j].setPressed(false);

                            } else if (pieces[k][j].isOrange()) {
                                if (pieces[k][j].isPressed()) {
                                    System.out.println("Yellow Orange Turn");
                                    pieces[k][j].setPressed(false);
                                    movementCoords[0] = k;
                                    movementCoords[1] = j;
                                    displayPieceMoves(board.getBlankSquares(), movementCoords,pieces[k][j],pieces);
                                    piecePressed = true;
                                    System.out.println("piece break");
                                }
                            }
                        }
                    }
                }

                if (j == 7) {
                    k++;
                    j = 0;
                    reset = true;
                }
                if (!reset) {
                    j++;
                }
                if (j == 7 && k == 7) {
                    j = 0;
                    k = 0;
                }

            }

            BlankSquare[][] blankSquares = board.getBlankSquares();
            //Resets all values in blankSquares to false before checks begin
            int x = 0;
            int y = 0;
            for (int i = 0; i < 64; i++) {
                boolean reset = false;
                blankSquares[y][x].setPressed(false);
                if (x == 7) {
                    y++;
                    x = 0;
                    reset = true;
                }
                if (!reset) {
                    x++;
                }

            }
            //Loop checks if one has been pressed and adds its coordinates on grid to array
            boolean squarePressed = false;
            int l = 0;
            int m = 0;
            while (!squarePressed) {
                boolean reset = false;
                if (pieces[movementCoords[0]][movementCoords[1]].getClass() != Pawn.class){
                    if (blankSquares[l][m].isPressed()) {
                        blankSquares[l][m].setPressed(false);
                        movementCoords[2] = l;
                        movementCoords[3] = m;
                        int yOne = movementCoords[0];
                        int xOne = movementCoords[1];
                        if (pieces[yOne][xOne].checkMovement(movementCoords,pieces, board.getBlankSquares())) {
                            squarePressed = true;
                        }
                    }

                } else if (pieces[movementCoords[0]][movementCoords[1]].getClass() == Pawn.class) {
                    System.out.println(checkLeftDiagonal(movementCoords,pieces) + " Left Diagonal Check");
                    System.out.println(checkRightDiagonal(movementCoords,pieces) + " Right Diagonal Check");
                    System.out.println(checkFront(movementCoords,pieces) + " Front Check ");
                    if (blankSquares[l][m].isPressed()) {
                            blankSquares[l][m].setPressed(false);
                            movementCoords[2] = l;
                            movementCoords[3] = m;
                            int yOne = movementCoords[0];
                            int xOne = movementCoords[1];
                            if (pieces[yOne][xOne].checkMovement(movementCoords,pieces, board.getBlankSquares())) {
                                squarePressed = true;
                                System.out.println("Valid Normal Move");
                            }
                    }
                }

                if (l == 7) {
                    m++;
                    l = 0;
                    reset = true;
                }
                if (!reset) {
                    l++;
                }
                if (l == 7 && m == 7) {
                    l = 0;
                    m = 0;
                }

            }
            //Resets colors to original colours
            int a = 0;
            int b  = 0;
            for (int i = 0; i < 64; i++) {
                boolean reset = false;
                if (blankSquares[a][b].isBlack()){
                    blankSquares[a][b].setColour(Color.black);
                }else {
                    blankSquares[a][b].setColour(Color.white);
                }

                if (a == 7) {
                    b++;
                    a = 0;
                    reset = true;
                }
                if (!reset) {
                    a++;
                }

            }
            //Checks if multiple pieces on same square
            board.movePieces(movementCoords);
            System.out.println("Moved");
            turn++;
            System.out.println(turn + " turn");


        }
    }
}


