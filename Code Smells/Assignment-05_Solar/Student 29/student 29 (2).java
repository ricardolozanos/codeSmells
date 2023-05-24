package SolarSystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.Timer;

@SuppressWarnings("serial")
public class Planet {
	
	private int x;
	private int y;
	private int distance;
	private int angle;
	private int radius;
	private Color color;
	private Sun sun;
	
	public Planet(int distance, int angle, int radius, Color color, Sun sun) {
		this.distance = distance;
		this.angle = angle;	
		this.radius = radius;
		this.color = color;
		this.sun = sun;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public void drawPlanet(Graphics g) {
		
		// Get coordinates of Sun
		int a = sun.getX();
		int b = sun.getY();
		
		// Find new positions based of angle
		x = a+(int)calX();
		y = b+(int)calY();
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
