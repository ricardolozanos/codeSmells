package noapplet.example.DrawingBoard;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape{

	
	public Circle() {
		super(50, 200, Color.RED);
	}

	public void draw(Graphics g) {
		g.setColor(c);
		g.drawOval(x, y, 50, 50);
	}

}
