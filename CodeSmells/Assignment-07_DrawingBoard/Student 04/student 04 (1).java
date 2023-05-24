package noapplet.assignments.Shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {

    protected Rectangle(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawRect(getX(), getY(), 150, 100);
    }
}
