import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GrowingShrinkingBalloon extends GrowingBalloon implements Balloon{
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

        // initialize the initial width and height to be 1 of the window size
        initialWidth = dim.width / dim.width;
        initialHeight = dim.height / dim.height;

        // set the current width and height to be the initial width and height
        width = initialWidth;
        height = initialHeight;

        // create a timer that triggers every 100 milliseconds and calls an actionPerformed method
        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // check if the balloon is growing
                if (growing) {
                    // increase the width and height by 5
                    width += 5;
                    height += 5;

                    // check if the width or height has reached the size of the window
                    if (width >= dim.width || height >= dim.height) {
                        // set growing to false, indicating that the balloon should start shrinking
                        growing = false;
                    }
                } else {
                    // decrease the width and height by 5
                    width -= 5;
                    height -= 5;

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
}
