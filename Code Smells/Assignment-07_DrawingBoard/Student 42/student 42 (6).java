package noapplet.DrawingBoard;
import java.awt.Color;
import java.awt.Graphics;
class Circle extends Shape {
    private int radius;
    public Circle(int x, int y, Color color, int radius){
        super(x,y,color);
        this.radius = radius;
    }
    @Override
    public void draw(Graphics g){
        g.setColor(getColor());
        g.drawOval(getX(),getY(),radius*2, radius*2);
    }
}