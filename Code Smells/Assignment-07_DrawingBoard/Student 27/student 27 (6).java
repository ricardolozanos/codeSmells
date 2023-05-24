package drawing_board;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import drawing_board.Shape;

class Rectangle extends Shape{
	public Rectangle(int x, int y, Color color) {
		super(x, y, color);
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.fillRect(getX(), getY(), 200, 200);
	}
}
