package noapplet;

import java.awt.*;

public class Rectangle extends Shape{
    public Rectangle(int x,int y,int width,int height, Color color,boolean filled){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.filled = filled;
    }
    @Override
    public void draw(Graphics g){
        g.setColor(color);
        g.drawRect(x,y,width,height);
        if(filled){
            g.fillRect(x,y,width,height);
        }
    }
}
