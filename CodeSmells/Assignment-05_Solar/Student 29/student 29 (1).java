package SolarSystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.Timer;

public class Moon {
	
	private int distance;
	private int angle;
	private int radius;
	private Color color;
	private Planet planet;
	
	public Moon(int distance , int angle, int radius , Color color, Planet planet) {
		this.distance = distance;
		this.angle = angle;
		this.radius = radius;
		this.color = color;
		this.planet = planet;
	}
	
	public void drawMoon(Graphics g) {
		
		// Get position of planet 
		int a = planet.getX();
		int b = planet.getY();
		
		// Calculate the angle and add
		int x = a+(int)calX();
		int y = b+(int)calY();
		g.setColor(color);
		g.fillOval((int) x - radius  , (int) y - radius , this.radius*2, this.radius*2);	
	}
	
	private double calX( ) {
		return this.distance * Math.cos(Math.toRadians(this.angle));
	}
	
	private double calY() {
		return this.distance * Math.sin(Math.toRadians(this.angle));
	}
	

}
