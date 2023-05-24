package noapplet.example;

public class Place {
    private int x, y;
    public Place(){
        this(0,0);
    }

    public Place(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return String.format("Place [x=%d, y=%d]", x, y);
    }

    @Override
    public boolean equals(Object other){
        if (this == other){
            return true;
        }
        if (other == null){
            return false;
        }
        if (getClass() != other.getClass()){
            return false;
        }
        Place place = (Place) other;
        return true;

    }

    @Override
    public int hashCode(){
        int result = x;
        result = result << 8 | y;
        return result;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static void main(String[] args){
        Place p = new Place(10, 20);
        System.out.println(p.getX() + "," + p.getY());
        System.out.println(p.equals(new Place(10, 20)));
        System.out.println(p.hashCode());
        System.out.println(p.toString());
    }
}
