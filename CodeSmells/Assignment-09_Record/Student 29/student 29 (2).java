package noapplet.test;

public class PlaceRunner {
	
	// Testing the record keyword 
	public record RecordPlace(int x , int y) {}

	public static void main(String[] args) {
		
		// Place from the class
		Place p = new Place(10, 20);
		System.out.println(p.getX() + " , " + p.getY());
		System.out.println(p.equals(new Place(10,20)));
		System.out.println(p.hashCode());
		System.out.println(p); // toString() is called

		System.out.println();
		
		// Record keyword 
		RecordPlace t = new RecordPlace(20,30);
		System.out.println(t.x() + " , " + t.y());
		System.out.println(t.equals(new RecordPlace(20,30)));
		System.out.println(t.hashCode());
		System.out.println(t); // toString() is called

	}

}
