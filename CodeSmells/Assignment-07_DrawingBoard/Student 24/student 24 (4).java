package noapplet;

import java.awt.*;
/**
 * Author: Jesus Oropeza
 */
public class Triangle extends Shape{
    protected Triangle(int x, int y, int size, Color color) {
        super(x, y, size, color);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        int x = getX();
        int y = getY();
        int size = getIzeSay();
        g.drawLine(x,y,x+(size/2),y-size);
        g.drawLine(x,y,x+size,y);
        g.drawLine(x+(size/2),y-size, x+size,y);
    }
}
