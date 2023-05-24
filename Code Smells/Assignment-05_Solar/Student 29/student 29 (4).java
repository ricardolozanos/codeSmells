package SolarSystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import javax.swing.Timer;

class Sun {
	private final int x;
	private final int y;
	private final int radius;
	private final Color color;
	//private final List<Planet> planet;
	
	public Sun (int x, int y, int radius , Color color) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.color = color;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void drawSun(Graphics g) { 
		g.setColor(color);
		g.fillOval(this.x - this.radius, this.y - this.radius ,this.radius * 2, this.radius * 2);
	}
}
