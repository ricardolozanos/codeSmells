package noapplet.Balls;

import java.awt.*;

public class CircleBall extends Ball{

    public CircleBall(int x, int y, int dx, int dy, int radius, Color c) {
        super(x, y, dx, dy, radius, c);
    }

    @Override
    public void draw(Graphics g) {
        bounce();
        g.setColor(getColor());
        g.fillOval(getX(), getY(), getRadius() * 2, getRadius() * 2);

    }
}
