package src.noapplet.example;

import java.awt.*;

public class ModularBalloonApp extends AnimationNoApplet1{
    private final Balloon1[] balloons;
    public ModularBalloonApp(){
        this.balloons = new Balloon1[4];

        balloons[0] = (new GrowingBalloon());
        balloons[1] = (new GrowingBalloon());
        balloons[2] = (new GrowingBalloon());
        balloons[3] = (new GrowingBalloon());


    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, dim.width, dim.height);
        g.setColor(Color.GREEN);

        for (Balloon1 s: balloons) {
            s.draw(g);
        }
    }
//    public static void main(String[] args) {
//        new GrowingBalloon(new String[] {"width=500", "height=500"}).run();
//    }
}
