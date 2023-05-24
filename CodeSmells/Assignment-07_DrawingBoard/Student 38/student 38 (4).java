package noapplet.board;

import java.awt.*;

public class Circle extends Shape {
    private Color c;
    protected Circle(int x, int y, Color c) {
        super(x, y, c);
        this.c = c;
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(c);
        g.drawOval(getX(),getY(),50,50);
    }
}
