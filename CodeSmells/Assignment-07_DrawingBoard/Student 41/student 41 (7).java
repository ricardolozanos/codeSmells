package noapplet;

import java.awt.*;

public class DrawingBoard extends noapplet.AnimationNoApplet{
    Circle c = new Circle(50,100,50,Color.RED,false);
    Rectangle r = new Rectangle(150,225,60,40,Color.blue,false);
    Triangle t = new Triangle(250,350,60,60,Color.GREEN,true);
    public DrawingBoard(){

    }
    @Override
    public void paintComponent(Graphics g) {
        Dimension d = getSize();
        g.clearRect(0,0,d.width,d.height);
        c.draw(g);
        r.draw(g);
        t.draw(g);
        g.setColor(Color.BLACK);
        g.drawString("Gary Turner",170,15);
    }
    public static void main(String[] args) {
        new DrawingBoard().run();
    }
}
