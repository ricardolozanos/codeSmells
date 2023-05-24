package noapplet.BouncingBalls;

import noapplet.NoApplet;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.Random;


/** Reusable class implementing the animation idiom. */
@SuppressWarnings("serial")
abstract class AnimationNoApplet extends NoApplet {

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
        new BouncingBalls(new String[] {"width=300", "height=300"}).run();
    }
}
public class BouncingBalls extends AnimationNoApplet{
    Random rand = new Random();
    private int radius = 20;
    private int x, y;
    private int x1 = rand.nextInt(300);
    private int y1 = rand.nextInt(300);
    private int x2 = rand.nextInt(300);
    private int y2 = rand.nextInt(300);
    private int x3 = rand.nextInt(300);
    private int y3 = rand.nextInt(300);
    private int dx1 = -3, dy1 = -5;
    private int dx2 = -4, dy2 = -4;
    private int dx3 = -5, dy3 = -3;

    public BouncingBalls(String[] args){
        super(args);
    }
    @Override
    protected void initAnimation() {
        x = dim.width * 2 / 3;
        y = dim.height - radius;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // fill the background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, dim.width, dim.height);
        // draw the ball and dump the off-screen image
        g.setColor(Color.YELLOW);
        g.drawString("Emilio Rojero", 100,100);
        draw(g);
    }
    public void draw(Graphics g){

        // adjust the position of the ball
        if (x1 < radius || x1 > dim.width - radius) dx1 = -dx1;
        if (y1 < radius || y1 > dim.height - radius) dy1 = -dy1;
        if (x2 < radius || x2 > dim.width - radius) dx2 = -dx2;
        if (y2 < radius || y2 > dim.height - radius) dy2 = -dy2;
        if (x3 < radius || x3 > dim.width - radius) dx3 = -dx3;
        if (y3 < radius || y3 > dim.height - radius) dy3 = -dy3;
        if(Math.abs(x1 - x2) <= radius && Math.abs(y1 - y2) <= radius){
            dx1 = -dx1;
            dx2 = -dx2;
        }
        if(Math.abs(x1 - x3) <= radius && Math.abs(y1 - y3) <= radius){
            dx1 = -dx1;
            dx3 = -dx3;
        }
        if(Math.abs(x3 - x2) <= radius && Math.abs(y3 - y2) <= radius){
            dx3 = -dx3;
            dx2 = -dx2;
        }
        x1 += dx1;
        y1 += dy1;
        x2 += dx2;
        y2 += dy2;
        x3 += dx3;
        y3 += dy3;

        g.setColor(Color.GREEN);
        g.fillOval(x1 - radius, y1 - radius, radius * 2, radius * 2);
        g.setColor(Color.RED);
        g.fillOval(x2 - radius, y2 - radius, radius * 2, radius * 2);
        g.setColor(Color.BLUE);
        g.fillOval(x3 - radius, y3 - radius, radius * 2, radius * 2);
    }

}

