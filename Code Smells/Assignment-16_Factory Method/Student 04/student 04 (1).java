package exercises.FactoryMethod;

import noapplet.NoApplet;
import java.awt.*;

public class Balloon extends NoApplet {
    int x, y, size;

    public Balloon() {
        super();
        init();
    }

    public Balloon(String[] params) {
        super(params);
        init();
    }

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
                Thread.sleep(30);
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
        new Balloon().run();
    }
}