package noapplet.DrawingBoard;

import noapplet.NoApplet;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class DrawingBoard extends NoApplet {
    private java.util.List<Shape> shapes;

    public DrawingBoard(){
        shapes = new ArrayList<>();
        shapes.add((new Rectangle(100, 100, Color.BLUE, 70, 90)));
        shapes.add((new Circle(190, 150, Color.RED, 90, 90)));
        shapes.add((new Triangle(50, 200, Color.GREEN, 120, 120, -50, -80)));
    }
    public void init(){
        super.init();
    }

    @Override
    protected void paintComponent(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0,0, getWidth(), getHeight());
        g.setColor(Color.RED);
        g.setFont(new Font("San-serif", Font.BOLD, 12));
        g.drawString("Jordan Aguon", 0, 20);
        for (Shape s: shapes) {
            s.draw(g);

        }
    }

    public static void main(String[] args){
        new DrawingBoard().run();
    }
}

abstract class Shape {
    private int x, y;
    private Color c;

    protected Shape(int x, int y, Color c){
        this.x = x;
        this.y = y;
        this.c = c;
    }
    public abstract void draw(Graphics g);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return c;
    }

}
class Circle extends Shape{
    private int width;
    private int height;

    protected Circle(int x, int y, Color c, int width, int height) {
        super(x, y, c);
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g){
        g.setColor(getColor());
        g.drawOval(getX(), getY(), width, height);
    }
}
class Rectangle extends Shape{
    private int width;
    private int height;

    protected Rectangle(int x, int y, Color c, int width, int height) {
        super(x, y, c);
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawRect(getX(), getY(), width, height);
    }
}

class Triangle extends Shape {
    private int width;
    private int height;
    private int startAngle;
    private int arcAngle;

    protected Triangle(int x, int y, Color c, int width, int height, int startAngle, int arcAngle) {
        super(x, y, c);
        this.width = width;
        this.height = height;
        this.startAngle = startAngle;
        this.arcAngle = arcAngle;
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillArc(getX(), getY(), width, height, startAngle, arcAngle);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(getX(), getY() + 100, width, height/4);
    }
}