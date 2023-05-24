package drawingBoard;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {

	private int [] position = new int[2];
	private Color color;
	
	
	protected Shape(int x, int y, Color c) {
		 this.getPosition()[0] = x; 
		 this.getPosition()[1] = y; 
		 this.color = c;
	}
	
	protected Shape() {
		
	}
	
	public abstract void drawShape(Graphics g);

	public Color getColor() {
		return color;
	}

	public int [] getPosition() {
		return position;
	}

	
}
