package drawingBoard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Triangle extends Shape {
	
	public Triangle(int x, int y, Color c) {
		super(x,y,c);
	}
	
	@Override
	public void drawShape(Graphics g) {
		
		int[] x = {0 + getPosition()[0], 25 + getPosition()[0], 50 + getPosition()[0]};
		int[] y = {50 + getPosition()[1], 0 + getPosition()[1], 50 + getPosition()[1]};
		
		Polygon p = new Polygon(x, y, 3);
		g.setColor(getColor());
		g.fillPolygon(p);
		
	}

}
