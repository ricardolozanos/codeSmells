package noapplet.example;

import noapplet.NoApplet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Balloon2 extends NoApplet {

    // instance variables to store the size of the applet window and the center point
    private Dimension dim;
    private Point center;

    // instance variables to store the width and height of the balloon
    private int width, height;

    // instance variables to store the initial width and height of the balloon
    private int initialWidth, initialHeight;

    // instance variable to store a timer to control the animation
    private Timer timer;

    // instance variable to store whether the balloon is growing or not
    private boolean growing;

    @Override
    public void init() {
        // get the size of the applet window
        dim = getSize();

        // calculate the center point of the window
        center = new Point(dim.width / 2, dim.height / 2);

        // initialize the initial width and height to be 1/5 of the window size
        initialWidth = dim.width / 5;
        initialHeight = dim.height / 5;

        // set the current width and height to be the initial width and height
        width = initialWidth;
        height = initialHeight;

        // create a timer that triggers every 100 milliseconds and calls an actionPerformed method
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // check if the balloon is growing
                if (growing) {
                    // increase the width and height by 10
                    width += 10;
                    height += 10;

                    // check if the width or height has reached the size of the window
                    if (width >= dim.width || height >= dim.height) {
                        // set growing to false, indicating that the balloon should start shrinking
                        growing = false;
                    }
                } else {
                    // decrease the width and height by 10
                    width -= 10;
                    height -= 10;

                    // check if the width or height has reached 0
                    if (width <= 0 || height <= 0) {
                        // set growing to true, indicating that the balloon should start growing again
                        growing = true;

                        // set the width and height back to the initial values
                        width = initialWidth;
                        height = initialHeight;
                    }
                }
                // call repaint to redraw the balloon with its new size
                repaint();
            }
        });
        // set growing to true, indicating that the balloon should start growing
        growing = true;
    }

    @Override
    public void paintComponent(Graphics g) {
        // get the size of the applet window
        dim = getSize();

        // calculate the center point of the window
        center = new Point(dim.width / 2, dim.height / 2);

        // set the color to black and fill the background of the applet window
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, dim.width, dim.height);
        // set the color to red and draw the balloon at the center of the window
        g.setColor(Color.GREEN);
        g.fillOval(center.x - width / 2, center.y - height / 2, width, height);
    }

    @Override
    public void start() {
        // start the animation timer
        timer.start();
    }

    @Override
    public void stop() {
        // stop the animation timer
        timer.stop();
    }
    public static void main(String[] args) {
        new Balloon2().run();
    }
}
