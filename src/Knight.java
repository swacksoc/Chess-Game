import javax.swing.*;

public class Knight extends Piece{
    public Knight(boolean isOrange,int y,int x){
        super(y,x);
        setOrange(isOrange);
        setImage((new ImageIcon("src/Art/RookOrange.png")),(new ImageIcon("src/Art/RookYellow.png")));
        addMouseListener(this);
    }
    @Override
    public boolean checkMovement(int[] movementCoords, Piece[][] pieces,BlankSquare[][] blankSquares,boolean visualCheck){
        int y1 =movementCoords[0];
        int x1 = movementCoords[1];
        int y2 = movementCoords[2];
        int x2 = movementCoords[3];

        Pair [] possibleMoves = {new Pair(2,1),new Pair(2,-1),new Pair(-2,1),new Pair(-2,-1),
                new Pair(1,2),new Pair(1,-2),new Pair(-1,2),new Pair(-1,-2)};

        for(int i = 0;i < possibleMoves.length;i++){
            if (y2 == possibleMoves[i].getY() + y1 && x2 == possibleMoves[i].getX() + x1){
                return true;
            }

        }
        return false;
    }
}
