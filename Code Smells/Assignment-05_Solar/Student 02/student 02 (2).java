package noapplet.example;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Timer;

import noapplet.NoApplet;

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
        new BouncingBallAnimation(new String[] {"width=300", "height=300"}).run();
    }
    
}

/** Sample use of the AnimationNoApplet class to bounce a ball.
 * Need to override only two methods: initAnimation() and paint(). */
@SuppressWarnings("serial")
class BouncingBallAnimation extends AnimationNoApplet {
    
	private Color color = Color.GREEN;
	private int radius = 20;
	private int x, y;
    private int dx = -2, dy = -4;
    
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
    	g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

}