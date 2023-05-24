package src.noapplet.example;

import java.awt.*;

public class GrowingShrinkingBalloon extends GrowingBalloon{
    int xDirection = 1;
    int yDirection = 1;

    public GrowingShrinkingBalloon() {
        super(new String[]{"width=500", "height=500"});
    }

    public void draw(Graphics g) {
        int centerX = 500 / 2;
        int centerY = 500 / 2;

        if (growing) {
            radius += 5;
            if (radius > Math.min(centerX, centerY)) {
                growing = false;
            }
        } else {
            radius -= 5;
            if (radius < 50) {
                growing = true;
            }
        }

        centerX += xDirection * 10;
        centerY += yDirection * 10;

        if (centerX + radius > 500 || centerX - radius < 0) {
            xDirection = -xDirection;
        }
        if (centerY + radius > 500 || centerY - radius < 0) {
            yDirection = -yDirection;
        }

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 500, 500);

        g.setColor(Color.GREEN);
        g.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
    }
}
