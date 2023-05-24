package noapplet;

import java.awt.*;

public class Circle extends Shape{
    public Circle(int x,int y,int radius,Color color,boolean filled){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        this.filled = filled;
    }
    @Override
    public void draw(Graphics g){
        g.setColor(this.color);
        g.drawOval(this.x,this.y,this.radius,this.radius);
        if (filled){
            g.fillOval(this.x,this.y,this.radius,this.radius);
        }
    }
}
