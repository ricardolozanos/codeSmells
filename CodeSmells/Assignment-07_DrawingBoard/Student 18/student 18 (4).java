package noapplet.example;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Shape{
	protected Triangle(int x, int y, Color color) {
		super(x, y, color);
	}
	@Override
	public void Draw(Graphics g) {
		int[] arrx= new int[] {x,x-50,x+50};
		int[] arry = new int[] {y,y+150,y+150};
		g.setColor(color);
		g.fillPolygon(arrx, arry, 3);
	}
}
