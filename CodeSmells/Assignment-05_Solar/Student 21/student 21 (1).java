package noapplet.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Create Solar system with sun, planets, and moons
 * @author Dante Lopez
 * Partner: Jesus Oropeza
 */

public class SolarSystem extends AnimationNoApplet{
	protected int distance;
	protected int angle = 0;
	protected int plantWidth = 30;
	protected int radius = 20;
	protected int moonWidth = 10;
	private Color color;
	private int x, y;
	Random rand = new Random();
	private Sun sun;
	private Planet planet;
	private int[] stars = new int[100];

    public SolarSystem(String[] args) {
    	super(args);
    	for(int i = 0; i< 100; i++) {
    		stars[i] = rand.nextInt(500);
    	}
    }
	
    public static void main(String[] args) {
		new SolarSystem(args).run();
	}
    
	protected void initAnimation() {
		super.initAnimation();
		int x = dim.width/2;
		int y = dim.height/2;
		int center = dim.width/2;
		sun = new Sun(x, y, radius, center, Color.YELLOW);

	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
    	g.setColor(Color.BLACK);
    	g.fillRect(0, 0, dim.width, dim.height);
    	
    	g.setColor(Color.WHITE);
    	g.setFont(new Font("San-serif", Font.BOLD, 24));
        g.drawString("Dante Lopez, Jesus Oropeza", 60, 40);
    	
    	g.setColor(Color.WHITE);
    	for(int i = 0; i < 99; i++) {
    		g.fillOval(stars[i], stars[i + 1], 2, 2);
    	}
		
		g.setColor(color);
    	sun.draw(g); 
		
    }
	
}

class Sun {
	private final int x;
	private final int y;
	private final int radius;
	private final Color color;
	private final java.util.List<Planet> planets;
	private final int center;
	
	public Sun(int x, int y, int radius, int center, Color color) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.center = center;
		this.color = color;
		
		int distance = ((int) Math.sqrt(Math.pow((double) x, 2) + Math.pow((double) y, 2))) / 3;
		
		planets = new ArrayList<>();
		planets.add(new Planet(distance, 10, 0, center, Color.BLUE, 10, "Earth"));
		planets.add(new Planet(distance, 20, 200, center, Color.ORANGE, 10, "Vulcan"));
		planets.add(new Planet(distance * 2, 20, 150, center, Color.RED, 20, "Qo'Nos"));

	}
	
	// draw sun
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x - radius, y - radius, radius*2, radius*2);
		
		
		for(var p: planets) {
			p.draw(g);
		}
	}
	
}

class Planet {
	
	private int distance, radius, angle, speed, center;
	
	private Color color;
	
	private final java.util.List<Moon> moons;
	
	protected String planetName;
	
	
	public Planet(int distance, int radius, int angle, int center, Color color, int speed, String planetName) {
		this.distance = distance;
		this.radius = radius;
		this.angle = angle;
		this.color = color;
		this.speed = speed;
		this.center = center;
		
		moons = new ArrayList<>();
		if(planetName == "Earth") {
			moons.add(new Moon(2,0, Color.GRAY, 15, radius));
		}
		if(planetName == "Vulcan") {
			moons.add(new Moon(6,5, Color.GREEN, 10, radius));
		}
		if(planetName == "Qo'Nos") {
			moons.add(new Moon(6,100, Color.GRAY, 10, radius));
			moons.add(new Moon(3,200, Color.RED, 15, radius));

		}
		
	}
	
	// draw planet
	public void draw(Graphics g) {
		angle += speed;
		if(angle == 360) {
			angle = 0;
		}
		var dx = calX();
		var dy = calY();
		
		g.setColor(color);
		g.fillOval(dx - radius, dy - radius, radius * 2, radius * 2);
		
		int planCenterX = dx - radius/2;
		int planCenterY = dy - radius/2;
		
		for(var m: moons) {
			m.draw(g, planCenterX, planCenterY);
		}
	}
	/** Calculate the x coordinate of this planet. */
	private int calX() {
	    // dim: dimension of this planet
	    return (int) (center + distance * Math.cos(Math.toRadians(angle))); // angle in degrees (0-360)
	}
	
	/** Calculate the y coordinate of this planet. */
	private int calY() {
	    // dim: dimension of this planet
	    return (int) (center + distance * Math.sin(Math.toRadians(angle))); // angle in degrees (0-360)
	}
	
}

class Moon {
	private int radius, angle, speed, planRad;
	
	private Color color;
	
	public Moon(int radius, int angle, Color color, int speed, int planRad) {
		this.radius = radius;
		this.angle = angle;
		this.color = color;
		this.speed = speed;
		this.planRad = planRad;
	}
	
	// draw moon
	public void draw(Graphics g, int x, int y) {
		angle -= speed;
		if(angle == 360) {
			angle = 0;
		}
		
		int distance = (((int) Math.sqrt(Math.pow((double) x, 2) + Math.pow((double) y, 2))) / planRad) + planRad;
		var dx = calX(distance, x);
		var dy = calY(distance, y);
				
		g.setColor(color);
		g.fillOval(dx - radius, dy - radius, radius * 2, radius * 2);
	}
	
	/** Calculate the x coordinate of this planet. */
	private int calX(int distance, int center) {
	    // dim: dimension of this planet
	    return (int) (center + distance * Math.cos(Math.toRadians(angle))); // angle in degrees (0-360)
	}
	
	/** Calculate the y coordinate of this planet. */
	private int calY(int distance, int center) {
	    // dim: dimension of this planet
	    return (int) (center + distance * Math.sin(Math.toRadians(angle))); // angle in degrees (0-360)
	}
}
