package excs.ModularBallonApp;

import java.awt.*;

public class ModularBalloonApp extends noApplet.AnimationNoApplet{
    ModularBalloonApp(String[] args){

    }

    protected Balloon newBalloon = new growingBalloon();

    @Override
    public void init(){
        dim = getSize();
    }

    public void paintComponent(Graphics g){
        g.fillRect(dim.width / 2, dim.height / 2, dim.width, dim.height );
        newBalloon.draw(g);

    }



}
