package noapplet.assignments;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import noapplet.NoApplet;

public class Balloon extends NoApplet {
    public Balloon(){
    }

    public Balloon(String[] params){
        super(params);
    }

    int x, y, size;

    public void init() {
        setBackground(Color.white);
        x = getSize().width / 2;
        y = getSize().height / 2;
        size = 10;
    }

    public void start() {
        while (true) {
        repaint();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        size += 10;
        if (size >= getSize().width) {
            break;
        }
        }
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(x - size / 2, y - size / 2, size, size);
    }
    public static void main(String[] args) {
        new Balloon(new String[] {"width=350", "height=350"}).run();
    }
}
