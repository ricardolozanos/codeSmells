package noapplet.DrawingBoard;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {
    protected int x, y;
    protected Color c;

    protected Shape(int x, int y, Color c) {
        this.x = x; this.y = y; this.c = c;
    }

    public abstract void draw(Graphics g);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return c;
    }
}

