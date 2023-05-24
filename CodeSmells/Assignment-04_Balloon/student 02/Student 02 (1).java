package noapplet.example;

import noapplet.NoApplet;

import java.awt.*;
import javax.swing.*;

public class Balloon extends NoApplet {
    protected Timer timer;
    protected int delay = 100;
    protected int offset = 10;
    protected int size = 10;
    protected int x = 190;
    protected int y = 145;

    public void init() {
        timer = new Timer(delay, e-> repaint());
    }
    public Balloon(){

    }

    public void start(){
        timer.start();
    }

    public void stop(){
        timer.stop();
    }

    public void paintComponent(Graphics g) {
        Dimension d = getSize();
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, d.width, d.height);
        size = size + offset;
        x = x - 5;
        y = y - 5;
        g.setColor(Color.BLUE);
        g.fillOval(x, y, size, size);



    }
    public static void main(String[] args) {

        new Balloon().run();
    }
}
