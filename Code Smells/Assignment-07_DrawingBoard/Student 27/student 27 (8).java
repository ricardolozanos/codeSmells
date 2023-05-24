package drawing_board;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import drawing_board.Shape;

class Triangle extends Shape{
	public Triangle(int x, int y, Color color) {
		super(x, y, color);
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		int [] arr1 = new int[] {getX(), getX() + 100, getX() + 200};
		int [] arr2 = new int[] {getY(), getY() - 150, getY()};
		g.fillPolygon(arr1, arr2, 3);
	}
}
