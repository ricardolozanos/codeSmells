package excs.ModularBallonApp;

import java.awt.*;

public class EnhancedModularBalloonApp extends ModularBalloonApp{

    EnhancedModularBalloonApp(String[] args) {
        super(args);
    }

    protected Balloon newBalloon = new growingAndShrinking();

    @Override
    public void init(){
        dim = getSize();
    }

    public void paintComponent(Graphics g){
        g.fillRect(dim.width / 2, dim.height / 2, dim.width, dim.height );
        newBalloon.draw(g);

    }
}
