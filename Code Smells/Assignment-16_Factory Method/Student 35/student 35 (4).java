package balloon;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class GrowingShrinkingBalloon extends GrowingBalloon {

	public GrowingShrinkingBalloon() {
		super();
	}
	
	public GrowingShrinkingBalloon(int size, int speed, String [] args) {
		super(size,speed,args);
	}
	
	public GrowingShrinkingBalloon(String[] args) {
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
		
		if(center[0] == 0 || center[1] == 0 || center[0] == ((int)dim.width/2) || center[1] == ((int)dim.height/2)) {
			speed = -speed;
		} 
		
	}
}
