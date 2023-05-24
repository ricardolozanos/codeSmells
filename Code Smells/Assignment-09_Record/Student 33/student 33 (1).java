package Misc;
import java.util.Objects;
// Exercise for 2/21/23
class PlaceRun {
    public static void main(String[] args) {
        // Run example
        Place p = new Place(10,20);
        System.out.println(p.getX() + ", " + p.getY());
        System.out.println(p.equals(new Place(10,20)));
        System.out.println(p.hashCode());
        System.out.println(p.toString());
        System.out.println("Exercise by: Francisco A. Roman");
    }
}
public class Place {
    private final int x;
    private final int y;

    public Place (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "int x = " + this.getX() + ", int y = " + this.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Place location = (Place) obj;
        return Objects.equals(x, location.x)
                && Objects.equals(y, location.y);
    }
}
