package noapplet.example.solar;

import java.awt.Color;
import java.awt.Graphics;

public class Moon   {
	private int distance, radius, angle, speed;
	private int y;
	private Color color;
	private Planet planet;

	public Moon(int distance, int radius, int angle, Color color, int speed, Planet planet) {
		this.distance = distance;
		this.radius = radius;
		this.angle = angle;
		this.color = color;
		this.speed = speed;
		this.planet = planet;		 
		 

	}
	
	public void draw(Graphics g) {
		//the angle should only go up to 360 so i should have included a conditional but since i couldnt figure out the y coordinate i havent added it 
		angle+=1;
		var x = calx();
		g.setColor(color);
		//was not able to figure out y coordinate(as previously mentioned)
		g.fillOval(x, 20, radius*2,radius*2);
		
	}
	
	//calculates x coordinate for the moon 
	private int calx() {
		int center = planet.getx();
		return (int)(center+distance*Math.cos(Math.toRadians(angle)));
	}
	
}