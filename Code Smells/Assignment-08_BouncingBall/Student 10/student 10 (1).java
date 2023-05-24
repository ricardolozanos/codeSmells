package noapplet.example.BouncingBall;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

public abstract class Ball implements Bounceable {
	protected int x;
	protected int y;
    private int dx = -2, dy = -4;
    private int radius = 20;
    private Color c;
    public static final List<Ball> balls;

	
	protected Ball(int x,int y, Color c) {
		this.x=x;
		this.y=y;
		this.c=c;
	}
	
	public abstract void draw(Graphics g);
	
	public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 400, 400);
        if (x < radius || x > 400 - radius) {
            dx = -dx;
        }
        if (y < radius || y >400 - radius) {
            dy = -dy;
        }
        x += dx;
        y += dy;
        
        
        for( Ball ball:balls) {
        	ball.draw(g);
        }
    }


}
