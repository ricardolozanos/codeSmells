package excs.ModularBallonApp;

import java.awt.*;

public interface Balloon{
    int x = 10;
    int y = 10;
    int wid = 10;
    int hig = 10;
    int speed = 1;
    Color color = Color.GREEN;

    public void draw(Graphics g);

}

