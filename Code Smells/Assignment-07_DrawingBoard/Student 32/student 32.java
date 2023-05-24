package noapplet.drawingBoard;

import noapplet.NoApplet;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

public class DrawingBoard extends NoApplet {

    private Timer timer;
    protected int delay = 10;
    protected Dimension dim;
    protected DrawingBoard(){
    }
    protected void initAnimation(){
    }

    protected DrawingBoard(String[] args){
        super(args);
    }
    @Override
    public final void init() {
        dim = getSize();
        initAnimation();
        var delay = getParameter("delay");
        if (delay != null) {
            this.delay = Integer.parseInt(delay);
        }
        timer = new Timer(this.delay, e -> repaint());
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0,0,dim.width, dim.height);
        g.setColor(Color.RED);
        g.drawString("Emilio Rojero", 240, 30);
        ball.draw(g);
        box.draw(g);
        arrow.draw(g);

    }
    circle ball = new circle(50,50,70);
    square box = new square(220, 150, 70);
    Triangle arrow = new Triangle(50);

    public static void main(String[] args){
        new DrawingBoard( new String[] {"width = 330", "height = 350"}).run();
    }

}

abstract class Shape {

    private int x;
    private int y;
    private Color color;
    protected Shape(){
    }
    protected Shape(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public abstract void draw(Graphics g);
    public int getX(){return x;}
    public int getY(){return y;}
    public Color getColor(){return color;}
}
class Triangle extends Shape{
    private int [] x = {100,200,100};
    private int [] y = {150,200,200};
    private int size;

    public Triangle(int size){
        this.size = size;
    }
    public void draw(Graphics g){
        g.setColor(Color.GREEN);
        g.fillPolygon(x, y,3);
    }
}

class circle extends Shape{
    private int x, y;
    private int size;
    public circle(int x, int y, int size){
        this.x = x;
        this.y = y;
        this.size = size;
    }
    public void draw(Graphics g){
        g.setColor(Color.BLUE);
        g.fillOval(x, y, size, size);
    }
}
class square extends Shape{
    private int x,y;
    private int size;
    public square(int x, int y, int size){
        this.x = x;
        this.y = y;
        this.size = size;
    }
    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(x, y, size, size);
    }
}