package noapplet.assignments.Shapes;
import java.awt.*;

public class Circle extends Shape {
    protected Circle(int x, int y, Color color) {
        super(x, y, color);
    }
    @Override
    public void draw(Graphics g){
        g.setFont(new Font("San-serif", Font.BOLD, 20));
        g.setColor(Color.BLACK);
        g.drawString("Diego Jared Avina", 200, 40);
        g.setColor(getColor());
        g.drawOval(getX(), getY(), 100, 100);
    }   
}
 