/**
 * A class to represent a pair of coordinates
 * @author Edward Tickle
 */
public class Pair {
    int x;
    int y;

    /**
     * Constructor for pair class
     * @param y y coordinate
     * @param x x coordinate
     */
    public Pair(int y,int x){
        this.y = y;
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pair){
            if (((Pair) obj).getX() == getX() && ((Pair) obj).getY() == getY()){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 31 * getX() * getY();
    }
}
