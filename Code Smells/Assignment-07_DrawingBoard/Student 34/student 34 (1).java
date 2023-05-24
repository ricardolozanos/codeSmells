package noapplet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;


public class drawingBoard extends NoApplet{

    @Override
    protected void paintComponent(Graphics g) {
        Dimension d = getSize();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, d.width, d.height);
        shape[] shapes = new shape[3];
        shapes[0] = new circle(12, 15, Color.BLACK);
        shapes[1] = new rectangle(45, 47, Color.RED);
        shapes[2] = new triangle(67, 123, Color.GREEN);
        for(shape s: shapes){
            s.drawShapes(g);
        }
    }
    public static void main(String[] args){
        new drawingBoard().run();

    }
}

