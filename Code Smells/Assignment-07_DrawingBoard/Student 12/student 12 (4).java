import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;

public class DrawingBoard extends NoApplet{
    public DrawingBoard(String[] args){
        super(args);
    }
    public static void main(String[] args){
        new DrawingBoard(new String[] {"width=400", "height=400"}).run();
    }

    protected void paintComponent(Graphics g) {
        //g.setColor(Color.BLACK);
        //g.fillRect(0,0,getWidth(),getHeight());
        Circle circle1 = new Circle(100,100,Color.black, 100);
        circle1.draw(g ,true);
        Triangle triangle = new Triangle(300 ,40 ,Color.BLUE, 30 );
        triangle.draw(g ,true);
        Rectangle rectangle = new Rectangle(200, 200, Color.RED, 20, 50);
        rectangle.draw(g, true);
        g.setColor(Color.BLACK);
        g.drawString("Carlos Cisneros", 150, 70);
    }


}