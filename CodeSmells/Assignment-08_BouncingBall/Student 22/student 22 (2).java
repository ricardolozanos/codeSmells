package noapplet.BounceBall;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BouncingBall extends AnimationNoApplet{

    private final List<Ball> balls = new ArrayList<>();

    public void addBall(Ball b) {
        balls.add(b);
    }

    public List<Ball> getBalls() {
        return balls;
    }


    public Dimension getDim(){
        return dim;
    }
    public int getRadius(){
        return 20;
    }

    protected void addName(Graphics g, String name){
        g.setColor(Color.WHITE);
        g.setFont(new Font("Serif", Font.BOLD, 24));
        g.drawString("Made By: " + name, 10, 25);
    }

    @Override
    protected void initAnimation() {
        super.initAnimation();
        CircleBall ball1 = new CircleBall(Color.GREEN, this);
        addBall(ball1);
        CircleBall ball2 = new CircleBall(Color.GREEN, this);
        addBall(ball2);
        CircleBall ball3 = new CircleBall(Color.GREEN, this);
        addBall(ball3);

    }
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, dim.width, dim.height);
        for (Ball b : balls) {
            b.draw(g);
        }
        addName(g, "Alvaro Mendoza");
    }

    public static void main(String[] args) {
        new BouncingBall().run();
    }
}

interface Bounce{
    void draw(Graphics g);
}

abstract class Ball implements Bounce{
    protected int x, y;
    protected int dx = -2, dy = -4;
    protected int radius = 20;
    protected Color color;

    protected Ball(int radius, Color color, int windowWidth, int windowHeight) {
        this.radius = radius;
        this.color = color;
        this.x = (int)(Math.random() * (windowWidth - radius * 2)) + radius; // Generate random x coordinate within the window
        this.y = (int)(Math.random() * (windowHeight - radius * 2)) + radius; // Generate random y coordinate within the window
    }

    public abstract void draw(Graphics g);
}

class CircleBall extends Ball {
    private BouncingBall bouncingBall;

    protected CircleBall(Color color, BouncingBall bouncingBall) {
        super(bouncingBall.getRadius(), color, bouncingBall.getDim().width, bouncingBall.getDim().height);
        this.bouncingBall = bouncingBall;
    }

    @Override
    public void draw(Graphics g) {
        // Access the dimension using the BouncingBall instance
        Dimension dim = bouncingBall.getDim();

        // Update the ball's position
        x += dx;
        y += dy;

        // Check if the ball hits the left or right wall
        if (x - radius < 0) {
            x = radius;
            dx = -dx;
        } else if (x + radius > dim.width) {
            x = dim.width - radius;
            dx = -dx;
        }

        // Check if the ball hits the top or bottom wall
        if (y - radius < 0) {
            y = radius;
            dy = -dy;
        } else if (y + radius > dim.height) {
            y = dim.height - radius;
            dy = -dy;
        }

        // Check if the ball collides with any other balls
        for (Ball otherBall : bouncingBall.getBalls()) {
            if (otherBall != this) {
                // Calculate the distance between the centers of the two balls
                double distance = Math.sqrt(Math.pow(x - otherBall.x, 2) + Math.pow(y - otherBall.y, 2));

                // If the distance is less than the sum of the two radii, the balls are colliding
                if (distance < radius + otherBall.radius) {
                    // Reverse the direction of both balls
                    dx = -dx;
                    dy = -dy;
                    otherBall.dx = -otherBall.dx;
                    otherBall.dy = -otherBall.dy;
                    break; // Exit the loop since we only want to handle one collision per frame
                }
            }
        }

        // Draw the circle ball using the dimension and other properties
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}



