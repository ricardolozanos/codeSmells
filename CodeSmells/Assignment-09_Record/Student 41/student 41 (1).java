package noapplet;

public class Place {
    protected int x;
    protected int y;
    public Place(int x, int y){
        this.x = x;
        this.y = y;
    }
    protected int x(){
        return this.x;
    }

    protected int y(){
        return this.y;
    }

    public boolean equals(Object other){
        if (this == other) { return true; }

        if (other == null) { return false; }

        if (getClass() != other.getClass()) { return false; }

        Place otherObject = (Place) other;
        return (this.x == otherObject.x() && this.y == otherObject.y());
    }
    public int hashCode(){
        int result = x;
        result = result * 37 + y;
        return result;
    }
    public String toString(){
        return (this.x() + ", " + this.y());
    }
}
