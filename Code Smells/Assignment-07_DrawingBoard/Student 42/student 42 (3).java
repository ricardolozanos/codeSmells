package noapplet.DrawingBoard;
import java.awt.Color;
import java.awt.Graphics;
class Rectangle extends Shape{
    private int width, height;
    public Rectangle(int x, int y, Color color, int width, int height){
        super(x,y,color);
        this.width = width;
        this.height = height;
    }
    @Override
    public void draw(Graphics g){
        g.setColor(getColor());
        g.drawRect(getX(), getY(), width, height);
    }
}