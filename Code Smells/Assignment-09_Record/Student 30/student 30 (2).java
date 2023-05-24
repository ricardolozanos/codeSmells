public class PlaceTest {
    public static void main(String [] args){

        Place p = new Place(10, 20);
        System.out.println(p.getX()+","+p.getY());
        System.out.println(p.equals(new Place(10,20)));
        System.out.println(p.hashCode());
        System.out.println(p);

    }

}
