package noapplet.bouncingBallEx;

import noapplet.AnimationNoApplet;
import noapplet.NoApplet;

import java.awt.*;

abstract class ball extends AnimationNoApplet {
    protected int x, y, dx, dy;
    protected int radius;

    protected Color color;
    public ball() {

    }
    public ball(int x, int y, int dx, int dy, int radius, Color color){
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.radius = radius;
        this.color = color;
    }

    public abstract void drawBalls(Graphics g);

}
