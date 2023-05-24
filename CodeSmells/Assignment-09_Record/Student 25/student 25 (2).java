import java.util.Objects;

public class recordsAssignment{
  public static void main (String[] args){
    placeRecords p = new placeRecords(10, 20);
    System.out.println(p.x() + ", " + p.y());
    System.out.println(p.equals(new placeRecords(10, 20)));
    System.out.println(p.hashCode());
    System.out.println(p);

  }
}
