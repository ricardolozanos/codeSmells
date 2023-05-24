package Homework;

public class Place {
    private final int x;
    private final int y;

    public Place(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return x == place.x && y == place.y;
    }

    @Override
    public int hashCode() {  
    	   int result = x;
    	   result = result * 37 + y;
    	   return result;
    	}


    @Override
    public String toString() {
        return "Place{" + "x = " + x + ", y = " + y + '}';
    }
    
    //Just to test
    public static void main(String [] args) {
    	Place p = new Place(10, 20);
    	System.out.println(p.x() + ", " + p.y());
    	System.out.println(p.equals(new Place(10,20)));
    	System.out.println(p.hashCode());
    	System.out.println(p);
    }
}

