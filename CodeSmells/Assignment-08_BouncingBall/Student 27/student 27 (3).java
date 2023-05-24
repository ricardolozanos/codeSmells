package bouncing_Ball;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.Timer;

import noapplet.NoApplet;
import java.awt.*;
import java.util.*;
import java.util.Random;

@SuppressWarnings("serial")
public class BouncingBall extends noapplet.AnimationNoApplet{
    protected java.util.List<Bounceable> balls = new ArrayList<>();
    private Color color = Color.green;
    private int numOfBalls = 3;
    
    protected BouncingBall(String[] args) {
    	super(args);
    }
    
    protected BouncingBall() {
    	
    }

    public void initAnimation(){
    	super.initAnimation();
    	Random rand = new Random();
    	for(int i = 0; i < numOfBalls; i++) {
    		balls.add(new CircleBall(rand.nextInt(dim.width), rand.nextInt(dim.width), -2, -4, 10, color));
    	}
    }
    
    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	g.setColor(Color.BLACK);
        g.fillRect(0, 0, dim.width, dim.height);
    	for(var v: balls) {
    		v.draw(g);
    		v.bounce();
    	}
    }
    
    public static void main(String[] args) {
		// generates new window size to fit my computer
		new BouncingBall(new String[] {"width=300", "height=300"}).run();
	}
}

