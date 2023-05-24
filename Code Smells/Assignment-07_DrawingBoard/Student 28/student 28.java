package noapplet;


import java.awt.*;
import java.util.*;
import java.util.List;

public class DrawingBoard extends NoApplet{
    private List<Shape> shapes = new ArrayList<>();

    public void init(){
        Shape circle = new Circle(10, 20, Color.RED);
        Shape rec = new Rectangle(110, 150, Color.BLUE);
        Shape tri = new Triangle(270, 250, Color.GREEN);
        shapes.add(circle);
        shapes.add(rec);
        shapes.add(tri);
    }
    @Override
    protected void paintComponent(Graphics g){
        g.setFont(new Font("San-serif", Font.BOLD, 12));
        g.setColor(Color.MAGENTA);
        g.drawString("Nayeli Ramirez", 80, 350);

        for(Shape s: shapes){
            s.draw(g);
        }
    }
    public void start() {}
    public void stop() {}
    public static void main(String[] args) {
        new noapplet.DrawingBoard().run();
    }

}
abstract class Shape {
    private int x, y;
    private Color c;
    protected Shape(int x, int y, Color c) {
        this.x = x; this.y = y; this.c = c;
    }
    public abstract void draw(Graphics g); // no def. here!
    public int getX() { return x; }
    public int getY() { return y; }
    public Color getColor() { return c; }

}
class Circle extends Shape{
    protected Circle(int x, int y, Color c){
        super(x, y, c);
    }
    public void draw(Graphics g){
        g.setColor(getColor());
        g.drawOval(getX(), getY(), 80, 80);
    }
}

class Rectangle extends Shape{
    protected Rectangle(int x, int y, Color c){
        super(x, y, c);
    }
    public void draw(Graphics g){
        g.setColor(getColor());
        g.drawRect(getX(), getY(), 120, 80);
    }

}
class Triangle extends Shape{
    protected Triangle(int x, int y, Color c){
        super(x, y, c);
    }
    public void draw(Graphics g){
        g.setColor(getColor());
        g.fillPolygon(new int[]{getX(), getX()-70, getX()+70}, new int[]{getY(), getY()+130, getY()+130}, 3);
    }
}

