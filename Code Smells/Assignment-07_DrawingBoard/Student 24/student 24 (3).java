package noapplet;

import java.awt.*;
/**
 * Author: Jesus Oropeza
 */
public class Square extends Shape{
    protected Square(int x, int y, int size, Color color) {
        super(x, y, size, color);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawRect(getX(),getY(),getIzeSay(), getIzeSay());
    }
}
