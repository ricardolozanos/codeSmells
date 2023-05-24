package noapplet.example;
import noapplet.NoApplet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Balloon extends NoApplet {
    // Store the dimension of the window
    private Dimension dim;
    // Store the center of the window
    private Point center;
    // Store the width and height of the oval
    private int width, height;
    // Timer for animating the growing oval
    private Timer timer;

    @Override
    public void init() {
        // Get the size of the window
        dim = getSize();
        // Calculate the center of the window
        center = new Point(dim.width / 2, dim.height / 2);
        // Set the initial width and height of the oval to be 1/5 of the window size
        width = dim.width / 5;
        height = dim.height / 5;
        // Create a timer that fires every 100ms, and increase the width and height of the oval by 10 each time
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                width += 4;
                height += 4;
                repaint();
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        // Get the current size of the window
        dim = getSize();
        // Recalculate the center of the window
        center = new Point(dim.width / 2, dim.height / 2);
        // Set the color of the background to black
        g.setColor(Color.BLACK);
        // Fill the background with a black rectangle
        g.fillRect(0, 0, dim.width, dim.height);
        // Set the color of the oval to green
        g.setColor(Color.GREEN);
        // Fill an oval with the given width and height, centered in the window
        g.fillOval(center.x - width / 2, center.y - height / 2, width, height);
    }

    // Start the animation timer
    public void start() {
        timer.start();
    }

    // Stop the animation timer
    public void stop() {
        timer.stop();
    }

    public static void main(String[] args) {
        // Run the BalloonApplet
        new Balloon().run();
    }
}
