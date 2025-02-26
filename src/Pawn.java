import javax.swing.*;

public class Pawn extends Piece {
    private boolean firstTurn = true;

    /**
     * Constructor Pawn Class
     * @param isOrange boolean specifies whether pawn is orange or yellow
     * @param y y coordinate of pawn
     * @param x x coordinate of pawn
     */
    public Pawn(boolean isOrange,int y,int x) {
        super(y,x);
        setOrange(isOrange);
        setImage((new ImageIcon("src/Art/PawnOrange.png")), new ImageIcon("src/Art/PawnYellow.png"));
        addMouseListener(this);
    }

    public boolean isFirstTurn() {
        return firstTurn;
    }

    @Override
    public boolean checkMovement(int[] movementCoords, Piece[][] pieces, BlankSquare[][] blankSquares,boolean visualCheck) {

        int y1 = movementCoords[0];
        int x1 = movementCoords[1];
        int y2 = movementCoords[2];
        int x2 = movementCoords[3];

        //First Turn
        if(isFirstTurn()){
            if (!isOrange()) {
                if ((x1 == x2) && (y1 + 1 == y2|| y1 + 2 == y2) && !Main.checkFront(movementCoords,pieces)){
                    if (!visualCheck){
                        firstTurn = false;
                    }
                    return true;
                }
                if (Main.checkLeftDiagonal(movementCoords,pieces)){
                    System.out.println("left diagonal true");
                    if (x2 == x1 + 1 && y2 == y1 + 1){
                        return true;
                    }
                }

                if (Main.checkRightDiagonal(movementCoords,pieces)){
                    System.out.println("right diagonal true");
                    if (x2 == x1 - 1 && y2 == y1 + 1){
                        return true;
                    }
                }

            } else {
                if ((x1 == x2) && (y1 -1 == y2 || y1 - 2 == y2) && !Main.checkFront(movementCoords,pieces)) {
                    if (!visualCheck){
                        firstTurn = false;
                    }
                    return true;
                }

                if (Main.checkLeftDiagonal(movementCoords,pieces)){
                    if (x2 == x1 - 1 && y2 == y1 - 1){
                        System.out.println("left diagonal true");
                        return true;
                    }
                }

                if (Main.checkRightDiagonal(movementCoords,pieces)){
                    System.out.println("right diagonal true");
                    if (x2 == x1 + 1 && y2 == y1 - 1){
                        return true;
                    }
                }
            }
            return false;
        } else {
            if (!isOrange()) {

                if ((x1 == x2 && y1 + 1 == y2) && !Main.checkFront(movementCoords,pieces)){
                    return true;
                }

                if (Main.checkLeftDiagonal(movementCoords,pieces)){
                    System.out.println("left diagonal true");
                    if (x2 == x1 + 1 && y2 == y1 + 1){
                        return true;
                    }
                }

                if (Main.checkRightDiagonal(movementCoords,pieces)){
                    System.out.println("right diagonal true");
                    if (x2 == x1 - 1 && y2 == y1 + 1){
                        return true;
                    }
                }

            } else {

                if (x1 == x2 && y1 - 1 == y2 && !Main.checkFront(movementCoords,pieces)){
                    System.out.println("normal move true Forward");
                    return true;
                }

                if (Main.checkLeftDiagonal(movementCoords,pieces)){
                    if (x2 == x1 - 1 && y2 == y1 - 1){
                        System.out.println("left diagonal true");
                        return true;
                    }
                }

                if (Main.checkRightDiagonal(movementCoords,pieces)){
                    System.out.println("right diagonal true");
                    if (x2 == x1 + 1 && y2 == y1 - 1){
                        return true;
                    }
                }
            }


        }
       return false;
    }


}



