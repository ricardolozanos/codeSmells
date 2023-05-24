package noapplet.DrawingBoard;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import noapplet.NoApplet;
@SuppressWarnings("serial")
public class DrawingBoard extends NoApplet {
    public DrawingBoard(String[] args) {super(args);}
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        // fill the background
        Dimension d = getSize();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, d.width, d.height);
        g.setFont(new Font("Times New Roman", Font.BOLD, 30));
        g.setColor(new Color(128, 255,255));
        g.drawString("Adrian Urquizo", 100, 30);

        //Create objects
        Shape[] shapes = new Shape[3];
        shapes[0] = new Rectangle(30, 70, Color.BLUE,80, 50);
        shapes[1] = new Circle(150, 100, Color.GREEN, 40);
        shapes[2] = new Triangle(330, 220, Color.RED);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }
    public static void main(String[] args) {
        new DrawingBoard(new String[] {"width=400", "height=400"}).run();
    }
}