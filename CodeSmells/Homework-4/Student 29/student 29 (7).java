package omok.gui;

public record OmokPoint( int x, int y, int val) {
	public OmokPoint() {
		this(0,0,0);
	}
	
	@Override
	public String toString() {
		return val + " (" + x + "," + y + ")";
	}
}
