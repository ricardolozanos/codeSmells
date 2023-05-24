package src.noapplet.example;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

import static java.awt.geom.Path2D.intersects;
import static java.lang.Math.*;

public class CircularBall extends Ball {

    protected CircularBall(int x, int y, int dx, int dy) {
        super(x, y, dx, dy);

    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
    @Override
    public void checkCollision(Bounceable ball) {
        Area x = getArea();
        Area BallArea = ball.getArea();
        x.intersect(BallArea);
        if (!x.isEmpty()){
            dx += -1;
            dy += -1;
        }

    }


    public Area getArea(){
        final int d = 2 * radius;
        return new Area(new Ellipse2D.Float(x - radius, y - radius,d,d));
    }

    public void bounce() {
        if ((x < radius || x > 300 - radius)) {
            dx = -dx;
        }
        if (y < radius || y > 300 - radius) {
            dy = -dy;
        }


        x += dx;
        y += dy;
    }


}
