package noapplet;

import java.awt.*;
/**
 * Author: Jesus Oropeza
 */
public class Circle extends Shape{

    protected Circle(int x, int y, int size, Color color) {
        super(x,y,size,color);
    }

    @Override
    public void draw(Graphics g){
        g.setColor(getColor());
        g.drawOval(getX(), getY(),getIzeSay(),getIzeSay());
    }
}
