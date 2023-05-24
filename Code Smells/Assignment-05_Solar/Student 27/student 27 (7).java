package Solar;

import java.awt.*;
import java.util.*;

public class Planet extends noapplet.AnimationNoApplet{
    private int distance, radius, moonCount;
    private double angle, speed;
    private Color color;
    private Sun sun;
    private java.util.List<Moon> moons;
    
    public Planet(int distance, int radius, double angle, Color color, double speed, Sun sun, int moonCount){
        this.distance = distance;
        this.radius = radius;
        this.angle = angle;
        this.color = color;
        this.speed = speed;
        this.sun = sun;
        this.moonCount = moonCount;
        
        moons = new ArrayList<>();
        if(moonCount == 1) {
        	moons.add(new Moon(40, 4, 0, color.YELLOW, 0.075));
        }
        else if(moonCount == 2) {
        	moons.add(new Moon(40, 4, 0, color.YELLOW, 0.075));
        	moons.add(new Moon(40, 4, 10, color.BLUE, 0.075));
        }
        else if(moonCount == 3) {
        	moons.add(new Moon(50, 3, 0, color.YELLOW, 0.075));
        	moons.add(new Moon(30, 2, 0, color.BLUE, 0.08));
        	moons.add(new Moon(65, 5, 20, color.ORANGE, 0.05));
        }
    }
    
    public void draw(Graphics g){
        var x = sun.getX() + Math.cos(angle) * distance;
        var y = sun.getY() + Math.sin(angle) * distance;
        angle += speed;
        
        g.setColor(color);
        g.fillOval((int)x - radius, (int)y - radius, radius * 2, radius * 2);
        
        if(this.moonCount > 0) {
	        for(var m: moons) {
	        	m.setPlanetX((int)x);
	        	m.setPlanetY((int)y);
	        	m.draw(g);
	        }
        }
    }
    
    
}
