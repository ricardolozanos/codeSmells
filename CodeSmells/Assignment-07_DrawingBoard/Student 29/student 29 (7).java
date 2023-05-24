package DrawingBoard;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shapes {
	
	private int x;
	private int y;
	private Color color;

	protected Shapes(int x , int y , Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public abstract void drawShapes(Graphics g); 

}
