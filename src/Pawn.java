import javax.swing.*;

public class Pawn extends Piece {
    private boolean firstTurn = true;
    public Pawn(boolean isOrange) {
        setOrange(isOrange);
        setImage((new ImageIcon("src/PawnOrange.png")), new ImageIcon("src/PawnYellow.png"));
        addMouseListener(this);
    }

    public boolean isFirstTurn() {
        return firstTurn;
    }

    /**
     * Overrides check movement command to make sure pawn can only move within rules
     * @param movementCoords Coordinates of where pawn would move to
     * @return True if within rules false if not
     */
    @Override
    public boolean checkMovement(int[] movementCoords, Piece[][] pieces, BlankSquare[][] blankSquares) {

        int x1 = movementCoords[0];
        int y1 = movementCoords[1];
        int x2 = movementCoords[2];
        int y2 = movementCoords[3];
        if(isFirstTurn()){
            firstTurn = false;
            System.out.println("Pawn Check First Turn");
            if (!isOrange()) {
                if (y1 == y2
                        && ((x2 - x1 == 1 && x2 > x1) ||(x2 - x1 == 2 && x2 > x1))) {
                    return true;
                }
            } else if (isOrange()) {
                if (y1 == y2 && (x2 - x1 == -1 && x2 < x1 ||(x2 - x1 == -2 && x1 > x2))) {
                    return true;
                }
            }
            return false;
        } else {
            System.out.println("Pawn Check");
            if (!isOrange()) {
                if (y1 == y2
                        && (x2 - x1 == 1 && x2 > x1)) {
                    return true;
                }
            } else if (isOrange()) {
                if (y1 == y2 && (x2 - x1 == -1 && x2 < x1)) {
                    return true;
                }
            }

        }
        System.out.println("False Coordinates Y " + movementCoords[2] + " X " +  movementCoords[3]);
       return false;
    }

    /**
     * Activates if a piece is detected directly next to the current piece
     * @param movementCoords Int Array containing coordinates piece moves from and to
     * @param pieceInFront Boolean true if there is a piece in front
     * @param pieceLeftDiagonal Boolean true if there is a piece to the pieces bottom or top left
     * @param pieceRightDiagonal Boolean true if there is a piece to the pieces bottom or top right
     * @return
     */
    public boolean checkTake(int[] movementCoords,boolean pieceInFront,boolean pieceLeftDiagonal,boolean pieceRightDiagonal) {
        int y1 = movementCoords[0];
        int x1 = movementCoords[1];
        int y2 = movementCoords[2];
        int x2 = movementCoords[3];

        if (pieceInFront && !pieceLeftDiagonal && !pieceRightDiagonal) {
            return false;
        } else if (pieceInFront && !pieceLeftDiagonal && pieceRightDiagonal) {
            System.out.println("1");
            System.out.println(x1 - x2 + "X minus");
            System.out.println(y1 - y2 + "Y Minus");
            if(y1 - y2 == 1 && x1 - x2 == -1 && !isOrange()){
                return true;
            }else if (y1 - y2 == -1 && x1 - x2 == -1 && isOrange()){
                return true;
            }
        } else if (pieceInFront && pieceLeftDiagonal && !pieceRightDiagonal) {
            System.out.println("2");
            System.out.println(x1 - x2 + "X minus");
            System.out.println(y1 - y2 + "Y Minus");
            if (y1 - y2 == 1 && x1 - x2 == 1 && isOrange()){
                return true;
            }else if (y1 - y2 == -1 && x1 - x2 == -1 && !isOrange()){
                return true;
            }
        } else if (pieceInFront && pieceLeftDiagonal && pieceRightDiagonal) {
            System.out.println("3");
            System.out.println(x1 - x2 + "X minus");
            System.out.println(y1 - y2 + "Y Minus");
            if ((y1 - y2 == 1 && x1 - x2 == 1
                || y1 - y2 == -1 && x1 - x2 == 1) && isOrange()){
                return true;
            }else if ((y1 - y2 == 1 && x1 - x2 == 1 || y1 - y2 == 1 && x1 - x2 == -1) && !isOrange()){
                return true;
            }
        } else if (!pieceInFront && pieceLeftDiagonal && pieceRightDiagonal) {
            System.out.println("4");

            System.out.println(x1 - x2 + "X minus");
            System.out.println(y1 - y2 + "Y Minus");


            if(y1 - y2 == 0 && x1-x2 == -1 && !isOrange() || y1 - y2 == 1 && x1 - x2 == -1 && !isOrange()|| y1 - y2 == -1 && x1 - x2 == -1 && !isOrange()){
                return true;
            }else if (y1 - y2 == 0 && x1 - x2 == 1 && isOrange() || y1 - y2 == 1 && x1 - x2 == -1 && isOrange() || y1 - y2 == -1 && x1 - x2 == -1 && isOrange()){
                return true;
            }
        } else if (!pieceInFront && pieceLeftDiagonal && !pieceRightDiagonal) {
            System.out.println("5");
            System.out.println(x1 - x2 + "X minus");
            System.out.println(y1 - y2 + "Y Minus");
            if(y1 - y2 == 0 && x1 - x2 == -1 &&  !isOrange() || y1 - y2 == -1 && x1 - x2 == -1 && !isOrange()){
                return true;
            }else if (y1 - y2 == 1 && x1 - x2 == 1 && isOrange() || - y2 == 1 && x1 - x2 == -1 && isOrange()){
                return true;
            }
        } else if (!pieceInFront && !pieceLeftDiagonal && pieceRightDiagonal) {
            System.out.println("6");
            System.out.println(x1 - x2 + " X minus");
            System.out.println(y1 - y2 + " Y Minus");
            if(y1 - y2 == 0 && x1 - x2 ==-1 && !isOrange() || y1 - y2 == 1 && x1 - x2 == -1 && !isOrange()){
                return true;

            }else if (y1 - y2 == 1 && x1 - x2 ==1 && isOrange()||y1 - y2 == -1 && x1 - x2 == 1 && isOrange()){
                return true;
            }
        }
        return false;
    }
}



