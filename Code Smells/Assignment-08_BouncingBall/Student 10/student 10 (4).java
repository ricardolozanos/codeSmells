package noapplet.example.BouncingBall;

import java.awt.Color;
import java.awt.Graphics;

public class CircleBall extends Ball{
	
	private Color c;

	public CircleBall() {
		super(40, 200, Color.GREEN);
	}
	
	public void draw(Graphics g) {
		g.setColor(c);
		g.drawOval(x, y, 20*2, 20*2);
	}

	@Override
	public void paintcomponent() {
		// TODO Auto-generated method stub
		
	}
}
