package noapplet.example.Balloon;

import noapplet.NoApplet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class GrowingShrinkingBalloon extends NoApplet implements BalloonInterface{
    private Dimension dim;
    private Point center;
    private int width, height;
    private int initialWidth, initialHeight;
    private Timer timer;
    private boolean growing;
    @Override
    public void init() {
        dim = getSize();

        center = new Point(dim.width / 2, dim.height / 2);

        initialWidth = dim.width / dim.width;
        initialHeight = dim.height / dim.height;

        width = initialWidth;
        height = initialHeight;
        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (growing) {
                    width += 5;
                    height += 5;
                    if (width >= dim.width || height >= dim.height) {
                        growing = false;
                    }
                } else {
                    width -= 5;
                    height -= 5;
                    if (width <= 0 || height <= 0) {
                        growing = true;
                        width = initialWidth;
                        height = initialHeight;
                    }
                }
                repaint();
            }
        });
        growing = true;
    }

    @Override
    public void paintComponent(Graphics g) {
        dim = getSize();
        center = new Point(dim.width / 2, dim.height / 2);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, dim.width, dim.height);
        g.setColor(Color.GREEN);
        g.fillOval(center.x - width / 2, center.y - height / 2, width, height);
    }

    @Override
    public void start() {
        timer.start();
    }

    @Override
    public void stop() {
        timer.stop();
    }
    public static void main(String[] args) {
        new GrowingShrinkingBalloon().run();
    }
    public void runnable() {
        new GrowingShrinkingBalloon().run();
    }
}
