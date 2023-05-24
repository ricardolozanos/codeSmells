package noapplet.example.DrawingBoard;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape{
	protected int x,y;
	protected Color c;
	
	protected Shape(int x,int y, Color c) {
		this.x=x;
		this.y=y;
		this.c=c;
	}

	public abstract void draw(Graphics g);


}
