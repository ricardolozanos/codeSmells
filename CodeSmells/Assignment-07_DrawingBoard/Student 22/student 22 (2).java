package noapplet.DrawingBoard;
import java.awt.*;

public class Rectangle extends Shape {
    private final int width;
    private final int height;

    public Rectangle(int x, int y, int width, int height, Color c) {
        super(x, y, c);
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g) {
        g.setColor(c);
        g.drawRect(x - (width / 2), y - (height / 2), width, height);
    }
}