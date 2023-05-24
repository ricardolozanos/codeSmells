package bouncing_Ball;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public abstract class Ball extends BouncingBall implements Bounceable{
	private int x, y;
    private int dx = -2, dy = -4;
    private int radius = 20;
    private Color color = Color.GREEN;
    
    protected Ball(int x, int y, int dx, int dy, int radius, Color color) {
    	this.x = x;
    	this.y = y;
    	this.dx = dx;
    	this.dy = dy;
    	this.radius = radius;
    	this.color = color;
    		
    }
    
    public abstract void draw(Graphics g);
    
    public void collide() {
    	for(Bounceable ball: balls) {
    		CircleBall temp = (CircleBall) ball;
    		double distance = Math.sqrt((temp.getX() - x)*(temp.getX() - x) + (temp.getY() - y) * (temp.getY() - y));
    		if(distance <= (radius + temp.getRadius())) {
    			int tempDx = dx;
    			int tempDy = dy;
    			setDx(temp.getDx());
    			setDy(temp.getDy());
    			temp.setDx(tempDx);
    			temp.setDy(tempDy);
    		}
    	}
    }
    
    public void bounce() {
    	
    	collide();
    	if (x < radius || x > 300 - radius) {
            dx = -dx;
        }
        if (y < radius || y > 300 - radius) {
            dy = -dy;
        }
        x += dx;
        y += dy;
    }
    
    
    
    
    
    public int getX() {
    	return x;
    }
    
    public int getY() {
    	return y;
    }
    
    public int getDx() {
    	return dx;
    }
    
    public int getDy() {
    	return dy;
    }
    
    public int getRadius() {
    	return radius;
    }
    
    public Color getColor() {
    	return color;
    }
    
    public void setDx(int dx) {
    	this.dx = dx;
    }
    
    public void setDy(int dy) {
    	this.dy = dy;
    }
    
    
    
}
