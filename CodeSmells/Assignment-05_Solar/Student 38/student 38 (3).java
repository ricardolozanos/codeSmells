package noapplet.SolSystem;
import java.awt.*;
import java.util.*;

public class Planett extends noapplet.AnimationNoApplet{
    private int distance, radius, angle, speed;
    private Color color;
    private Sol sun;
    private java.util.List<Moonn>moons;
    public Planett(int distance, int radius,int angle, Color color, int speed, Sol sun){
        this.distance = distance;
        this.radius = radius;
        this.angle = angle;
        this.color = color;
        this.speed = speed;
        this.sun = sun;
        moons = new ArrayList<>();
        moons.add(new Moonn(60,15,0,Color.ORANGE, 10, this));
        moons.add(new Moonn(75,8,0,Color.GREEN, 10, this));
    }
    /** Calculate the x coordinate of this planet. */
    private int calX() {
        int center = radius / 2;   // dim: dimension of this planet
        return (int) (center + distance * Math.cos(Math.toRadians(angle))); // angle in degrees (0-360)
    }
    public void draw(Graphics g){
        var ran = new Random();
        var x = ran.nextInt(distance);
        var y = ran.nextInt(distance);
        //modify position of planets
        //x = ran.nextBoolean() ? x : - x;
        x = calX();
        y = calX();
        x = sun.getX() + x;
        y = sun.getX() + y;
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
        for(var p : moons){
        p.drawMoon(g);
        }
    }
}
