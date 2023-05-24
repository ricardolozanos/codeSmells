package excs.ModularBallonApp;

import java.awt.*;

public class growingAndShrinking extends growingBalloon{
    int x;
    int y;
    int wid;
    int hig;
    int speed;
    Color color;
    public growingAndShrinking() {
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
        if((x + speed >= bounds.width) || (y + speed >= bounds.height)){
            speed = -2;
        }

        if((x + speed <= 10) || (y + speed <= 10)){
            speed = -2;
        }
        g.fillOval(x, y, wid, hig);
        x += speed;
        y += speed;
        wid += speed;
        hig += speed;


    }
}
