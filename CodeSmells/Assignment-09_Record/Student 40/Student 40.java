package src.noapplet.example;

import java.util.Objects;

public class Place{
    private int x;
    private int y;

    public Place(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int x(){
        return x;
    }
    public int y(){
        return y;
    }

    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (o == null){
            return false;
        }
        if(getClass() != o.getClass()){
            return false;
        }
        Place place = (Place) o;
        return x == place.x && y == place.y;

    }

    @Override
    public int hashCode(){
        return Objects.hash(x,y);
    }
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }


}
class Main{

    public static void main(String [] args){
        Place p = new Place(10, 20);
        System.out.println(p.x() + ", " + p.y());
        System.out.println(p.equals(new Place(10,20)));
        System.out.println(p.hashCode());
        System.out.println(p); // toString() is called
    }
}