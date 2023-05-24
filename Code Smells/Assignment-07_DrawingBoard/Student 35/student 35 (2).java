package drawingBoard;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
	
	public Rectangle(int x, int y, Color c) {
		super(x,y,c);
	}
	
	@Override
	public void drawShape(Graphics g) {
		
		
		g.setColor(getColor());
		g.fillRect(getPosition()[0], getPosition()[1], 30, 50);
		
	}

}
