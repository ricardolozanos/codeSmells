package noapplet.DrawingBoard;
import noapplet.NoApplet;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawingBoard extends NoApplet {
    private final List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape s) {
        shapes.add(s);
    }
    protected void addName(Graphics g, String name){
        g.setColor(Color.BLACK);
        g.setFont(new Font("Serif", Font.BOLD, 15));
        g.drawString("Made By: " + name, 10, 25);
    }
    public void init() {
        Rectangle rectangle = new Rectangle(100, 100, 100, 50, Color.BLACK);
        addShape(rectangle);
        Circle circle = new Circle(200, 200, 30, Color.BLUE);
        addShape(circle);
        Triangle triangle = new Triangle(300, 300, 100,100,Color.MAGENTA);
        addShape(triangle);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        addName(g, "Alvaro Mendoza");

        for (Shape s : shapes) {
            s.draw(g);
        }
    }

    public static void main(String[] args) {
        new DrawingBoard().run();
    }


}
