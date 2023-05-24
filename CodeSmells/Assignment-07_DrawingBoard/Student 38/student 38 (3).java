package noapplet.board;

import java.awt.*;
import java.util.Random;

public class Triangle extends Shape {
    private Color c;
    protected Triangle(int x, int y, Color c) {
        super(x,y,c);
        this.c = c;
    }
    @Override
    public void draw(Graphics g) {
        int x[]={getX(),getX() - 30,getX() + 30};
        int y[]={getY(),getY() + 50,getY() + 50};
        g.setColor(c);
        g.drawPolygon(x,y,3);
    }
}

