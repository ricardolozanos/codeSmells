package noapplet;

import java.awt.*;
import javax.swing.Timer;
import java.util.ArrayList;

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
class BouncingBallAnimation extends AnimationNoApplet{
    int numOfBalls = 4;
    ArrayList<Ball> Balls = new ArrayList<Ball>();
    public BouncingBallAnimation(String[] args) {
    	super(args);
    }

    @Override
    protected void initAnimation() {
        for (int i = 0; i < numOfBalls; i++)
            Balls.add(new CircleBall(100, 100, 20));
    }

    /** Display the current time. */ 
    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0,0, dim.width, dim.height);
        g.setFont(new Font("San-serif", Font.BOLD, 24));
        g.setColor(Color.ORANGE);
        g.drawString("Francisco", 40, 30);
        for (Ball ball : Balls)
            ball.Update(Balls, g, dim.width, dim.height);
    }
}

interface Bouncable {
    public void Bounce();
}

abstract class Ball implements Bouncable {
    protected final int Size;
    protected double X, Y;
    protected double Direction = Math.random() * Math.PI * 2;

    public Ball(int x, int y, int size) {
        X = x;
        Y = y;
        Size = size;
    }

    private void CalculateBounce(double collisionNormal) {
        //if(Direction % (2 * Math.PI) + collisionNormal - Math.PI < Math.PI/2)
        Direction = -Direction - collisionNormal * 2 + Math.PI;
    }

    public void Update(ArrayList<Ball> balls, Graphics g, int width, int height) {
        double delta = 2;

        for (Ball ball : balls) {
            if (ball == this)
                continue;
            int totalSize = Size + ball.Size;
            double distance = Math.sqrt(Math.pow(ball.X - X, 2) + Math.pow(ball.Y - Y, 2));

            if (distance >= totalSize)
                continue;
            double collisionNormal = Math.atan2(ball.Y - Y, ball.X - X);
            X = ball.X + (Math.cos(collisionNormal + Math.PI) * totalSize);
            Y = ball.Y + (Math.sin(collisionNormal + Math.PI) * totalSize);
            CalculateBounce(collisionNormal);
            Bounce();
            break;
        }

        if (X - Size < 0){
            CalculateBounce(Math.PI);
            X = Size;
        }
        else if (X + Size > width){
            CalculateBounce(0);
            X = width - Size;
        }
        else if (Y - Size < 0){
            CalculateBounce(-Math.PI / 2);
            Y = Size;
        }
        else if (Y + Size > height){
            CalculateBounce(Math.PI / 2);
            Y = height - Size;
        }

        X += Math.cos(Direction) * delta;
        Y += Math.sin(Direction) * delta;

        Draw(g);
    }

    @Override
    public void Bounce() {
        Direction = Math.random() * Math.PI * 2;
    }

    public abstract void Draw(Graphics g);
}

class CircleBall extends Ball {
    public CircleBall(int x, int y, int size) {
        super(x,y,size);
    }

    @Override
    public void Draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval((int)X - Size, (int)Y - Size, Size*2, Size*2);
    }
}
