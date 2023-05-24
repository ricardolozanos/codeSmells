package Solar;

import java.awt.*;
import java.util.*;
public class Sun extends noapplet.AnimationNoApplet{
    private final int x;
    private final int y;
    private final int radius;
    private final Color color;
    private java.util.List<Planet> planets;
    
    public Sun(int x,int y, int radius, Color color){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;

        planets = new ArrayList<>();
        planets.add(new Planet(400,10,10,Color.BLUE, 0.045 ,this, 1));
        planets.add(new Planet(300,20,100,Color.GREEN, 0.03,this, 3));
        planets.add(new Planet(100,15,0,Color.CYAN, 0.04 ,this, 2));
        planets.add(new Planet(180,5,200,Color.MAGENTA, 0.035 ,this, 0));
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
