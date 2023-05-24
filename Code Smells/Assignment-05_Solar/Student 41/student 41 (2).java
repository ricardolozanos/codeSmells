package noapplet;

import javax.swing.*;
import java.awt.*;

public class SolarSystem extends noapplet.AnimationNoApplet{
    protected Timer timer;

    Sun sun = new Sun((400/2)-50/2,(400/2)-50/2,50);
    Planet a = new Planet(sun, 70, 15, 2, Color.green);
    Planet b = new Planet(sun, 120, 12, 1, Color.red);
    Planet c = new Planet(sun, 170, 20, 1, Color.orange);
    Moon a1 = new Moon(a, 30,5, 2,Color.white);
    Moon b1 = new Moon(b, 30,5, 2,Color.lightGray);
    Moon b2 = new Moon(b, 20,6, 3,Color.gray);


    public SolarSystem(){
        timer = new Timer(20, event -> repaint());
    }
    @Override
    public void start() {
        timer.start();
    }

    @Override
    public void stop() {
        timer.stop();
    }


    @Override
    public void paintComponent(Graphics g) {
        Dimension d = getSize();
        g.clearRect(0,0,d.width,d.height);
        g.setColor(Color.BLACK);
        g.fillRect(0,0,d.width,d.height);
        a1.paintComponent(g);
        b1.paintComponent(g);
        b2.paintComponent(g);
        a.paintComponent(g);
        b.paintComponent(g);
        c.paintComponent(g);
        sun.paintComponent(g);
        g.drawString("Gary Turner",170,12);
    }
    public static void main(String[] args) {
        new SolarSystem().run();
    }
}
