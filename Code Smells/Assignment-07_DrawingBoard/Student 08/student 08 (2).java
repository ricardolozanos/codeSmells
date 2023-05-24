
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;


public abstract class Shape {
    private int x, y;
    private Color color;

    protected Shape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public abstract void draw(Graphics g);
    public int getX() {return x;}
    public int getY() {return y;}
    public Color getColor() {return color;}
}
