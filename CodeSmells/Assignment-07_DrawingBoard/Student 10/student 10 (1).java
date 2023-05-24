package noapplet.example.DrawingBoard;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Shape{
	
	public Triangle() {
		
		super(180, 100, Color.GREEN);
	}

	public void draw(Graphics g) {
		g.setColor(c);
		int xpoints[] = {x, x+60, x-60 };
	    int ypoints[] = {y, y+100, y+100 };
	    int npoints = 3;

	    g.fillPolygon(xpoints, ypoints, npoints);
	}

}
