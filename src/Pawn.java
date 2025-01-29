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
    public boolean checkMovement(int[] movementCoords, Piece[][] pieces, BlankSquare[][] blankSquares) {

        int x1 = movementCoords[0];
        int y1 = movementCoords[1];
        int x2 = movementCoords[2];
        int y2 = movementCoords[3];
        System.out.println("MOVEMENT COORDS PAWN");
        for (int elem : movementCoords){
            System.out.println(elem);
        }
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
                if (y1 == y2 && (x2 - x1 == 1 && x2 > x1) && !Main.checkFront(movementCoords,pieces)){
                    return true;
                }
                if (Main.checkLeftDiagonal(movementCoords,pieces)){
                    if (x2 == x1 + 1 && y2 == y1 + 1){
                        return true;
                    }
                }
                if (Main.checkRightDiagonal(movementCoords,pieces)){
                    if (x2 == x1 + 1 && y2 == y1 - 1){
                        return true;
                    }
                }

            } else if (isOrange()) {
                if (y1 == y2 && (x2 - x1 == -1 && x2 < x1) && !Main.checkFront(movementCoords,pieces)){
                    return true;
                }
                if (Main.checkLeftDiagonal(movementCoords,pieces)){
                    if (x2 == x1 - 1 && y2 == y1 - 1){
                        return true;
                    }
                }
                if (Main.checkRightDiagonal(movementCoords,pieces)){
                    if (x2 == x1 - 1 && y2 == y1 + 1){

                    }
                }
            }

        }
        System.out.println("False Coordinates Y " + movementCoords[2] + " X " +  movementCoords[3]);
       return false;
    }

}



