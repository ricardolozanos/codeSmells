package noapplet.example;

import noapplet.NoApplet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class ShrinkingBalloon extends NoApplet implements BalloonsFactory{
    private Dimension dim;
    private Point center;
    private int width;
    private int height;
    private int initialW;
    private int initialH;
    private Timer timer;
    private boolean growing;

    @Override
    public void init() {
        dim = getSize();
        center = new Point(dim.width / 2, dim.height / 2);
        initialW = dim.width / dim.width;
        initialH = dim.height / dim.height;
        width = initialW;
        height = initialH;
        timer = new Timer(100, new ActionListener() {
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
                        width = initialW;
                        height = initialH;
                    }
                }
                repaint();
            }
        });
        growing = true;
    }

    @Override
    public void paintComponent(Graphics g) {
    	g.setColor(Color.BLACK);
        dim = getSize();
        center = new Point(dim.width / 2, dim.height / 2);
        g.fillRect(0, 0, dim.width, dim.height);
        g.setColor(Color.RED);
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
        new ShrinkingBalloon().run();
    }

	@Override
	public void runthis() {
		// TODO Auto-generated method stub
		new ShrinkingBalloon().run();
	}
}
