package noapplet.Balls;

import noapplet.AnimationNoApplet;

import java.util.ArrayList;
import java.util.Random;

import java.awt.*;

public class BouncingBall extends AnimationNoApplet {
    private ArrayList<Bounceable> balls = new ArrayList<>();
    private Color color = Color.green;
    private int numOfBalls = 3;

    public static void main(String[] args) {
        new BouncingBall(new String[] {"width=500", "height=500"}).run();
    }

    public BouncingBall(String[] args) {
        super(args);
    }

    public void initAnimation() {
        Random rand = new Random();
        for(int i = 0; i < numOfBalls; i++) {
            balls.add(new CircleBall(rand.nextInt(dim.width), rand.nextInt(dim.width), -2, -4, 10, color));
        }
    }

    public void paintComponent(Graphics g) {
        for (var v : balls) {
            v.draw(g);
        }
    }
}
