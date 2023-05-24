package noapplet.example.DrawingBoard;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
	
	public Rectangle() {
		super(240, 8, Color.BLUE);
	}

	public void draw(Graphics g) {
		g.setColor(c);
		g.drawRect(x, y, 19, 13);
	}
}
