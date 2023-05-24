package noapplet.DrawingBoard;

import java.awt.*;

public class Circle extends Shape {
    private final int radius;

    public Circle(int x, int y, int radius, Color c) {
        super(x, y, c);
        this.radius = radius;
    }

    public void draw(Graphics g) {
        g.setColor(c);
        g.drawOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}
