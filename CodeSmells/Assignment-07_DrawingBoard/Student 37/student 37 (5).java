package noapplet;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Shape {
	Triangle(){
		super(300,275,Color.GREEN);
	}

	@Override
	public void draw(Graphics g) {
		g.translate(getX(), getY());
		g.drawPolygon(new int[] {10, 20, 30}, new int[] {100, 20, 100}, 3);
		g.setColor(getColor());
		g.fillPolygon(new int[] {10, 20, 30}, new int[] {100, 20, 100}, 3);
	}
}
