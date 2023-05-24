// Author: Christian Revilla
// Student ID: 80580582

package noapplet.example;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class BalloonAnimation2 extends BalloonAnimation1{

	protected Boolean ControlGrowth = true;
	
	public BalloonAnimation2() {
		// TODO Auto-generated constructor stub
	}
	
	protected void paintComponent(Graphics g) {
		// Balloon is as big as screen so next frame should shrink
		if (diam == dim.width) {
			ControlGrowth = false;
		// Balloon is the smallest therefore next frame should grow
		} else if (diam <= 0) {
			ControlGrowth = true;
		}
		// Check Boolean to see if balloon should shrink or grow
		if (ControlGrowth == true) {
			diam += offset;
		} else {
			diam -= offset;
		}

		// set the pen color and draw the background 
		g.setColor(Color.BLACK);             
		g.fillRect(0, 0, dim.width, dim.height);    

		// set the pen color and then draw the text
		g.setColor(Color.GREEN);             
		g.fillOval(x-diam/2, y-diam/2, diam, diam);            
	}	
	
	public static void main(String[] args) {
		new BalloonAnimation2().run();
	}
	

}
