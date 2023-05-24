package noapplet.example;
import noapplet.AnimationNoApplet;
import noapplet.NoApplet;
import noapplet.example.solar.Main;

import java.awt.*;
import java.util.ArrayList;


public class DrawingBoard extends NoApplet {
    final ArrayList<Shape> Shapes = new ArrayList<Shape>();

    public static void main(String[] args) {
        new DrawingBoard().run();
    }

    public void init(){
        Shapes.add(new Circle(75,75,Color.red));
        Shapes.add(new Rectangle(150,150,Color.orange));
        Shapes.add(new Triangle(190,210,Color.BLUE));
    }

    @Override
    protected void paintComponent(Graphics g){
        g.setFont(new Font("San-serif", Font.BOLD, 24));
        g.setColor(Color.orange);
        g.drawString("Francisco A. Roman",20,20);

        for(Shape s: Shapes){
            s.Draw(g);
        }
    }
}

abstract class Shape{
    int X;
    int Y;
    Color Color;

    public Shape(int x, int y, Color color){
        X = x;
        Y = y;
        Color = color;
    }
    public abstract void Draw(Graphics g);
}

class Circle extends Shape{
    public Circle(int x, int y, Color color){
        super(x, y, color);
    }

    @Override
    public void Draw(Graphics g){
        g.setColor(Color);
        g.fillOval(X, Y, 60,60);
    }
}

class Rectangle extends Shape{
    public Rectangle(int x, int y, Color color){
        super(x, y, color);
    }

    @Override
    public void Draw(Graphics g){
        g.setColor(Color);
        g.fillRect(X,Y,90, 40);
    }
}

class Triangle extends Shape{
    public Triangle(int x, int y, Color color){
        super(x, y, color);
    }

    @Override
    public void Draw(Graphics g){
        g.setColor(Color);
        int size = 21;
        g.drawPolygon(new int[] {X, X+size, X+size*2}, new int[] {Y+size*2, Y, Y+size*2}, 3);
        g.fillPolygon(new int[] {X, X+size, X+size*2}, new int[] {Y+size*2, Y, Y+size*2}, 3);
    }
}
