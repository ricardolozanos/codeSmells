
import java.awt.*;
public class Triangle extends Shape{
    protected Triangle(int x, int y, Color color) {
        super(x, y, color);
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        int x = getX();
        int y = getY();
        int[] a = {100, 150, 200};
        int[] b = {100,50,100};
        g.fillPolygon(a,b,3);


    }
}
