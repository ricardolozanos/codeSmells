package noapplet.solar;
import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
@SuppressWarnings("serial")
public class Planet extends noapplet.AnimationNoApplet{
    private int distance, radius;
    private double angle, speed, x, y;
    private Color color;
    private Sun sun;
    private final java.util.List<Moon>moons;
    public Planet(int distance, int radius, double angle, Color color, double speed, double x, double y, Sun sun){
        this.distance = distance;
        this.radius = radius;
        this.angle = angle;
        this.color = color;
        this.speed = speed;
        this.x = x;
        this.y = y;
        this.sun = sun;

        moons = new ArrayList<>();
        moons.add(new Moon(30, 10, angle, Color.CYAN, .03,this));
        moons.add(new Moon(40, 8, angle, Color.PINK, .04,this));
        moons.add(new Moon(50, 12, angle, Color.ORANGE, .05,this));
    }
    public void draw(Graphics g){
        x = (sun.getX()) + Math.cos(angle) * distance;
        y = (sun.getY()) + Math.sin(angle) * distance;
        angle += speed;

        g.setColor(color);
        g.fillOval((int)x - radius, (int)y - radius, radius*2, radius*2);

        for(var p : moons){
            p.draw(g);
        }
    }
    public int getX(){return (int)x;}
    public int getY(){return (int)y;}
}
