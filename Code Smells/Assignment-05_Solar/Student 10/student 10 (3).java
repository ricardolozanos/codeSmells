package noapplet.example.solar;

import java.awt.Color;
import java.awt.Graphics;

import noapplet.AnimationNoApplet;

@SuppressWarnings("serial")
public class Main extends AnimationNoApplet {
	
	private Sun sun;
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//draws sun
		sun.draw(g);
		//paints my name on screen
		g.drawString("Julieta C.", 120, 180);
	}

	public static void main(String[] args) {
		new Main().run();
	}
	
	
	protected void initAnimation() {
		super.initAnimation();
		//creates sun(calls all other planets along w their moons
		sun = new Sun(dim.width/2, dim.height/2 , 30 , Color.RED);
		
	}

}
