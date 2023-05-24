package noapplet;

public class RecordE {

	public record Place (int x, int y) {
		
		public boolean equals() {
			if(y == x) {
				return true;
			}
			else {
				return false;
			}
		}
		
		public int x() {
			return x;
		}
		public int y() {
			return y;
		}
		
		
	}

	// Example use
	public static void main(String[] args) {
		
		Place p = new Place(10, 20);
		System.out.println(p.x() + ", " + p.y());
		System.out.println(p.equals(new Place(10,20)));
		
    }
}
