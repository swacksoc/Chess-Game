import javax.swing.*;
import java.awt.*;

/**
Chess Board Class
 **/
public class Board extends JFrame {
    private final BlankSquare [][] blankSquares = new BlankSquare[8][8];
    private final Piece [][] pieces = new Piece[8][8];

    public Piece[][] getPieces(){
        return pieces;
    }
    public BlankSquare[][] getBlankSquares() {
        return blankSquares;
    }

    /**
     * Constructor for the Board Class
     * @param title  Window Title
     * @param width  Width of Board
     * @param height Height of board
     */
    public Board(String title, int width, int height) {
        setVisible(true);
        setTitle(title);
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 8));
        buildGrid();
        createPieces();
        addPiecesToScreen();
    }

    /**
     * Creates an Array of BlankSquare's to visually represent chessboard and adds to JFrame
     */
    public void buildGrid() {

        int j = 0;
        int k = 0;
        boolean kReset = false;

        for (int i = 0; i < 64; i++) {
            kReset = false;
            System.out.println(i);


            if (k % 2 == 0) {
                if (j % 2 == 0) {

                    blankSquares[j][k] = new BlankSquare(Color.BLACK);
                } else {

                    blankSquares[j][k] = new BlankSquare(Color.WHITE);
                }

            } else {
                if (j % 2 == 0) {

                    blankSquares[j][k] = new BlankSquare(Color.WHITE);
                } else {

                    blankSquares[j][k] = new BlankSquare(Color.BLACK);
                }
            }

            add(blankSquares[j][k]);
            blankSquares[j][k].setCoordinates(j,k);


            if (k == 7 && j != 7) {
                k = 0;
                kReset = true;
                j++;
            }

            if (!kReset) {
                k++;
            }
        }
    }

    /**
     * Adds Pieces to an array representing their layout on the board
     */
    public void createPieces() {
        //Adding Pawns
        for (int i = 0; i <= 7; i++) {
            pieces[1][i] = new Pawn(false,1,0);
            pieces[6][i] = new Pawn(true,6,i);

        }

        //Adding Castles
        pieces[0][0] = new Castle(false,0,0);
        pieces[0][7] = new Castle(false,0,7);
        pieces[7][0] = new Castle(true,7,0);
        pieces[7][7] = new Castle(true,7,7);
        //Adding Kings
        pieces[0][4] = new King(false,0,4);
        pieces[7][4] = new King(true,7,4);


        //Adding Queens
        pieces[0][3] = new Queen(false,0,3);
        pieces[7][3] = new Queen(true,7,3);

        //Adding Bishops
        pieces[0][2] = new Bishop(false,0,2);
        pieces[0][5] = new Bishop(false,0,5);
        pieces[7][2] = new Bishop(true,7,2);
        pieces[7][5] = new Bishop(true,7,5);

        //Adding Rooks
        pieces[0][1] = new Knight(false,0,1);
        pieces[0][6] = new Knight(false,0,6);
        pieces[7][1] = new Knight(true,7,1);
        pieces[7][6] = new Knight(true,7,6);


        }



    /**
     * Adds images from pieces to the screen
     **/
    public void addPiecesToScreen() {
        int j = 0;
        int k = 0;
        for (int i = 0; i < 64; i++) {
            boolean reset = false;
            if (pieces[k][j] != null) {
                blankSquares[k][j].removeAll();
                blankSquares[k][j].add(pieces[k][j]);
            }
            if (j == 7) {
                k++;
                j = 0;
                reset = true;
            }
            if (!reset) {
                j++;
            }

        }
    }

    /**
     * Moves pieces from y1 x1 to y2 x2 on the board
     * @param coordsArray Movement coords array representing current position and future position
     */
    public void movePieces(int[] coordsArray){
        int yCoordOne = coordsArray[0];
        int xCoordOne = coordsArray[1];
        int yCoordTwo = coordsArray[2];
        int xCoordTwo = coordsArray[3];

        Piece temp = pieces[yCoordOne][xCoordOne];
        temp.setCoordinates(yCoordTwo,xCoordTwo);
        pieces[yCoordOne][xCoordOne] = null;
        pieces[yCoordTwo][xCoordTwo] = temp;
        addPiecesToScreen();
        repaint();
    }

}


