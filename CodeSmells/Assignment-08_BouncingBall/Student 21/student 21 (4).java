package noapplet.example;

import java.awt.*;

public class CircleBall extends Ball{
	public CircleBall(int x, int y, int dx, int dy, int radius, Color color) {
		super(x, y, dx, dy, radius, color);
	}
    
	@Override
    public void draw(Graphics g) {
    	super.movement();
    	g.setColor(getColor());
    	g.fillOval(getX() - getRadius(), getY() - getRadius(), getRadius() * 2, getRadius() * 2);
	}

}
