package noapplet.example;
import noapplet.NoApplet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class GrowingBalloon extends NoApplet implements BalloonsFactory{
    private Dimension dim;
    private Point center;
    private int width, height;
    private Timer timer;

    @Override
    public void init() {
        dim = getSize();
        center = new Point(dim.width / 2, dim.height / 2);
        width = dim.width / 5;
        height = dim.height / 5;
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                width += 6;
                height += 6;
                repaint();
            }
        });
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

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public static void main(String[] args) {
        new GrowingBalloon().run();
    }

	@Override
	public void runthis() {
		new GrowingBalloon().run();
		
	}
}
