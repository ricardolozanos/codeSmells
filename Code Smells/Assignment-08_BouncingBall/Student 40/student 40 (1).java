package src.noapplet.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
class BouncingBall extends AnimationNoApplet {
    private final Ball[] balls;

    public BouncingBall(String[] args) {
        super(args);
        this.balls = new Ball[4];

        balls[0] = (new CircularBall(400 * 2 / 3, 300 - 20, -5, -3));
        balls[1] = (new CircularBall(400 * 2 / 3, 300 - 20, -4, -1));
        balls[2] = (new CircularBall(400 * 2 / 3, 300 - 20, -6, -4));
        balls[3] = (new CircularBall(400 * 2 / 3, 300 - 20, -6, -4));


    }


    public static void main(String[] args) {
        new BouncingBall(new String[] {"width=300", "height=300"}).run();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 300, 300);
        g.setColor(Color.RED);
        g.drawString("Samantha Silva", 30,30);

        for (Ball s: balls){
            for (Ball t: balls){
                if (s != t) {
                    s.checkCollision(t);
                }
            }
        }
        for (Ball r : balls) {

            r.bounce();
            r.draw(g);

        }
    }
}

public abstract class Ball implements Bounceable{
    protected Color color = Color.GREEN;
    protected int radius = 20;
    protected int x, y;
    protected int dx, dy;
    public abstract void draw(Graphics g);

    protected Ball(int x, int y, int dx, int dy){
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}


