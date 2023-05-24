package noapplet.assignments.Solar;

import noapplet.AnimationNoApplet;
import java.awt.*;

public class SolarSystem extends AnimationNoApplet {
    private Sun sun;

    
    @Override
    protected void paintComponent(Graphics g){
        setBackground(Color.BLACK);
        super.paintComponent(g);
        sun.draw(g);

    }

    public static void main(String[] args){
        new SolarSystem().run();
    }

    @Override
    protected void initAnimation(){
        super.initAnimation();
        sun = new Sun(dim.width/2, dim.height/2, 30, Color.RED);
    }

    
}
