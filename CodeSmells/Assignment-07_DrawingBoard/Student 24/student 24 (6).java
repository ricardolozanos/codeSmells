package noapplet;

import java.awt.*;
import java.util.ArrayList;

/**
 * Author: Jesus Oropeza
 */
public class DrawingBoard extends NoApplet {
    protected static java.util.List<Shape> shapes;
    protected Font font = new Font("Monospaced", Font.BOLD, 25);
    @Override
    public void init() {
        super.init();
        shapes = new ArrayList<>();
        shapes.add(new Circle(20, 20, 300, Color.RED));
        shapes.add(new Triangle(250,250, 100, Color.BLUE));
        shapes.add(new Square(100, 200, 200, Color.black));
    }
    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 500,500);
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString(String.format("Jesus Oropeza"), 10, 450);
        for(Shape s: shapes){
            s.draw(g);
        }
    }
    public static void main(String[] args){
        new DrawingBoard().run();
    }
}
