
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import noapplet.NoApplet;

public class DrawingBoard extends NoApplet {
    protected java.util.List<Shape> shapes;
    @Override
    public void init() {
        super.init();
        shapes = new ArrayList<>();
        shapes.add(new Square(50,50,Color.red));
        shapes.add(new Circle(200,200,Color.BLUE));
        shapes.add(new Triangle(300,300,Color.GREEN));
    }

    protected void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0,0,500,500);
        g.setFont(new Font("San-serif", Font.BOLD, 24));
        g.setColor(Color.BLACK);
        g.drawString("Marc Buster", 90, 35);
        for(Shape s: shapes) {
            s.draw(g);
        }
    }

    public static void main(String[] args) {
        new DrawingBoard().run();
    }
}

