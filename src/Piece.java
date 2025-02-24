import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class Piece extends JLabel implements MouseListener {
    private ImageIcon image;
    private boolean isOrange;
    private boolean pressed;
    private boolean disableCheckMovement;
    private Pair coordinates;

    /**
     * Constructor for piece class
     * @param y y coordinate of piece
     * @param x x coordinate of piece
     */
    protected Piece(int y, int x){
        this.coordinates = new Pair(y,x);
    }

    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    public void setImage(ImageIcon image){
        this.image = image;
    }

    public boolean isOrange() {
        return isOrange;
    }

    public void setOrange(boolean orange) {
        isOrange = orange;
    }

    public ImageIcon getImage() {
        return image;
    }

    /**
     * Sets image of the piece takes 2 images one for each colour piece
     * @param orangeImage Orange version of piece
     * @param yellowImage Yellow version of piece
     */
    public void setImage(ImageIcon orangeImage,ImageIcon yellowImage) {
        if(isOrange()){
            setIcon(orangeImage);
        } else {
            setIcon(yellowImage);
        }
    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        setPressed(true);
        System.out.println("Pressed");
    }

    /**
     * * Invoked when a mouse button has been pressed on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {
    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {
    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(MouseEvent e) {
    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void setCoordinates(int y,int x){
        this.coordinates = new Pair(y,x);
    }

    /**
     * The method which all movement coordinates are ran through and checked against a set of rules within
     * @param movementCoords movement coordinates array
     * @param pieces All pieces on the board
     * @param blankSquares 2d Array of all square on the board
     * @param visualCheck boolean which shows if the activation of checkMovement has been done by displayPieces
     * @return true if valid move , false if invalid move
     */
    public abstract boolean checkMovement(int [] movementCoords, Piece[][] pieces, BlankSquare[][] blankSquares,boolean visualCheck);

}











