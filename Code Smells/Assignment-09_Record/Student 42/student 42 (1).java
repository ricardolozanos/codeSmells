package Record;
public class Main {
    public static void main(String[] args){
        Place p = new Place(10,20);
        System.out.println(p.getX() + ", " + p.getY());
        Place other = new Place(10,20);
        System.out.println(p.equals(other));
        System.out.println(p.hashCode());
        System.out.println(other.hashCode());
        System.out.println(p);
        System.out.println(other);
    }
}