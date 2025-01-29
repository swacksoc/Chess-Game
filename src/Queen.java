import javax.crypto.spec.OAEPParameterSpec;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Queen extends Piece {
    public Queen(boolean isOrange,int y,int x) {
        super(y,x);
        setOrange(isOrange);
        setImage((new ImageIcon("src/QueenOrange.png")), (new ImageIcon("src/QueenYellow.png")));
        addMouseListener(this);
    }

    @Override
    public boolean checkMovement(int[] movementCoords,Piece[][] pieces,BlankSquare[][] blankSquares){
        int y1 =movementCoords[0];
        int x1 = movementCoords[1];
        int y2 = movementCoords[2];
        int x2 = movementCoords[3];

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
        System.out.println(validMovesSearch.size() + "LIST SIZE");

        if (validMovesSearch.size() >= 1){
            return true;
        }else {
            return false;
        }
    }

}