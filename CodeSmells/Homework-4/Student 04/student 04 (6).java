package HW4_GUI.console;

/**
 * The Coordinate class represents a point in 2D space with integer x and y coordinates.
 */
public class Coordinate {
    private int x;
    private int y;

    /**
     * Constructs a new Coordinate with the given x and y coordinates.
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x coordinate of this Coordinate.
     * @return the x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the x coordinate of this Coordinate.
     * @param x the new x coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Returns the y coordinate of this Coordinate.
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y coordinate of this Coordinate.
     * @param y the new y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Returns a String representation of this Coordinate.
     * The String has the format "(x, y)".
     * @return a String representation of this Coordinate
     */
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
