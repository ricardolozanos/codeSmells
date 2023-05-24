package bouncing_Ball;

import java.awt.Color;
import java.awt.Graphics;

public class CircleBall extends Ball implements Bounceable{
	public CircleBall(int x, int y, int dx, int dy, int radius, Color color) {
		super(x, y, dx, dy, radius, color);
	}
	
	
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.fillOval(getX(), getY(), getRadius() * 2, getRadius() * 2);
	}
}

/*
public void update() {
	
}

public void collide(Ball otherBall) {
	int distanceX = getX() - otherBall.getX();
	int distanceY = getY() - otherBall.getY();
	int distanceSqr = distanceX * distanceX + distanceY * distanceY;
	int radiusSum = getRadius() + otherBall.getRadius();
	if(distanceSqr <= radiusSum * radiusSum) {
		int tempDx = getDx();
		int tempDy = getDy();
		setDx(otherBall.getDx());
		setDy(otherBall.getDy());
		otherBall.setDx(tempDx);
		otherBall.setDy(tempDy);
	}
}

@Override
public void draw(Graphics g) {
	bounce();
	for(Bounceable ball: balls) {
		for(Bounceable otherBall: balls) {
			if(ball != otherBall) {
				ball.collide(otherBall);
			}
		}
			
	}
	g.setColor(getColor());
	g.fillOval(getX(), getY(), getRadius() * 2, getRadius() * 2);
}
*/
