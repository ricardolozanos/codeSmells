package noapplet.example;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape{
	protected Rectangle(int x, int y, Color color) {
		super(x, y, color);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void Draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, 60, 40);
	}
}
