import java.util.Hashtable;
public class Place{
    private final int x;
    private final int y;
    public Place(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Place(){
        this(0,0);
    }
    public int x(){ return this.x; }
    public int y() { return this.y; }

    public String toString(){
        return String.format("Point [x = %d, y = %d]", x, y);
    }

    public boolean equals(Object obj){
        if(this == obj) { return true; }

        if(obj == null) { return false; }

        if(getClass() != obj.getClass()) { return false; }

        Place p = (Place) obj;

        return x == p.x && y == p.y;
    }

    public int hashCode(){
        return 31 * x + y * 31 + x * y;
    }

    public static void main(String[] args){
        Place p = new Place(10, 20);
        System.out.println(p.x() + ", " + p.y());
        System.out.println(p.equals(new Place(10,20)));
        System.out.println(p.hashCode());
        System.out.println(p);
    }
}
