package BallonFactory;

import java.awt.*;

public class Main extends AnimationNoApplet{
    GrowingBalloon balloon = new GrowingBalloon();
    //ShrinkingBalloon balloon = new ShrinkingBalloon();
    public Main(String[] args){
        super(args);
    }
    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0,0,350,350);
        g.setColor(Color.GREEN);
        g.fillOval(balloon.getX(), balloon.getY(), balloon.getDiameter(), balloon.getDiameter());
        balloon.update();
    }
    public static void main(String[] args){
        new Main(new String[]{"width=350", "height=350", "delay = 50"}).run();
    }
}
