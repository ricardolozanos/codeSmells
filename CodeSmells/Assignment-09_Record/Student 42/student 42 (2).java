package Record;
public class Place {
    private int x, y;
    public Place(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {return x;}
    public int getY() {return y;}
    @Override
    public boolean equals(Object other) {
        if (this == other) {return true;}
        if (other == null) {return false;}
        if (getClass() != other.getClass()) {return false;}
        Place otherObj = (Place) other;
        if (this.x == otherObj.getX() && this.y == otherObj.getY()) {
            return true;
        }
        return false;
    }
    @Override
    public int hashCode() {
        int result = x;
        result = result * 37 + y;
        return result;
    }
    @Override
    public String toString() {
        return "x=" + x + ", y=" + y;
    }
}