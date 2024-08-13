import javax.swing.*;

import static java.lang.Math.sqrt;

public class Bishop extends Piece {
    public Bishop(boolean isOrange) {
        setOrange(isOrange);
        setImage((new ImageIcon("src/BishopOrange.png")), (new ImageIcon("src/BishopYellow.png")));
        addMouseListener(this);
    }

    @Override
    public boolean checkMovement(int[] movementCoords,Piece[][] pieces) {
        int y1 =movementCoords[0];
        int x1 = movementCoords[1];
        int y2 = movementCoords[2];
        int x2 = movementCoords[3];
        System.out.println(y1 + " y1" + y2 + "y2");
        if ((y1 != y2 && x1 != x2)
                && (((x1 - x2) == (y1 -y2))||
                ((x1 - x2) ==(y1 - y2) * -1))||
                (((x1 - x2) * -1) == (y1 - y2))){
            System.out.println(sqrt((y1 - y2) * (y1 -y2)) + " FOR LOOP BISHOP CHECK");
            double positiveDifferenceY1AndY2 = sqrt((y1 - y2) * (y1 -y2));
            for (int i = 0; i < positiveDifferenceY1AndY2 - 2;i++){
                System.out.println(" I " + i + " DIFF " + positiveDifferenceY1AndY2);
                if (y1 - y2 < 0 && x1 - x2 < 0){
                    System.out.println("1");
                    y2 = y2 - 1;
                    x2 = x2 - 1;
                    if (pieces[y2][x2] != null){
                        System.out.println("Piece found");
                        return false;
                    }
                }else if (y1 - y2 > 0 && x1 - x2 > 0){
                    System.out.println("2");
                    y2 = y2 + 1;
                    x2 = x2 + 1;
                    if (pieces[y2][x2] != null){
                        System.out.println("Piece found");
                        return false;
                    }
                } else if (y1 - y2 < 0 && x1 - x2 > 0) {
                    System.out.println("Y2 " + y2);
                    System.out.println("X2 " + x2);
                    System.out.println("3");
                    y2 = y2 - 1;
                    x2 = x2 + 1;
                    if (pieces[y2][x2] != null){
                        System.out.println("Piece Found");
                        return false;
                    }
                }else if (y1 - y2 > 0 && x1 - x2 < 0){
                    System.out.println("4");
                    y2 = y2 + 1;
                    x2 = x2 - 1;
                    if (pieces[y2][x2] != null){
                        System.out.println("Piece Found");
                        return false;
                    }
                }
            }
            return true;
        }else {
            return false;
        }

    }
}

