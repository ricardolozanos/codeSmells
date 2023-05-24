package noapplet.example;

public class Place {
    public int x;
    public int y;
    public Place(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int x() {
        return x;
    }
    public int y(){
        return y;
    }

    @Override
    public String toString() {
        return "Point " + x + ", " + y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }

        if (obj.getClass() == this.getClass()){
            Place p = (Place) obj;
            return p.x == x && p.y == y;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (x * 79) + y;
    }
}
