package DrawingBoard;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Shapes {

	protected Triangle(int x, int y, Color color) {
		super(x, y, color);
	}

	@Override
	public void drawShapes(Graphics g) {
		g.setColor(getColor());
		int[] xc = {getX(), getX()+40, getX()+80};
		int[] yc = {getY(), getY()-80, getY()};
		g.fillPolygon(xc , yc , 3);
	}

}
