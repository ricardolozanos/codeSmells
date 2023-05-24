package noapplet.example;

import java.awt.*;

public abstract class Ball extends AnimationNoApplet implements Bounceable{
    private int x, y, dx, dy, radius;
    private Color c;
    private BouncingBall parent;
    public Ball(){
        this(20,20,1,1,10,Color.green, new BouncingBall(new String[]{}, 0));
    }
    public Ball(int x, int y, int dx, int dy, int radius, Color c, BouncingBall parent){
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.radius = radius;
        this.c = c;
        this.parent = parent;
    }
    public abstract void draw(Graphics g);
    protected void movement(){
        // adjust the position of the ball
        if (x < radius || x > 500 - radius) {
            dx = -dx;
        }
        if (y < radius || y > 500 - radius) {
            dy = -dy;
        }
        // Insert collision code here
        x += dx;
        y += dy;
    }
    protected void collision(){}
    public int getX(){return x;}
    public int getY(){return y;}
    public int getdx(){return dx;}
    public int getdy(){return dy;}
    public void flipX(){dx=-dx;}
    public void flipY(){dy=-dy;}
    public int getRadius(){return radius;}
    public Color getColor(){return c;}

}