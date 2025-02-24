import javax.swing.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

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
    public boolean checkMovement(int[] movementCoords, Piece[][] pieces, BlankSquare[][] blankSquares,boolean visualCheck) {
        int y1 = movementCoords[0];
        int x1 = movementCoords[1];
        int y2 = movementCoords[2];
        int x2 = movementCoords[3];

        //Gets all list of all possible valid moves and then searches to find if any input coordinates are the same
        ArrayList<Pair> verticalMovesOne = Main.traversal(y1,x1,1,0,pieces);
        ArrayList<Pair> verticalMovesTwo = Main.traversal(y1,x1,-1,0,pieces);
        ArrayList<Pair> horizontalMovesOne = Main.traversal(y1,x1,0,-1,pieces);
        ArrayList<Pair> horizontalMovesTwo = Main.traversal(y1,x1,0,1,pieces);

        ArrayList<Pair> validMoves = new ArrayList<>(verticalMovesOne);
        validMoves.addAll(verticalMovesTwo);
        validMoves.addAll(horizontalMovesOne);
        validMoves.addAll(horizontalMovesTwo);

        ArrayList<Pair> validMovesSearch = validMoves.stream()
                .filter(x -> x.equals(new Pair(y2,x2)))
                .collect(Collectors.toCollection(ArrayList<Pair>::new));
        System.out.println(validMovesSearch.size() + "LIST SIZE");

        if (validMovesSearch.size() >= 1){
            return true;
        }else {
            return false;
        }

    }
}


