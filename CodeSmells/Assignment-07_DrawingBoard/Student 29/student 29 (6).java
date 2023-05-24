package DrawingBoard;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shapes {

	protected Rectangle(int x, int y, Color color) {
		super(x, y, color);
	}

	@Override
	public void drawShapes(Graphics g) {
		g.setColor(getColor());
		g.drawRect(getX(), getY(), 150, 75);
	}

}
