package SolarSystem;

import java.awt.Color;
import java.awt.Graphics;

public class FixedStar {

	public FixedStar()  {
		// TODO Auto-generated constructor stub
	}
	
	public void drawFixedStar(Graphics g) { 
		//g.setColor(Color.BLACK);             
		//g.fillRect(0, 0, 400, 400);
		g.setColor(Color.WHITE);
		g.fillOval(50, 50, 4, 4);
		g.fillOval(300,350,4,4);
	}

}
