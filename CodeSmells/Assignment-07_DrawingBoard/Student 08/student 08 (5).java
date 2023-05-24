
import java.awt.*;


public class Circle extends Shape{
    protected Circle(int x, int y, Color color) {
        super(x, y, color);
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawOval(getX(),getY(),50,50);
    }
}
