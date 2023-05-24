package DrawingBoard;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shapes {

	protected Circle(int x, int y, Color color) {
		super(x, y, color);
	}

	@Override
	public void drawShapes(Graphics g) {
		g.setColor(getColor());
		g.drawOval(getX(), getY(), 10*getX(), 10*getX() );
	}
}
