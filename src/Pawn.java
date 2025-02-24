import javax.swing.*;

public class Pawn extends Piece {
    private boolean firstTurn = true;
    public Pawn(boolean isOrange,int y,int x) {
        super(y,x);
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

            } else if (isOrange()) {
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

            } else if (isOrange()) {


                if (x1 == x2 && y1 - 1 == y2){
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



