package noapplet.Balls;

import java.awt.*;
import java.util.ArrayList;

public abstract class Ball implements Bounceable{
    private int x, y;
    private int dx, dy;
    private int radius;

    private Color c;

    protected Ball(int x, int y, int dx, int dy, int radius, Color c) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.radius = radius;
        this.c = c;
    }

    public void bounce() {
        if (x < radius || x > 500 - radius) {
            dx = -dx;
        }
        if (y < radius || y > 500 - radius) {
            dy = -dy;
        }
        x += dx;
        y += dy;
    }
    public abstract void draw(Graphics g);

//    public void isColliding() {
//        for(Bounceable ball: balls) {
//            CircleBall temp = (CircleBall) ball;
//            double distance = Math.sqrt((temp.getX() - x) * (temp.getX()- x) + (temp.getY() - y) * (temp.getY()-y));
//            if(distance <= (radius + temp.getRadius())) {
//                int tempDx = dx;
//                int tempDy = dy;
//                dx = temp.getDx();
//                dy = temp.getDy();
//                setDx(tempDx);
//                setDy(tempDy);
//            }
//        }
//    }

    public Color getColor() {
        return c;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDx(int dx){
        this.dx = dx;
    }

    public void setDy(int dy){
        this.dy = dy;
    }

}
