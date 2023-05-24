public class Place {
    private final int x;
    private final int y;

    public Place(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Place(){
        this(0,0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Place)) return false;
        Place place = (Place) o;
        return getX() == place.getX() && getY() == place.getY();
    }

    @Override
    public int hashCode() {
        return 31 * x + y * 31 + x * y;
    }

    @Override
    public String toString() {
        return "Place{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String[] args){
        Place p = new Place(30, 25);
        System.out.println(p.getX() + ", " + p.getY());
        System.out.println(p.equals(new Place(10,20)));
        System.out.println(p.hashCode());
        System.out.println(p);
    }
}

