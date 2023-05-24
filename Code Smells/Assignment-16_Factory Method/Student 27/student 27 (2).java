package bouncing_Ball;

import java.awt.Color;
import java.awt.Graphics;

public class GrowingBalloon {
	private int diameter;
	private int growthRate;
	private int height;
	private int width;
	
	public GrowingBalloon(int diameter, int growthRate, int height, int width){
		this.diameter = diameter;
		this.growthRate = growthRate;
		this.height = height;
		this.width = width;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
        int centerX = this.width / 2 - this.diameter / 2;
        int centerY = this.height / 2 - this.diameter / 2;
        g.fillOval(centerX, centerY, this.diameter, this.diameter);

        this.diameter += this.growthRate;
	}
}
