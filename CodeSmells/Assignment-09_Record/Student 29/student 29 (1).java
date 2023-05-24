package noapplet.test;

import java.util.Objects;

public class Place {

	private int x;
    private int y;

    public Place(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof Place)) {
            return false;
        } else {
            Place other = (Place) obj;
            return Objects.equals(x , other.x) && Objects.equals(y, other.y);
        }
    }

    @Override
    public String toString() {
        return "Place X: " + x + ", Y: " + y;
    }
    
    public int getX() {
    	return this.x;
    }

    public int getY() {
    	return this.y;
    }
}
