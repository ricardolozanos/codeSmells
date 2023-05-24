package noapplet.example.solar;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Planet   {
	private int distance, radius, angle, speed,y,x;
	private Color color;
	private Sun sun;
	private final java.util.List<Moon> moons;

	public Planet(int distance, int radius, int angle, Color color, int speed, Sun sun) {
		this.distance = distance;
		this.radius = radius;
		this.angle = angle;
		this.color = color;
		this.speed = speed;
		this.sun = sun;
		x=0;
				
		 //creates moon list
		moons = new ArrayList<>();
		moons.add(new Moon(5,15,0,Color.blue,20, this));
		 
		 
	}
	
	
	//draws the moving planet w moons
	public void draw(Graphics g) {
		angle+=1;
		x = calx();
		g.setColor(color);
		//i was  not able to figure out the formula for the y coordinate, it was confusing
		g.fillOval(x, 10, radius*2,radius*2);
		
		for(var m : moons) {
			m.draw(g);
		}
		
	}
	
	//calculates the x coordinate for the planet
	private int calx() {
		int center = sun.getx();
		return (int)(center+distance*Math.cos(Math.toRadians(angle)));
	}

	public int getx() {
		// TODO Auto-generated method stub
		return x;
	}
	

	
	
}
