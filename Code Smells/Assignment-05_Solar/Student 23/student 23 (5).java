package noapplet.SS;

import java.awt.*;
import java.util.*;
public class Sun extends noapplet.AnimationNoApplet{
    private final int x;
    private final int y;
    private final int radius;
    private final Color color;
    private final java.util.List<Planet> planets;

    public Sun(int x,int y, int radius, Color color){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;

        planets = new ArrayList<>();
        planets.add(new Planet(100,20,11,Color.YELLOW, 0.05,this, 1));
        planets.add(new Planet(200,20,100,Color.GREEN, 0.01,this, 2));
        planets.add(new Planet(300,25,0,Color.BLUE, 0.03 ,this, 0));
        planets.add(new Planet(400,23,200,Color.WHITE, 0.025 ,this, 3));
    }

    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
        for(var p : planets){
            p.draw(g);
        }


    }

    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }
}