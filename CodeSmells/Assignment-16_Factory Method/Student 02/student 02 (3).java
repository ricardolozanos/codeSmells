package noapplet.BalloonFactoryHW;

import java.util.*;
import java.awt.*;


public class GrowingBalloon implements Balloon{
    private Timer timer;
    private int delay;
    private int offset;
    private int size;
    private int x;
    private int y;


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
        g.fillRect(0,0, 500, 500);
        size = size + offset;
        x = x - 5;
        y = y - 5;
        g.setColor(Color.BLUE);
        g.fillOval(x, y, size, size);
    }
}
