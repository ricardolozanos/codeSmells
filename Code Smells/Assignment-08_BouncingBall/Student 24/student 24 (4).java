package noapplet.example;

import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;

public class CircleBall extends Ball{
    public CircleBall(int x, int y, int dx, int dy, int radius, Color color, BouncingBall parent){super(x,y,dx,dy,radius,color,parent);}

    public CircleBall(){}
    @Override
    public void draw(Graphics g){
        int x = getX();
        int y = getY();
        super.movement();
        g.setColor(getColor());
        g.fillOval(x - getRadius(), y - getRadius(), getRadius() * 2, getRadius() * 2);
    }


}
