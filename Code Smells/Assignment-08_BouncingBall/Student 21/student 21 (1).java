package noapplet.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Rectangle;

public abstract class Ball implements Bounceable{
	protected int x, y, dx, dy, radius;
	protected Color c;
	protected Ball(int x, int y, int dx, int dy, int radius, Color c) {
		this.x = x;
		this.y = y; 
		this.dx = dx;
		this.dy = dy;
		this.radius = radius;
		this.c = c;
	}
	public abstract void draw(Graphics g);
	protected void movement() {
		if (x < radius || x > 500 - radius) {
    		dx = -dx;
    	}
    	if (y < radius || y > 500 - radius) {
    	    dy = -dy;
    	}
    	    
    	x += dx;
    	y += dy;
	}
	
	//area of a shaped for collision
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getdx() {
		return dx;
	}
	public int getdy() {
		return dy;
	}
	public int getRadius() {
		return radius;
	}
	public Color getColor() {
		return c;
	}
	
	public void flipx() {
		dx = -dx;
	}

	public void flipy() {		
		dy = - dy;
	}

	List<Bounceable> b = new ArrayList<Bounceable>();

	public void det(List<Bounceable> in){
		this.b = in;
	}
	
	public void Collision(){
		for (Bounceable i : b){
			for (Bounceable j : b){
				if (i == j){

	            }
	            else if (getbounds(i).intersects(getbounds(j))) {
	            	i.flipx();
	                i.flipy();
	            }
	        }
	    }
	}

	public Rectangle getbounds(Bounceable i){
		int offset= i.getRadius();
	    return new Rectangle(i.getX()-offset, i.getY()-offset, offset*2, offset*2);

	}
}
