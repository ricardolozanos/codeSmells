package noapplet.BalloonFactoryHW;

import java.awt.*;
import java.util.Timer;

public class GrowingShrinkingBalloon implements Balloon{
    private Timer timer;
    private int delay;
    private int offset;
    private int size;
    private int x;
    private int y;
    private boolean grow = true;
    @Override
    public void init() {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, 500, 500);
        if (grow){
            size = size + offset;
            x = x - 5;
            y = y - 5;

        }

        if (size > 300){
            grow = false;
        }

        if (!grow){
            size = size - offset;
            x = x + 5;
            y = y + 5;
        }

        if (size < 11) {
            grow = true;
        }

        g.setColor(Color.BLUE);
        g.fillOval(x, y, size, size);
    }
}
