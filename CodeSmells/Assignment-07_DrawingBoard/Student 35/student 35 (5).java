package drawingBoard;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {
	
	public Circle(int x, int y, Color c) {
		super(x,y,c);
	}
	
	@Override
	public void drawShape(Graphics g) {
		
		
		g.setColor(getColor());
		g.fillOval(getPosition()[0], getPosition()[1], 30, 30);
		
	}
	
}
