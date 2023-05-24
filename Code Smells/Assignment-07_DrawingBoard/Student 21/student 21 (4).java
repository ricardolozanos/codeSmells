package noapplet.example;

import java.awt.*;

public class Triangle extends Shape{

	protected Triangle(int x, int y, Color c) {
		super(x, y, c);
	}
	public void draw(Graphics g) {
		g.setColor(getColor());
		int x = getX();
		int y = getY();
		int[] z = {100,150,200};
		int[] a = {150,100,150};
		g.fillPolygon(z, a, 3);
	}
}
