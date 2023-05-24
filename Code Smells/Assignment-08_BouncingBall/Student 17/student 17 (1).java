import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

//Bounceable interface
public interface Bounceable {

    //declaring bounce method
    public void bounce();
}

public class BouncingBall extends JFrame {

    // attributes
    private int numOfBalls;
    private CircleBall[] balls;
    private Color backgroundColor;

    //default constructor
    public BouncingBall() {
        //default number of balls
        this.numOfBalls = 5;

        //initializing Balls
        balls = new CircleBall[numOfBalls];
        for (int i = 0; i < numOfBalls; i++) {
            balls[i] = new CircleBall((int)(Math.random() * 560) + 20, (int)(Math.random() * 560) + 20, 20, Color.GREEN, (int)(Math.random() * 10) - 5, (int)(Math.random() * 10) - 5);
        }

        //setting background color
        this.backgroundColor = Color.BLACK;
    }

    //constructor 2
    public BouncingBall(int numOfBalls) {

        //creating number of Ball objects based on parameter specification
        this.numOfBalls = numOfBalls;

        //initializing Ball objects
        balls = new CircleBall[numOfBalls];
        for (int i = 0; i < numOfBalls; i++) {
            balls[i] = new CircleBall((int)(Math.random() * 560) + 20, (int)(Math.random() * 560) + 20, 20, Color.GREEN, (int)(Math.random() * 10) - 5, (int)(Math.random() * 10) - 5);
        }

        //setting background color
        this.backgroundColor = Color.BLACK;
    }


    //initialize method
    public void init() {
        setTitle("Bouncing Ball");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //animation driver method
    public void animate() {
        // create a buffered image
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D)image.getGraphics();
    
        //loop that checks if Balls have colided and
        //reverses their direction
        while (true) {
            for (int i = 0; i < balls.length; i++) {
                for (int j = i + 1; j < balls.length; j++) {
                    if (balls[i].collidesWith(balls[j])) {
                        balls[i].reverse();
                        balls[j].reverse();
                    }
                }
                balls[i].bounce();
            }
    
            // draw on the buffered image
            g2d.setColor(backgroundColor);
            g2d.fillRect(0, 0, getWidth(), getHeight());
            for (CircleBall ball : balls) {
                ball.draw(g2d);
            }

            //writing name
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("TimesRoman", Font.PLAIN, 30));
            g2d.drawString("Reyes G.", 444, 555);
    
            // draw the buffered image to the screen
            Graphics g = getGraphics();
            g.drawImage(image, 0, 0, null);
            g.dispose();
    
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //paint method
    @Override
    public void paint(Graphics g) {
        BufferedImage image = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) image.getGraphics();

        // Draw background
        g2.setColor(backgroundColor);
        g2.fillRect(0, 0, 600, 600);


        // Draw balls
        for (CircleBall ball : balls) {
            ball.draw(g2);
        }

        // Draw image
        g.drawImage(image, 0, 0, null);

        // Dispose graphics
        g.dispose();
    }


    //abstract Ball method
    private abstract class Ball extends JFrame{

        //attributes
        protected int x, y;
        protected int dx, dy;
        protected int radius;
        protected Color color;

        //Ball constructor (only one)
        public Ball(int x, int y, int radius, Color color, int dx, int dy) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.color = color;
            this.dx = dx;
            this.dy = dy;
        }

        //draw method for rendering Ball on screen
        public void draw(Graphics g) {
            g.setColor(color);
            g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
        }

        //abstract methods
        public abstract void bounce();
        public abstract boolean collidesWith(CircleBall ball);
        public abstract void reverse();
    }

    //CircleBall class that inherits from Ball
    private class CircleBall extends Ball implements Bounceable{

        //constructor (only one)
        public CircleBall(int x, int y, int radius, Color color, int dx, int dy) {
            super(x, y, radius, color, dx, dy);
        }

        //bounce method implementation
        @Override
        public void bounce() {
            //changes direction of the ball if it reaches the edges of the panel
            if (x < radius || x > 600 - radius) {
                dx = -dx;
            }
            if (y < radius || y > 600 - radius) {
                dy = -dy;
            }

            //keeps the ball moving
            x += dx;
            y += dy;
        }

        //collidesWith implementation
        public boolean collidesWith(CircleBall ball) {
            //x and y distances of the two balls
            int distX = this.x - ball.x;
            int distY = this.y - ball.y;

            //distance of two ball's radius
            int distRad = this.radius + ball.radius;

            //checking if the distance between two balls is less than or equal to their combined radius
            //true means the balls have colided
            if ((distX * distX) + (distY * distY) <= (distRad * distRad)) {
                return true;
            }
            return false;
        }

        //reverse method implementation
        public void reverse() {
            //simply changing the direction of the balls by
            //literally reversing their direction
            dx = -dx;
            dy = -dy;
        }
    }

    //driver code
    public static void main(String[] args) {
        //creating BouncingBall object and starting animation
        BouncingBall b = new BouncingBall();
        b.init();
        b.animate();
    }
}