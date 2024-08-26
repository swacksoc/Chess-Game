import javax.swing.*;

import java.awt.*;

import static java.lang.Math.sqrt;

public class Bishop extends Piece {
    public Bishop(boolean isOrange) {
        setOrange(isOrange);
        setImage((new ImageIcon("src/BishopOrange.png")), (new ImageIcon("src/BishopYellow.png")));
        addMouseListener(this);
    }

    @Override
    /**
     * Goes through and checks movement coordinates are within the correct range and then goes through and checks if there
     * is a piece between the start and the end and if there is it returns false and stops movement past that point
     */
    public boolean checkMovement(int[] movementCoords,Piece[][] pieces,BlankSquare[][] blankSquares) {
        int y1 =movementCoords[0];
        int x1 = movementCoords[1];
        int y2 = movementCoords[2];
        int x2 = movementCoords[3];
        int opposingPieceCounter = 0;//Keeps track of if a piece of the opposing colour is in this pieces path
        System.out.println(y1 + " y1 " + y2 + "y2");

        if ((y1 != y2 && x1 != x2)
                && (((x1 - x2) == (y1 -y2))||
                ((x1 - x2) ==(y1 - y2) * -1))||
                (((x1 - x2) * -1) == (y1 - y2))){


            
            System.out.println(sqrt((y1 - y2) * (y1 -y2)) + " FOR LOOP BISHOP CHECK");
            double positiveDifferenceY1AndY2 = sqrt((y1 - y2) * (y1 -y2));
            for (int i = 0; i < positiveDifferenceY1AndY2;i++){
                System.out.println(" I " + i + " DIFF " + positiveDifferenceY1AndY2);
                System.out.println(sqrt((y1 - y2) * (y1 - y2)) + " Y CHECKING LOOP");
                System.out.println(sqrt((x1 - x2) * (x1 - x2)) + " X CHECKING LOOP" );


                if (y1 - y2 < 0 && x1 - x2 < 0){
                    System.out.println("1");
                    if (pieces[y1][x1].isOrange()){

                        if (pieces[y2][x2] != null && !pieces[y2][x2].isOrange()){
                            System.out.println("Piece found");
                            opposingPieceCounter+= 1;



                        }else if (pieces[y2][x2] != null && pieces[y2][x2].isOrange()){
                            System.out.println("Piece Found");
                            return false;
                        }
                    }else if (!pieces[y1][x1].isOrange()){

                        if (pieces[y2][x2] != null && pieces[y2][x2].isOrange()){
                            System.out.println("Piece found");
                            opposingPieceCounter+= 1;

                        }else if (pieces[y2][x2] != null && !pieces[y2][x2].isOrange()){
                            System.out.println("Piece found");
                            return false;
                        }
                    }

                    y2 = y2 - 1;
                    x2 = x2 - 1;
                }else if (y1 - y2 > 0 && x1 - x2 > 0){
                    System.out.println("2");

                    if (pieces[y1][x1].isOrange()){

                        if (pieces[y2][x2] != null && !pieces[y2][x2].isOrange()){
                            System.out.println("Piece found");
                            opposingPieceCounter+= 1;

                        }else if (pieces[y2][x2] != null && pieces[y2][x2].isOrange()){
                            System.out.println("Piece Found");
                            return false;
                        }
                    }else if (!pieces[y1][x1].isOrange()){

                        if (pieces[y2][x2] != null && pieces[y2][x2].isOrange()){
                            System.out.println("Piece found");
                            opposingPieceCounter+= 1;

                        }else if (pieces[y2][x2] != null && !pieces[y2][x2].isOrange()){
                            System.out.println("Piece found");
                            return false;
                        }
                    }
                    y2 = y2 + 1;
                    x2 = x2 + 1;

                } else if (y1 - y2 < 0 && x1 - x2 > 0) {
                    System.out.println("Y2 " + y2);
                    System.out.println("X2 " + x2);
                    System.out.println("3");

                    if (pieces[y1][x1].isOrange()){

                        if (pieces[y2][x2] != null && !pieces[y2][x2].isOrange()){
                            System.out.println("Piece found");
                            opposingPieceCounter += 1;
                        }else if (pieces[y2][x2] != null && pieces[y2][x2].isOrange()){
                            System.out.println("Piece found");
                            return false;


                        }
                    }else if (!pieces[y1][x1].isOrange()){

                        if (pieces[y2][x2] != null && pieces[y2][x2].isOrange()){
                            System.out.println("Piece found");
                            opposingPieceCounter += 1;
                        }else if (pieces[y2][x2] != null && !pieces[y2][x2].isOrange()){
                            System.out.println("Piece found");
                            return false;
                        }
                    }
                    y2 = y2 - 1;
                    x2 = x2 + 1;
                }else if (y1 - y2 > 0 && x1 - x2 < 0){
                    System.out.println("4");
                    if (pieces[y1][x1].isOrange()){

                        if (pieces[y2][x2] != null && !pieces[y2][x2].isOrange()){
                            System.out.println("Piece found");
                            opposingPieceCounter += 1;
                        } else if (pieces[y2][x2] != null && pieces[y2][x2].isOrange()) {
                            System.out.println("Piece found");
                            return false;
                        }

                    }else if (!pieces[y1][x1].isOrange()){

                        if (pieces[y2][x2] != null && pieces[y2][x2].isOrange()){
                            System.out.println("Piece found");
                            opposingPieceCounter += 1;

                        }else if (pieces[y2][x2] != null && !pieces[y2][x2].isOrange()){
                            System.out.println("Piece found");
                            return false;
                        }
                    }
                    y2 = y2 + 1;
                    x2 = x2 - 1;
                }
                if (opposingPieceCounter >= 2){
                    return false;
                }
            }
            return true;
        }else {
            return false;
        }

    }
}

