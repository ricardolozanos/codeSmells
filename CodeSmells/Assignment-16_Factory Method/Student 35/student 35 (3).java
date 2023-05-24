package balloon;

import java.awt.Color;
import java.awt.Graphics;

import noApplet.*;

@SuppressWarnings("serial")
public class GrowingBalloon extends AnimationNoApplet implements Balloon {
	
	protected int size, speed;
	protected int [] center = new int[2];
	
	public GrowingBalloon(int size, int speed, String[] args) {
		super(args);
		this.size = size;
		this.speed = speed;
		
		
		
	}
	
	public GrowingBalloon() {
		this(10,1,new String[] {"width=300", "height=300"});
	}
	
	public GrowingBalloon(String[] args) {
		super(args);
	}
	
	public void initAnimation() {
		
		
		center[0] = ((int)dim.width/2) - (Math.round(size/2));
		center[1] = ((int)dim.height/2) - (Math.round(size/2));
		
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, dim.width, dim.height);
		
		
		g.setColor(Color.BLUE);
		g.fillOval(center[0] , center[1], size, size);
		
		size += speed;
		center[0] = ((int)dim.width/2) - (Math.round(size/2));
		center[1] = ((int)dim.height/2) - (Math.round(size/2));
		
	}

}
