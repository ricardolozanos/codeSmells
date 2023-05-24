package Balloon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class GrowingBalloon implements Balloon {
	int dx, dy, x, y, rate;
	Color color;
	
	public GrowingBalloon(int x, int y, int dx, int dy, int rate, Color color ) {
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.rate = rate;
		this.color = color;
	}
	
	@Override
	public void doSomething() {
		dx += rate;
		dy += rate;		
	}

	@Override
	public void draw(Graphics g) {
		Rectangle d = g.getClipBounds();
		
		// Stop growing if balloon reaches full screen
		if ( x-dx/2 <= 0 ) 			rate = 0;
		if ( x+dx/2 >= d.width ) 	rate = 0;
		if ( y-dy/2 <= 0 ) 			rate = 0;
		if ( y+dy/2 >= d.height ) 	rate = 0;
		
		g.setColor(color);
		g.fillOval(x-dx/2, y-dy/2, dx, dy);
		
		doSomething();
	}
}
