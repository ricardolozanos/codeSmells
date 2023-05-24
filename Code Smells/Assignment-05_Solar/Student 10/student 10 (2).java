package noapplet.example.solar;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Sun {
	private final int x;
	private final int y;
	private final int radius;
	private final Color color;
	private final java.util.List<Planet> planets;
	
	public Sun(int x, int y , int radius, Color color) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.color = color;
		//creates an arraylist where planets can be created/added to sun
		planets = new ArrayList<>();
		planets.add(new Planet(20,10,0,Color.green,10, this));
		
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x - radius, y-radius, radius*2, radius*2);
		//draws each of the planets created
		for(var p : planets) {
			p.draw(g);
		}
	}
	
	//returns x
	public int getx() {
		return x;
	}

}
