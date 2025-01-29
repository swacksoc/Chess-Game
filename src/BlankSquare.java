import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BlankSquare extends JPanel implements MouseListener {
    private boolean pressed = false;
    private boolean multiplePieces =false;
    private boolean isBlack = false;
    private Pair coordinates;
    public BlankSquare(Color colour){
        setVisible(true);
        setOpaque(true);
        setColour(colour);
        if (colour == Color.black){
            isBlack = true;
        }
        addMouseListener(this);

    }

    public boolean isBlack() {
        return isBlack;
    }

    public void setColour(Color colour) {
        setBackground(colour);
    }

    public boolean hasMultiplePieces() {
        return multiplePieces;
    }

    public void setMultiplePieces(boolean multiplePieces) {
        this.multiplePieces = multiplePieces;
    }

    public boolean isPressed() {
        return pressed;
    }
    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }
    public Pair setCoordinates(int y,int x){
        return new Pair(y,x);
    }
    public Pair getCoordinates(){
        return coordinates;
    }
    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if ((getComponentCount() == 0|| getComponentCount() == 1)) {
            setPressed(true);
        }else if ((getComponentCount() == 2)) {
            setMultiplePieces(true);
        }
    }
    /**
     * Invoked when a mouse button has been pressed on a component.
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been released on a component.
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
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
}
