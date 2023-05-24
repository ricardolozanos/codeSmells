package Balloon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class GrowingShrinkingBalloon extends GrowingBalloon {
	
	public GrowingShrinkingBalloon(int x, int y, int dx, int dy, int rate, Color color) {
		super(x, y, dx, dy, rate, color);
	}

	@Override
	public void draw(Graphics g) {
		Rectangle d = g.getClipBounds();
		g.setColor(color);
		g.fillOval(x-dx/2, y-dy/2, dx, dy);
		doSomething();
		if ( x-dx/2 <= 0 || x+dx/2 >= d.width || dx <= 0 || y-dy/2 <= 0 || y+dy/2 >= d.height || dy <= 0 ) rate *= -1;
		
	}
}
