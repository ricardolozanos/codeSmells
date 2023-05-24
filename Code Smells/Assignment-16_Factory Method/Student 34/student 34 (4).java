package excs.ModularBallonApp;

import java.awt.*;

public class growingBalloon implements Balloon {
    int x;
    int y;
    int wid;
    int hig;
    int speed;
    Color color;
    public growingBalloon(){
       x = Balloon.x;
       y = Balloon.y;
       wid = Balloon.wid;
       hig = Balloon.hig;
       speed = Balloon.speed;
       color = Balloon.color;

    }
    public void draw(Graphics g){
        Rectangle bounds = g.getClipBounds();
        g.setColor(color);
        g.fillOval(x, y, wid, hig);
        x += speed;
        y += speed;
        wid += speed;
        hig += speed;


    }
}
