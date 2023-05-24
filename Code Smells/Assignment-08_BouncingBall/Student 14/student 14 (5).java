package BouncingBall;

import BouncingBall.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;
import noapplet.example.AnimationNoApplet;

public abstract class ball extends AnimationNoApplet implements bouncable {
    private Color color;
    private int radius;
    private int x, y;
    private int dx, dy;
    private BouncingBall parent;

    public ball(){
        this(20,20,1,1,10,Color.green, new BouncingBall(new String[]{}, 0));
    }

    public ball(int x, int y, int dx, int dy, int radius, Color color, BouncingBall parent) {
        this.x=x;
        this.y=y;
        this.dx=dx;
        this.dy=dy;
        this.radius=radius;
        this.color=color;
        this.parent = parent;

    }

    public void movement(Graphics g) {
        // adjust the position of the ball
        if (x < radius || x > parent.w - radius) {
            dx = -dx;
        }
        if (y < radius || y > parent.h - radius) {
            dy = -dy;
        }
        x += dx;
        y += dy;

    }

    public void flipx(){
        dx=-dx;
    }
    public void flipy(){
        dy=-dy;
    }

    public Color getColor() {
        return color;
    }
    public int getx(){
        return x;
    }
    public int gety(){
        return y;
    }
    public int getraid(){
        return radius;
    }

    public abstract void paint(Graphics g);

}
