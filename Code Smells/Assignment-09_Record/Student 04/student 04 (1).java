package noapplet.assignments;

public class Place {
    private final int x;    
    private final int y;    

    public Place(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Place)) return false;
        // treating o as a Place object
        Place place = (Place) o;
        return getX() == place.getX() && getY() == place.getY();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + getX();
        result = 31 * result + getY();
        return result;
    }


    @Override
    public String toString() {
        return "Place{" + "x=" + x + ", y=" + y + '}';
    }


    public class Main{
        public static void main(String[] args) {
            Place p = new Place(10, 20);
            System.out.println(p.getX() + ", " + p.getY());
            System.out.println(p.equals(new Place(10,30)));
            System.out.println(p.hashCode());
            System.out.println(p); // toString() is called

        }
    }
}

