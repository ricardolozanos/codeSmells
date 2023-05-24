package src.noapplet.example;

import java.awt.*;

public class GrowingBalloon implements Balloon1{
    protected boolean growing = true;
    int radius = 50;

    public GrowingBalloon() {

    }

    public GrowingBalloon(String[] strings){

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

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 500, 500);

        g.setColor(Color.GREEN);
        g.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
    }
}
