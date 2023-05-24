package noapplet.board;

import java.awt.*;

public class Rectangle extends Shape {
    private Color c;
    protected Rectangle(int x, int y, Color c) {
        super(x, y, c);
        this.c = c;
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(c);
        g.drawRect(getX(),getY(),50,50);
    }
}
