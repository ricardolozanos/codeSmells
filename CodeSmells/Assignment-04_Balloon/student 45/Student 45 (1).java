// Author: Christian Revilla
// Student ID: 80580582

package noapplet.example;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Calendar;

import javax.swing.Timer;

@SuppressWarnings("serial")
public class BalloonAnimation1 extends noapplet.AnimationNoApplet {
	
	protected int diam;         
	protected Dimension dim; 
	protected int x, y;            
	protected int delay = 1;      
	protected int offset = 1;
	protected Timer timer; 

	public BalloonAnimation1() {
		timer = new Timer(delay , event->repaint());
	}
	
	public BalloonAnimation1(String[] params) {
		super(params);
		timer = new Timer(delay , event->repaint());
	}	
	
	public void init() {
		// get parameters "delay"  
		String att = getParameter("delay");
		if (att != null) {
			delay = Integer.parseInt(att);
		}

		// set the initial position of the balloon
		dim = getSize();
		x = dim.width/2;
		y = dim.height/2;

		// initialize the animation timer
		timer = new Timer(delay, e -> repaint());
	}
	
	protected void paintComponent(Graphics g) {
		// adjust the position of the balloon from the previous frame
		diam += offset;
		
		// set the pen color and draw the background 
		g.setColor(Color.BLACK);             
		g.fillRect(0, 0, dim.width, dim.height);    

		// set the pen color and then fill the balloon
		g.setColor(Color.GREEN);             
		g.fillOval(x-diam/2, y-diam/2, diam, diam);            
	}	
	
	public static void main(String[] args) {
		new BalloonAnimation1(args).run();
	}

	

}
