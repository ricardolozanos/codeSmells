package noapplet.SS;

import java.awt.*;
import java.util.*;

public class Planet extends noapplet.AnimationNoApplet{
    private final int distance;
    private final int radius;
    private final int moonCount;
    private double angle;
    private final double speed;
    private final Color color;
    private final Sun sun;
    private final java.util.List<Moon> moons;

    public Planet(int distance, int radius, double angle, Color color, double speed, Sun sun, int moonCount){
        this.distance = distance;
        this.radius = radius;
        this.angle = angle;
        this.color = color;
        this.speed = speed;
        this.sun = sun;
        this.moonCount = moonCount;

        moons = new ArrayList<>();
        if(moonCount == 1) {
            moons.add(new Moon(40, 5, 0, Color.RED, 0.075));
        }
        else if(moonCount == 2) {
            moons.add(new Moon(40, 5, 0, Color.RED, 0.075));
            moons.add(new Moon(40, 5, 10, Color.PINK, 0.075));
        }
        else if(moonCount == 3) {
            moons.add(new Moon(50, 4, 0, Color.RED, 0.075));
            moons.add(new Moon(30, 3, 0, Color.PINK, 0.08));
            moons.add(new Moon(65, 6, 20, Color.CYAN, 0.05));
        }
    }

    public void draw(Graphics g){
        var x = sun.getX() + Math.cos(angle) * distance;
        var y = sun.getY() + Math.sin(angle) * distance;
        angle += speed;

        g.setColor(color);
        g.fillOval((int)x - radius, (int)y - radius, radius * 2, radius * 2);

        if(this.moonCount > 0) {
            for(var m: moons) {
                m.setPlanetX((int)x);
                m.setPlanetY((int)y);
                m.draw(g);
            }
        }
    }


}