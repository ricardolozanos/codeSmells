package noapplet.example;
import java.awt.*;

public class BouncingBall extends AnimationNoApplet {

    private int x, y;

    private int dx, dy;

    private int radius;

    private Color color = Color.GREEN;

    @Override
    protected void initAnimation() {
        super.init();
        x = dim.width * 2 / 3;
        y = dim.height - radius;
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);

        g.fillRect(0, 0, dim.width, dim.height);

        if (x < radius || x > dim.width - radius) {

            dx = -dx;

        }

        if (y < radius || y > dim.height - radius) {

            dy = -dy;

        }

        x += dx;
        y += dy;
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);

    }
}
