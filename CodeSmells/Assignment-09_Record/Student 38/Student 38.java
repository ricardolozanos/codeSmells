import java.util.Objects;

//Class version of example provided to us
public class Place{
    private final int x;
    private final int y;
    //Constructor to replace Place p = new Place(10, 20);
    public Place(int x, int y) {
        this.x = x;
        this.y = y;
    }
    //Replacements for System.out.println(p.x() + ", " + p.y());
    public int x() {
        return x;
    }
    public int y() {
        return y;
    }
    //Equals method similar to one provided to us, System.out.println(p.equals(new Place(10,20));
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Place place = (Place) obj;
        return x == place.x && y == place.y;
    }
    //toString method System.out.println(p);
    @Override
    public String toString() {
        return "Place{" + "x=" + x + ", y=" + y + '}';
    }
    //hashCode method System.out.println(p.hashCode());
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
