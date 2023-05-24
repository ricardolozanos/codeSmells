package noapplet.example.BouncingBall;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import noapplet.AnimationNoApplet;

@SuppressWarnings("serial")
public class BouncingBall extends AnimationNoApplet {
	
	private int x, y;
    private int dx = -2, dy = -4;
    private int radius = 20;
    private Color color = Color.GREEN;

    public static void main(String[] args) {
		new BouncingBall().run();
	}

    public void initAnimation() {
        super.initAnimation();
        x = dim.width * 2 / 3;
        y = dim.height - radius;
    }

  
   
}
