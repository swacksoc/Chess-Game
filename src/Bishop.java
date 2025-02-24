import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static java.lang.Math.sqrt;

public class Bishop extends Piece {
    private boolean disableCheckMovement = false;
    public Bishop(boolean isOrange,int y,int x) {
        super(y,x);
        setOrange(isOrange);
        setImage((new ImageIcon("src/BishopOrange.png")), (new ImageIcon("src/BishopYellow.png")));
        addMouseListener(this);
    }

    @Override
    /**
     * Goes through and checks movement coordinates are within the correct range and then goes through and checks if there
     * is a piece between the start and the end and if there is it returns false and stops movement past that point
     */
    public boolean checkMovement(int[] movementCoords,Piece[][] pieces,BlankSquare[][] blankSquares,boolean visualCheck) {
        int y1 =movementCoords[0];
        int x1 = movementCoords[1];
        int y2 = movementCoords[2];
        int x2 = movementCoords[3];

        //Gets all list of all possible valid moves and then searches to find if any input coordinates are the same
        ArrayList<Pair> diagonalMovesOne = Main.traversal(y1,x1,1,1,pieces);
        ArrayList<Pair> diagonalMovesTwo = Main.traversal(y1,x1,1,-1,pieces);
        ArrayList<Pair> diagonalMovesThree = Main.traversal(y1,x1,-1,1,pieces);
        ArrayList<Pair> diagonalMovesFour = Main.traversal(y1,x1,-1,-1,pieces);

        ArrayList<Pair> validMoves = new ArrayList<>(diagonalMovesOne);
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

