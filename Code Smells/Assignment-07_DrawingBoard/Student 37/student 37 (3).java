package noapplet;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
	Rectangle(){
		super(150,150,Color.BLUE);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawRect(getX(), getY(), 100, 50);
		
	}
}
