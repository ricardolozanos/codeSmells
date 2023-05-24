package noapplet.assignments.BouncingBall;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;
import java.awt.Font;

interface Movable {
    void move(Dimension dim, List<Ball> balls);
    void draw(Graphics g);
}

class Ball implements Movable {
    int x, y;
    int dx, dy;
    int radius;
    Color color;

    public Ball(int x, int y, int dx, int dy, int radius, Color color) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.radius = radius;
        this.color = color;
    }

    @Override
    public void move(Dimension dim, List<Ball> balls) {
        if (x < radius || x > dim.width - radius) {
            dx = -dx;
        }
        if (y < radius || y > dim.height - radius) {
            dy = -dy;
        }

        for (Ball ball : balls) {
            if (ball != this) {
                int xDiff = x - ball.x;
                int yDiff = y - ball.y;
                int distance = (int) Math.sqrt(xDiff * xDiff + yDiff * yDiff);
                if (distance <= radius + ball.radius) {
                    dx = -dx;
                    dy = -dy;
                    ball.dx = -ball.dx;
                    ball.dy = -ball.dy;
                }
            }
        }

        x += dx;
        y += dy;
    }

    @Override
    public void draw(Graphics g) {
        g.setFont(new Font("San-serif", Font.BOLD, 20));
        g.drawString("Diego Jared Avina", 200, 40);
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}
