package noapplet.assignments.Shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Shape {

    protected Triangle(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        int[] x = { getX(), getX() + 100, getX() + 50 };
        int[] y = { getY() + 100, getY() + 100, getY() };
        g.fillPolygon(x, y, 3);
    }
}
