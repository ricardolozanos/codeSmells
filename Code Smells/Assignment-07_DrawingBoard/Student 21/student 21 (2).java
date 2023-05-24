package noapplet.example;

import java.awt.*;

public class Rectangle extends Shape{

	protected Rectangle(int x, int y, Color c) {
		super(x, y, c);
	}
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawRect(getX(), getY(), 100, 100);
	}
}
