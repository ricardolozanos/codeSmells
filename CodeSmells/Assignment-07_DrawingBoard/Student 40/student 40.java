package src.noapplet.example;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.awt.geom.Path2D;
import java.security.cert.TrustAnchor;
import java.util.ArrayList;

public class DrawingBoard extends AnimationNoApplet {
    private final java.util.List<Shape> shapes;



    public void initAnimation() {
        setSize(300,300);



    }

    public DrawingBoard() {
        shapes = new ArrayList<>();

        shapes.add(new Rectangle (10,10,Color.BLUE));
        shapes.add(new Circle(200,200 ,Color.RED));
        shapes.add(new Triangle(45,130, Color.GREEN));


    }

    public static void main(String[] args) {
        new DrawingBoard().run();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawString("Samantha Silva", 100,300);
        for (Shape s : shapes) {
            s.draw(g);
        }


    }

    public abstract class Shape {

        protected int x;
        protected int y;
        private Color c;

        protected Shape(int x, int y, Color c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }

        /*Note that the class does not provide any implementation for draw(); basically
        there is no code, and this is what makes the method abstract (providing any code would
        make the method concrete). There are two reasons why there is no implementation.
            First, Shape does not know what to draw, so we could not implement the draw() method
        even if we wanted to.*/

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
    //Note that both Circle and Rectangle extend (that is, inherit from) Shape.
    /*If Circle/Rectangle does indeed fail to implement a draw() method, Circle will
    be considered abstract itself. Thus, yet another subclass must inherit from Circle
    and implement a draw() method. This subclass would then become the concrete implementation
    of both Shape and Circle.*/
    public class Rectangle extends Shape{
        protected Rectangle(int x, int y, Color c) {
            super(x, y, c);
        }

        public void draw(Graphics g){
            g.setColor(Color.BLUE);
            g.getColor();
            g.drawRect(x, y,240 ,110);
        }
    }

    public class Circle extends Shape{
        private int radius = 50;

        protected Circle(int x, int y, Color c) {
            super(x, y, c);
        }


        public void draw(Graphics g){
            g.setColor(Color.RED);
            g.getColor();
            g.drawOval(x - radius, y - radius, radius * 2, radius * 2);

        }
    }
    public class Triangle extends Shape{

        protected Triangle(int x, int y, Color c) {
            super(x, y, c);
        }


        public void draw(Graphics g) {
            Graphics2D g2d = (Graphics2D)g;
            g2d.setColor(Color.GREEN);
            g2d.getColor();
            Path2D triangle = new Path2D.Double();
            triangle.moveTo(x,y);
            triangle.lineTo(x + 120, y);
            triangle.lineTo(x, y + 120);
            triangle.closePath();
            g2d.fill(triangle);




            //g.fillPolygon(new int[] {75, 60, 190}, new int[] {200, 325, 325}, 3);

        }
    }
}



