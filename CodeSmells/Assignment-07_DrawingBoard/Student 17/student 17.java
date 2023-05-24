import java.awt.*;
import java.awt.geom.Path2D;
import javax.swing.*;

public class DrawingBoard extends JFrame{

    //attributes
    private Shape[] shapes;

    //default constructor
    public DrawingBoard(){
        this.shapes = null;
    }


    //initialize method
    public void init(){
        setTitle("Drawing Board");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        this.shapes = new Shape[] {
            new Circle(100, 100, 110, Color.CYAN),
            new Rectangle(250, 300, 150, 70, Color.PINK),
            new Triangle(400, 400, 120, 120, Color.BLACK)
          };
    }

    //paint method
    @Override
    public void paint(Graphics g){
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.drawString("Reyes G.", 222, 444);

        //for loop to draw every shape
        for (Shape shape: shapes){
            shape.draw(g);
        }
    }
    
    private abstract class Shape extends JFrame{
        
        //attributes
        protected int x, y;
        protected Color color;

        //absatract draw method
        public abstract void draw(Graphics g);
    }


    //Circle object class
    private class Circle extends Shape{

        //attributes
        int radius;


        //constructor 1
        public Circle(int x, int y, int radius, Color color){
            this.x = x;
            this.y = y;
            this.color = color;
            this.radius = radius;
        }


        //draw method
        public void draw(Graphics g){
            g.setColor(color);
            g.fillOval(x, y, radius, radius);
        }
        
    }

    
    //Rectangle object class
    private class Rectangle extends Shape{

        //attributes
        int width, length;

        //constructor 1
        public Rectangle(int x, int y, int length, int width, Color color){
            this.x = x;
            this.y = y;
            this.color = color;
            this.width = width;
            this.length = length;
        }

        //draw method
        public void draw(Graphics g){
            g.setColor(color);
            g.fillRect(x, y, length, width);
        }
    }


    //Triangle object class
    private class Triangle extends Shape{

        //attributes
        int length, height;

        //constructor 1
        public Triangle(int x, int y, int length, int height, Color color){
            this.x = x;
            this.y = y;
            this.color = color;
            this.height = height;
            this.length = length;
        }

        //draw method
        public void draw(Graphics g){
            Graphics2D g2d = (Graphics2D)g;
            g2d.setColor(color);
            Path2D triangle = new Path2D.Double();
            triangle.moveTo(x, y);
            triangle.lineTo(x + length, y);
            triangle.lineTo(x, y + height);
            triangle.closePath();
            g2d.fill(triangle);
        }
    }

    public static void main (String[] args){

        //creating new Drawing board and calling initialize
        DrawingBoard d = new DrawingBoard();
        d.init();
      }
}
