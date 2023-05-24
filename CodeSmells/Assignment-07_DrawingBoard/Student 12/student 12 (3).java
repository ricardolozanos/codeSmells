import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

public class Circle extends Shape{
    private int diameter;
    public Circle(int x, int y, Color c, int diameter) {
        super(x, y, c);
        this.diameter = diameter;
         
    }

    @Override
    public void draw(Graphics g, boolean fill) {
        g.setColor(getC());
        if(fill){
            g.fillOval(getX(), getY(),diameter, diameter);
        }else{
            g.drawOval(getX(), getY(),diameter, diameter);
        }
    }
}
