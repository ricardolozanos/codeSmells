package noapplet.example;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape{
	protected int x;
	protected int y;
	protected Color color;
	
	protected Shape(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;				
	}
	public abstract void Draw(Graphics g);
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Color getColor() {
		return color;
	}
}
