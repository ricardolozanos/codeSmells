package src.noapplet.example;

import java.awt.*;

public class EnhancedModularBalloonApp extends ModularBalloonApp{
    private final Balloon1[] balloons;
    public EnhancedModularBalloonApp(){
        this.balloons = new Balloon1[4];

        balloons[0] = (new GrowingShrinkingBalloon());
        balloons[1] = (new GrowingShrinkingBalloon());
        balloons[2] = (new GrowingShrinkingBalloon());
        balloons[3] = (new GrowingShrinkingBalloon());


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
}
