package record;

public class Record {
	
	private int x;
	private int y;
	
	//CONSTRUCTORS
	public Record() {
		this(0,0);
	}
	
	public Record(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//EQUALS
	public boolean equals(Object other) {
		 if (this == other) { return true; }
		 if (other == null) { 
			 return false; 
		 }
		 if (getClass() != other.getClass()) { 
			 return false; 
		 }
		 Record otherObj = (Record) other;
		 
		 if(this.getX() != otherObj.getX()) {
			 return false;
		 } else if(this.getY() != otherObj.getY()) {
			 return false;
		 }
		 
		 return true;
	}
	
	//HASHCODE
	public int hashCode() {
		 int result = x;
		 result = result << 8 | y;
		 return result;
	}

	
	//TOSTRING
	 public String toString() {
		return String.format("Point [x=%d, y=%d]", x, y);
	}

	//SETTERS AND GETTERS
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}

}
