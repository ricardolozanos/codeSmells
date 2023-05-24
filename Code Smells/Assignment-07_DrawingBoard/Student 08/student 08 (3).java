
import java.awt.*;


public class Square extends Shape{

    protected Square(int x, int y, Color color) {
        super(x, y, color);
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawRect(getX(),getY(),50,50);
    }
}

