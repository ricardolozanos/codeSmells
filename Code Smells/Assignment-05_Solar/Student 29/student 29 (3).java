package SolarSystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.Timer;


@SuppressWarnings("serial")
public class SolarSystemMain extends noapplet.AnimationNoApplet {	
	private Dimension dim;
	private Sun TheSun;
	private Planet Earth;
	private Planet Mars;
	private Moon EarthMoon;
	private Moon MarsMoon;
	private int rotationSpeed;
	private FixedStar stars;
	protected Font font =  new java.awt.Font("Sans-serif", Font.BOLD, 24);

	public SolarSystemMain() {
		// TODO Auto-generated constructor stub
		timer = new Timer(100000 , event->repaint());
	}

	protected void initAnimation() {
		super.init();
	}

	@Override
	protected void paintComponent(Graphics g) {	
		super.paintComponent(g);
		
		dim = getSize();
		TheSun = new Sun(dim.width / 2, dim.height / 2, 30, Color.YELLOW);
		TheSun.drawSun(g);
		Earth = new Planet(75, 90+rotationSpeed/2, 10, Color.GREEN , TheSun);
		Earth.drawPlanet(g);
		Mars = new Planet(120, 45+rotationSpeed , 10, Color.RED , TheSun);
		Mars.drawPlanet(g);
		EarthMoon = new Moon(15, 0+2*rotationSpeed,2, Color.PINK, Earth);
		EarthMoon.drawMoon(g);
		MarsMoon = new Moon(20, 0+3*rotationSpeed, 2, Color.ORANGE, Mars);
		MarsMoon.drawMoon(g);
		stars = new FixedStar();
		stars.drawFixedStar(g);
		rotationSpeed += 2;
		g.setFont(font);
		g.setColor(Color.YELLOW);
		g.drawString("Christian Revilla", 0, 20);
	}
	
	
	
	
	public static void main(String[] args) {
		new SolarSystemMain().run();
	}

}
