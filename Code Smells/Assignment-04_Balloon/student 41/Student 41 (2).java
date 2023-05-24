package noapplet;

import javax.swing.*;
import java.awt.*;

public class Balloon extends noapplet.AnimationNoApplet{
    protected Timer timer;
    protected Color color = Color.GREEN;
    int x = 5;
    int y = 5;
    boolean increasing = true;
    public Balloon() {
        timer = new Timer(10, event -> repaint());
    }
    @Override
    public void start() {
        timer.start();
    }

    @Override
    public void stop() {
        timer.stop();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.clearRect(0,0,400,400);
        g.setColor(color);
        g.drawOval(200-x/2,200-y/2,x,y);
        g.fillOval(200-x/2,200-y/2,x,y);
        checkSize();
        changeSize();
    }
    public void checkSize(){
        if (x >= 400 || y >= 400){
            increasing = false;
        }
    }
    public void changeSize(){
        if (increasing){
            x++;
            y++;
        }
    }
    public static void main(String[] args) {
        new Balloon().run();
    }
}
