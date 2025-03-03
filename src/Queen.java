import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Queen extends Piece {
    public Queen(boolean isOrange,int y,int x) {
        super(y,x);
        setOrange(isOrange);
        setImage((new ImageIcon("src/Art/QueenOrange.png")), (new ImageIcon("src/Art/QueenYellow.png")));
        addMouseListener(this);
    }

    @Override
    public boolean checkMovement(int[] movementCoords,Piece[][] pieces,BlankSquare[][] blankSquares,boolean visualCheck){
        int y1 =movementCoords[0];
        int x1 = movementCoords[1];
        int y2 = movementCoords[2];
        int x2 = movementCoords[3];
        //Gets all list of all possible valid moves and then searches to find if any input coordinates are the same
        ArrayList<Pair> verticalMovesOne = Main.traversal(y1,x1,1,0,pieces);
        ArrayList<Pair> verticalMovesTwo = Main.traversal(y1,x1,-1,0,pieces);
        ArrayList<Pair> horizontalMovesOne = Main.traversal(y1,x1,0,-1,pieces);
        ArrayList<Pair> horizontalMovesTwo = Main.traversal(y1,x1,0,1,pieces);
        ArrayList<Pair> diagonalMovesOne = Main.traversal(y1,x1,1,1,pieces);
        ArrayList<Pair> diagonalMovesTwo = Main.traversal(y1,x1,1,-1,pieces);
        ArrayList<Pair> diagonalMovesThree = Main.traversal(y1,x1,-1,1,pieces);
        ArrayList<Pair> diagonalMovesFour = Main.traversal(y1,x1,-1,-1,pieces);

        ArrayList<Pair> validMoves = new ArrayList<>(verticalMovesOne);
        validMoves.addAll(verticalMovesTwo);
        validMoves.addAll(horizontalMovesOne);
        validMoves.addAll(horizontalMovesTwo);
        validMoves.addAll(diagonalMovesOne);
        validMoves.addAll(diagonalMovesTwo);
        validMoves.addAll(diagonalMovesThree);
        validMoves.addAll(diagonalMovesFour);

        ArrayList<Pair> validMovesSearch = validMoves.stream()
                .filter(x -> x.equals(new Pair(y2,x2)))
                .collect(Collectors.toCollection(ArrayList<Pair>::new));

        if (validMovesSearch.size() >= 1){
            return true;
        }else {
            return false;
        }
    }

}