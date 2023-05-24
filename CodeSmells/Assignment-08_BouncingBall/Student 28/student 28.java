package noapplet;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import noapplet.example.AnimationNoApplet;

import javax.swing.*;

class BouncingBall extends AnimationNoApplet {
    private int radius = 20;
    private int x, y;
    private int dx = -2, dy = -4;
    private List<CircleBall> balls = new ArrayList<>();
    protected Timer timer;

    public BouncingBall(String[] args) {
        super(args);
    }

    @Override
    protected void initAnimation() {
        x = dim.width * 2 / 3;
        y = dim.height - radius;
        balls.add(new CircleBall(getRandomNumber(1, 380), getRandomNumber(1, 380), radius));
        balls.add(new CircleBall(x, y, radius));
        balls.add(new CircleBall(x - 50, y- 50, radius));
    }

    /*Display the current time.*/
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // fill the background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, dim.width, dim.height);
        g.setFont(new Font("San-serif", Font.BOLD, 12));
        g.setColor(Color.MAGENTA);
        g.drawString("Nayeli Ramirez", 80, 350);

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
        for(CircleBall b: balls){
            b.draw(g);
        }
    }
    public void start() {
        timer.start();
    }
    public void stop() {
        timer.stop();
    }
    public static void main(String[] args) {
        new BouncingBall(new String[] {"width=400", "height=400"}).run();
    }
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}

interface Bounceable{
    public void draw(Graphics g);
}

class CircleBall implements Bounceable {
    //private int numOfBalls;
    private int radius;
    private int x, y;
    protected CircleBall(int x, int y, int radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public void draw(Graphics g){
        g.setColor(Color.GREEN);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }

}
