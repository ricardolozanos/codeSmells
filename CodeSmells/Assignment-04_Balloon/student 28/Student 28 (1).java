package noapplet;

import javax.swing.*;
//import java.awt.event.*;
import java.awt.Color;
import java.awt.Dimension;
//import java.awt.Font;
import java.awt.Graphics;
//import java.awt.Graphics2D;

public class Balloon extends NoApplet{
    protected Dimension dim;
    protected int x, y;
    protected int delay = 20; // millis
    protected int offset = 1;
    protected Timer timer;
    protected int radius = 1;
    public void init() {
        // get parameters "delay"
        String att = getParameter("delay");
        if (att != null) {
            delay = Integer.parseInt(att);
        }

        // set the initial position of the text
        dim = getSize();
        x = (dim.width /2) -1;
        y = (dim.height /2) -1;

        // initialize the animation timer
        timer = new Timer(delay, e -> repaint());
    }

    @Override
    protected void paintComponent(Graphics g) {
        x = x - offset;
        y = y - offset;
        radius = radius + 2;

        g.setColor(Color.RED);
        g.fillOval(x, y, radius, radius);
    }
    public void start() {
        timer.start();
    }
    public void stop() {
        timer.stop();
    }

    public static void main(String[] args) {
        new noapplet.Balloon().run();
    }

}
