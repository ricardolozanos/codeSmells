package BouncingBall;

import java.awt.Color;
import java.awt.Graphics;

public class CircleBall extends Ball{

	protected CircleBall(int x, int y, int dx, int dy, int radius, Color color) {
		super(x, y, dx, dy, radius, color);
	}

	@Override
	public void drawBall(Graphics g, Ball[] b) {
		
        for ( Ball x:b) {
        	g.setColor(x.getColor());
        	g.fillOval(x.getX() - x.getRadius(), x.getY() - x.getRadius(), x.getRadius() * 2, x.getRadius() * 2);	
        }
        checkCollision(g, b);
        //bounceBallOffBall(g,b);
	}
	
	public void checkCollision(Graphics g, Ball[] b) {
		// arrays to hold values...
		int[] x = new int[b.length];
		int[] y = new int[b.length];
		int[] r = new int[b.length];
		//setup boolean array
		Boolean[] fx = new Boolean[b.length];
		Boolean[] fy = new Boolean[b.length];
		//get the position of the balls and their size
		for (int i=0; i<b.length; ++i) {
			x[i] = b[i].getX();
			y[i] = b[i].getY();
			r[i] = b[i].getRadius();
			fx[i]= false;
			fy[i]= false;
		}
		
		// n: check if x collision
		// m: check if y collision
		int n, m;
		
		for (int i=0; i<b.length; ++i)
			for (int j=i+1; j<b.length; ++j) {
				n = x[i] - x[j];
				m = y[i] - y[j];
				if (n<0) n = -n;
				if (m<0) m = -m;
				if ( (n<r[i] || n<r[j]) && (m<r[i] || m<r[j]) ) {
					fx[i] = true;
					fy[i] = true;
					fx[j] = true;
					fy[j] = true;
				}
			}
		// check for collision against the wall
		for ( int i=0; i<b.length; ++i) {
			if (x[i] < r[i] || x[i] > 400 - r[i]) {
				fx[i] = true;
			}
			if (y[i] < r[i] || y[i] > 400 - r[i]) {
				fy[i] = true;
			}
		}
		// if collision with anything (other ball, wall) reverse direction...
		for (int i=0; i<b.length; ++ i) {
			if ( fx[i] ) b[i].setDx(-b[i].getDx());
			if ( fy[i] ) b[i].setDy(-b[i].getDy());
			//update to new position...
			b[i].setX(b[i].getX()+b[i].getDx());
			b[i].setY(b[i].getY()+b[i].getDy());
		}
		
	}


}
