package dboard;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;

import noapplet.example.AnimationNoApplet;

public class Drawingboard extends AnimationNoApplet {
    List<Shape> Shapes = new ArrayList<Shape>();
    @Override
    public void initAnimation() {
        super.initAnimation();
        Shapes.add(new tri(10, 10, Color.BLACK));
        Shapes.add(new sph(100, 100, Color.CYAN));
        Shapes.add(new rect(150, 205, Color.green));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape i: Shapes){
            i.draw(g);
        }
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        g.setColor(Color.pink);
        g.drawString("William Dunlap", 100, 100);
    }
    public static void main(String[] args) {
        new Drawingboard().run();
    }

}


abstract class Shape {
protected int x,y;
protected Color color;

    public Shape() {
}
    abstract void draw(Graphics g);



}
class rect extends Shape{

    public rect(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
}
    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, y, x);
    }
}

class sph extends Shape{

    public sph(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
}
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, y, x);
    }
}

class tri extends Shape{

    public tri(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
}
    public void draw(Graphics g){
        g.setColor(color);
        g.drawLine(x,y,x,y+15);
        g.drawLine(x,y+15,x+15,y+15);
        g.drawLine(x+15,y+15,x,y);
    }
}