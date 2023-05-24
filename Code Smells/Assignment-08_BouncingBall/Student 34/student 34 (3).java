package noapplet.bouncingBallEx;
import noapplet.AnimationNoApplet;
import noapplet.*;
import noapplet.NoApplet;
import java.awt.Dimension;


import java.awt.*;

public class circleBall extends ball {
    public circleBall(int x, int y, int dx, int dy, int radius, Color color){
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.radius = radius;
        this.color = color;
    }


    public void drawBalls (Graphics g){

            // adjust the position of the ball
        if (x < radius || x > dim.width - radius) {
                dx = -dx;
        }
        if (y < radius || y > dim.height - radius) {
                dy = -dy;
        }
        x += dx;
        y += dy;

            // draw the ball and dump the off-screen image
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

}

