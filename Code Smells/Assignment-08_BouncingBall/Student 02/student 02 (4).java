package noapplet.example;

import java.awt.*;

public class CircleBall extends Ball{

    protected CircleBall(Color color, int radius, int x, int y, int dx, int dy) {
        super(color, radius, x, y, dx, dy);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 400, 400);

        // adjust the position of the ball
        if (getX() < getRadius() || getX() > 400 - getRadius()) {
            setDX(-getDX());
        }
        if (getY() < getRadius() || getY() > 400 - getRadius()) {
            setDX(-getDY());
        }
        setX(getX() + getDX());
        setY(getY() + getDY());

        // draw the ball and dump the off-screen image
        g.setColor(getColor());
        g.fillOval(getX() - getRadius(), getY() - getRadius(), getRadius() * 2, getRadius() * 2);
    }
}
