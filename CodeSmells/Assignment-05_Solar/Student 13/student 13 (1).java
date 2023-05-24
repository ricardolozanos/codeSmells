package noapplet.solarsystem;
import java.util.Random;

import noapplet.AnimationNoApplet;
import noapplet.balloon.Balloon;

import java.awt.*;

public class Sun{
    private Color color = Color.ORANGE;
    private int radius = 50;
    private int[] position = new int[2];
    public Sun(Color color, int radius){
        this.color = color;
        this.radius = radius;
    }
    public int[] calculatePosition(Dimension d){
        position = new int[] {(d.width-radius)/2, (d.height-radius)/2};
        return position;
    }
    public Color getColor(){
        return color;
    }
    public int getRadius(){
        return radius;
    }
    public int[] getCenter(){
        return new int[] {position[0] + radius/2, position[1] + radius/2};
    }
    public int[] getPosition(){
        return position;
    }
}
