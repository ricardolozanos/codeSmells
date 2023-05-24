import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

public class Rectangle extends Shape{
    private int lenght;
    private int width;
    public Rectangle(int x, int y, Color c, int length, int width) {
        super(x, y, c);
        this.lenght = length;
        this.width = width;
    }

    @Override
    public void draw(Graphics g, boolean fill) {
        g.setColor(getC());
        if(fill){
            g.fillRect(getX(), getY(),lenght, width);
        }else{
            g.drawRect(getX(), getY(),lenght, width);
        }
    }
}