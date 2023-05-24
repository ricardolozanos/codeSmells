package noapplet.example;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape{
	public Circle(int x, int y, Color color) {
		super(x, y, color);
	}
	@Override
	public void Draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(color);
		g.fillOval(x, y, 50, 50);
		
	}

}
