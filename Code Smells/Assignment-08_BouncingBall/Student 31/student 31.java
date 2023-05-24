package noapplet.example;

import noapplet.NoApplet;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

/** Reusable class implementing the animation idiom. */
@SuppressWarnings("serial")
public abstract class AnimationNoApplet extends NoApplet {

    /** Delay in milliseconds between two consecutive frames. */
    protected int delay = 10;

    /** Dimension of the screen for this noapplet. */
    protected Dimension dim;

    /** Refresh display once per <code>delay</code> milliseconds. */
    private Timer timer;

    protected AnimationNoApplet() {
    }

    protected AnimationNoApplet(String[] args) {
        super(args);
    }

    /** Overridden here to initialize the animation. */
    @Override
    public final void init() {
        dim = getSize();
        initAnimation();
        var delay = getParameter("delay");
        if (delay != null) {
            this.delay = Integer.parseInt(delay);
        }
        timer = new Timer(this.delay, e -> repaint());
    }

    /** Callback to be invoked by the <code>init</code> method
     * to perform a subclass-specific initialization. */
    protected void initAnimation() {
    }

    /** Overridden here to start the animation timer. */
    @Override
    public void start() {
        timer.start();
    }

    /** Overridden here to ttop the timer. */
    @Override
    public void stop() {
        timer.stop();
    }

    public static void main(String[] args) {

            new BouncingBallAnimation(new String[] {"width=700", "height=700"}).run();
            //new BouncingBallAnimationTwo(new String[]{"with=200","height=700"}).run();
            //new BouncingBallAnimationTwo();


    }

}

/** Sample use of the AnimationNoApplet class to bounce a ball.
 * Need to override only two methods: initAnimation() and paint(). */
@SuppressWarnings("serial")
class BouncingBallAnimation extends AnimationNoApplet {

    private Color color = Color.BLUE;
    private int radius = 20;
    final private int randome = ThreadLocalRandom.current().nextInt(700);
    private int x = randome , y = randome, x1 = randome, x2=randome, y1=randome, y2=randome;
    private int dx = -2, dy = -4,dx1 = -2, dy1 = -4,dx2 = -2, dy2 = -4;

    public BouncingBallAnimation(String[] args) {
        super(args);
    }

    @Override
    protected void initAnimation() {
        x = dim.width * 2 / 3;
        y = dim.height - radius;
    }

    /** Display the current time. */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // fill the background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, dim.width, dim.height);
        g.setFont(new Font("San-serif", Font.BOLD, 24));
        g.setColor(new Color(155, 0,255));
        g.drawString("Francisco Rodriguez", 100, 300);

        BouncingBallAnimationTwo(g);
        BouncingBallAnimationThree(g);
        BouncingBallAnimationFour(g);

/*
        // adjust the position of the ball
        if (x < radius || x > dim.width - radius) {
            dx = -dx;
        }
        if (y < radius || y > dim.height - radius) {
            dy = -dy;
        }
        x += dx;
        y += dy;

        // draw the ball and dump the off-screen image
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);*/
    }


    public void BouncingBallAnimationTwo(Graphics g) {
        if (x < radius || x > dim.width - radius|| (x > (x1- radius ) && x < x1) || (x > (x2- radius ) && x < x2)) {
            dx = -dx;
        }
        if (y < radius || y > dim.height - radius|| (y > (y1- radius ) && y < y1) || (y > (y2- radius) && y < y2)) {
            dy = -dy;
        }
        x += dx;
        y += dy;

        g.setColor(new Color(155, 0,255));
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    public void BouncingBallAnimationThree(Graphics g) {
        if (x1 < radius || x1 > dim.width - radius|| (x1 > (x - radius) && x1 < x) || (x1 > (x2 - radius) && x1 < x2)) {
            dx1 = -dx1;
        }
        if (y1 < radius || y1 > dim.height - radius|| (y1 > (y - radius) && y1 < y) || (y1 > (y2 - radius) && y1 < y2)) {
            dy1 = -dy1;
        }
        x1 += dx1;
        y1 += dy1;

        g.setColor(new Color(105, 0,255));
        g.fillOval(x1 - radius, y1 - radius, radius * 2, radius * 2);
    }

    public void BouncingBallAnimationFour(Graphics g) {
        if (x2 < radius || x2 > dim.width - radius|| (x2 > (x1 - radius) && x2 < x1) || (x2 > (x1 - radius) && x2 < x1)) {
            dx2 = -dx2;
        }
        if (y2 < radius || y2 > dim.height - radius|| (y2 > (y1 - radius) && y2 < y1) || (y2 > (y - radius) && y2 < y)) {
            dy2 = -dy2;
        }
        x2 += dx2;
        y2 += dy2;

        g.setColor(new Color(180, 0,255));
        g.fillOval(x2 - radius, y2 - radius, radius * 2, radius * 2);
    }
}


//package noapplet.example;

//public class solar {
//}
