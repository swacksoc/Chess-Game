import javax.swing.*;

import static java.lang.Math.sqrt;
import static java.lang.Math.subtractExact;

public class Castle extends Piece {
    public Castle(boolean isOrange,int y,int x) {
        super(y,x);
        setOrange(isOrange);
        setImage((new ImageIcon("src/CastleOrange.png")), (new ImageIcon("src/CastleYellow.png")));
        addMouseListener(this);
    }

    /**
     * checks to see if a certain move is valid
     *
     * @param movementCoords Integer array containing coordinates of pieces current location
     *                       and location it will move to
     * @return true if move is valid false if it is invalid
     */
    @Override
    public boolean checkMovement(int[] movementCoords, Piece[][] pieces, BlankSquare[][] blankSquares) {
        int y1 = movementCoords[0];
        int x1 = movementCoords[1];
        int y2 = movementCoords[2];
        int x2 = movementCoords[3];

        if (x1 == x2) {

            int opposingPieceCounter = 0;
            double positiveDifferenceY1AndY2 = sqrt((y1 - y2) * (y1 - y2));
            for (int i = 0; i < positiveDifferenceY1AndY2; i++) {
                System.out.println("LOOP CASTLE");

                if (y1 - y2 < 0) {
                    System.out.println("1");
                    if (pieces[y1][x1].isOrange()) {

                        if (pieces[y2][x2] != null && !pieces[y2][x2].isOrange()) {
                            System.out.println("Piece found at " + y2 +" " + x2);
                            opposingPieceCounter += 1;


                        } else if (pieces[y2][x2] != null && pieces[y2][x2].isOrange()) {
                            System.out.println("Piece found at " + y2 +" " + x2);
                            return false;
                        }
                    } else if (!pieces[y1][x1].isOrange()) {

                        if (pieces[y2][x2] != null && pieces[y2][x2].isOrange()) {
                            System.out.println("Piece found at " + y2 +" " + x2);
                            opposingPieceCounter += 1;

                        } else if (pieces[y2][x2] != null && !pieces[y2][x2].isOrange()) {
                            System.out.println("Piece found at " + y2 +" " + x2);
                            return false;
                        }
                    }

                    y2 -= 1;
                } else if (y1 - y2 > 0) {
                    System.out.println("2");

                    if (pieces[y1][x1].isOrange()) {

                        if (pieces[y2][x2] != null && !pieces[y2][x2].isOrange()) {
                            System.out.println("Piece found at " + y2 +" " + x2);
                            opposingPieceCounter += 1;

                        } else if (pieces[y2][x2] != null && pieces[y2][x2].isOrange()) {
                            System.out.println("Piece found at " + y2 +" " + x2);
                            return false;
                        }
                    } else if (!pieces[y1][x1].isOrange()) {

                        if (pieces[y2][x2] != null && pieces[y2][x2].isOrange()) {
                            System.out.println("Piece found at " + y2 +" " + x2);
                            opposingPieceCounter += 1;

                        } else if (pieces[y2][x2] != null && !pieces[y2][x2].isOrange()) {
                            System.out.println("Piece found at " + y2 +" " + x2);
                            return false;
                        }
                    }
                    y2 += 1;
                }


                if (opposingPieceCounter >= 2) {
                    return false;
                }
            }

            return true;

        } else if (y1 == y2){
            int opposingPieceCounter = 0;
            double positiveDifferenceX1AndX2 = sqrt((x1 - x2) * (x1 - x2));
            for (int i = 0; i < positiveDifferenceX1AndX2; i++) {
                System.out.println("LOOP CASTLE");

                if (x1 - x2 < 0) {
                    System.out.println("1");
                    if (pieces[y1][x1].isOrange()) {

                        if (pieces[y2][x2] != null && !pieces[y2][x2].isOrange()) {
                            System.out.println("Piece found at " + y2 +" " + x2);
                            opposingPieceCounter += 1;


                        } else if (pieces[y2][x2] != null && pieces[y2][x2].isOrange()) {
                            System.out.println("Piece found at " + y2 +" " + x2);
                            return false;
                        }
                    } else if (!pieces[y1][x1].isOrange()) {

                        if (pieces[y2][x2] != null && pieces[y2][x2].isOrange()) {
                            System.out.println("Piece found at " + y2 +" " + x2);
                            opposingPieceCounter += 1;

                        } else if (pieces[y2][x2] != null && !pieces[y2][x2].isOrange()) {
                            System.out.println("Piece found at " + y2 +" " + x2);
                            return false;
                        }
                    }

                    x2 -= 1;
                } else if (x1 - x2 > 0) {
                    System.out.println("2");

                    if (pieces[y1][x1].isOrange()) {

                        if (pieces[y2][x2] != null && !pieces[y2][x2].isOrange()) {

                            System.out.println("Piece found at " + y2 +" " + x2);
                            opposingPieceCounter += 1;

                        } else if (pieces[y2][x2] != null && pieces[y2][x2].isOrange()) {
                            System.out.println("Piece found at " + y2 +" " + x2);
                            return false;
                        }
                    } else if (!pieces[y1][x1].isOrange()) {

                        if (pieces[y2][x2] != null && pieces[y2][x2].isOrange()) {
                            System.out.println("Piece found at " + y2 +" " + x2);

                            opposingPieceCounter += 1;

                        } else if (pieces[y2][x2] != null && !pieces[y2][x2].isOrange()) {
                            System.out.println("Piece found at " + y2 +" " + x2);
                            return false;
                        }
                    }
                    x2 += 1;
                }


                if (opposingPieceCounter >= 2) {
                    return false;
                }
            }

            return true;

        }else {
            return false;
        }

    }
}


