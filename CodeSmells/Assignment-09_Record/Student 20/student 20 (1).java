import java.util.Objects;

public class Place {
    private final int x;
    private final int y ;

    public Place(int x, int y){
        this.x = x;
        this.y = y;
    }
    public static void main(String[] args) {
        Place p = new Place(30, 10);
        System.out.println(p.x() + ", " + p.y());
        System.out.println(p.equals(new Place(10,20)));
        System.out.println(p.hashCode());
        System.out.println(p);
    }

    public int x() {
        return x;
    }
    public int y(){
        return y;
    }
    @Override
    public String toString(){
        return ("Place [x=" + this.x + ", y=" + this.y + "]");
    }
    @Override
    public int hashCode(){
        return  Objects.hash(x,y);
    }
    @Override
    public boolean equals(final Object o){
        if(this == o){
            return  true;
        }
        if(getClass() != o.getClass()){
            return false;
        }
        if (o == null){
            return false;
        }
        if (o instanceof Place){
            Place p = (Place) o;
            return (x == p.x && y == p.y);
        }
        return false;
    }
}