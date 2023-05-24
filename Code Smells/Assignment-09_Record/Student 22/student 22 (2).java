package noapplet.Record;
import noapplet.Record.Place;
import java.util.Objects;
public class Record {
    public static void main(String[] args) {
        Place p = new Place(10, 20);
        System.out.println(p.toString());
        Place p2 = p.newX(30);
        //using p2 toString now
        System.out.println(p2.toString());
        //using p2 equals now
        System.out.println(p.equals(p2));
        //using p2 x and y now
        System.out.println(p2.x());
        System.out.println(p2.y());
        //using p2 hashCode now
        System.out.println(p.hashCode());
        //using p2 newY now
        Place p3 = p2.newY(40);
        System.out.println(p3.toString());


    }

}

