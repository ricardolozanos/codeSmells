package noapplet.DrawingBoard;

import java.awt.*;

public class Triangle extends Shape {
    private final int width;
    private final int height;

    public Triangle(int x, int y, int width, int height, Color c) {
        super(x, y, c);
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g) {
        g.setColor(c);
        int[] xPoints = {x, x + (width / 2), x - (width / 2)};
        int[] yPoints = {y - (height / 2), y + (height / 2), y + (height / 2)};
        g.drawPolygon(xPoints, yPoints, 3);
    }
}
