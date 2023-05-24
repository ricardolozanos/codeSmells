package noapplet.example;

import java.awt.*;

public class Circle extends Shape{

	protected Circle(int x, int y, Color c) {
		super(x, y, c);
	}
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawOval(getX(), getY(), 100, 100);
	}
}
