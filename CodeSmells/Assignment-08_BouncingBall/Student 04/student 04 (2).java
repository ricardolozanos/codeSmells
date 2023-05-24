package noapplet.assignments.BouncingBall;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import noapplet.AnimationNoApplet;

public class BouncingBall extends AnimationNoApplet {
    private List<Ball> balls;
    private int numOfBalls = 5;

    @Override
    public void init() {
        super.init();
        balls = new ArrayList<>();
        for (int i = 0; i < numOfBalls; i++) {
            int radius = 20;
            int x = (int) (Math.random() * (dim.width - 2 * radius) + radius);
            int y = (int) (Math.random() * (dim.height - 2 * radius) + radius);
            int dx = (int) (Math.random() * 5 + 2);
            int dy = (int) (Math.random() * 5 + 2);
            balls.add(new Ball(x, y, dx, dy, radius, Color.GREEN));
        }
    }

    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, dim.width, dim.height);
        for (Ball ball : balls) {
            ball.move(dim, balls);
            ball.draw(g);
        }
    }

    public static void main(String[] args) {
        new BouncingBall().run();
    }
}
