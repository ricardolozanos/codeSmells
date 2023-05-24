package noapplet.example;

/**
 * 
 * @author Dante
 *
 */

public class Record {
	private int x,y;

	public Record (int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if (getClass() != o.getClass()) {
			return false;
		}
		Record q = (Record) o;
		if(x == q.getX() && y == q.getY()) {
			return true;
		}
		return false;
	}

	public int hashCode() {  
		int a = 0;
		a = a << 8 | x;
		a = a << 8 | y;
		return a;
	}

	public String toString() {
		return String.format("Point [x=%d, y=%d]", x, y);
	}
	
	public static void main(String[] args) {
		Record e = new Record(10,20);
		Record d = new Record(30,50);
		Record w = new Record(10,20);
		System.out.println(e);
		System.out.println(e.equals(d));
		System.out.println(e.hashCode());
		System.out.println(w.hashCode());
	}
}
