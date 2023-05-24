package noapplet;

public class placeTest {
    public static void main(String[] args){
        Place p = new Place(10, 20);
        System.out.println(p.x() + ", " + p.y());
        System.out.println(p.equals(new Place(10,20)));
        System.out.println(p.hashCode());
        System.out.println(p); // toString() is called
    }
}
