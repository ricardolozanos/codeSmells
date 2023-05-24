package noapplet.DrawingBoard;
import java.awt.Color;
import java.awt.Graphics;
class Triangle extends Shape{
    public Triangle(int x, int y, Color color){
        super(x,y,color);
    }
    @Override
    public void draw(Graphics g){
        g.setColor(getColor());
        g.drawLine(getX(), getX(), getY(), getY());
        g.drawLine(getY(), getY(), getX()+50, getY()+50);
        g.drawLine(getX()+50, getY()+50, getX(), getX());
    }
}
