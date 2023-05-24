package drawing_board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import drawing_board.Shape;

public class Circle extends Shape{
	public Circle(int x, int y, Color color) {
		super(x, y, color);
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.fillOval(getX(), getY(), 200, 200);
	}
}
