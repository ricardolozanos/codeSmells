package noapplet.SS;

import java.awt.Color;
import java.awt.Graphics;

public class Moon extends noapplet.AnimationNoApplet{
    private final int distance;
    private final int radius;
    private double angle;
    private final double speed;
    private final Color color;
    private int planetX;
    private int planetY;

    public Moon(int distance, int radius, double angle, Color color, double speed) {
        this.radius = radius;
        this.color = color;
        this.speed = speed;
        this.distance = distance;
        this.angle = angle;
    }

    public void setPlanetX(int planetX) {
        this.planetX = planetX;
    }

    public void setPlanetY(int planetY) {
        this.planetY = planetY;
    }

    public void draw(Graphics g){
        var x = planetX + Math.cos(angle) * distance;
        var y = planetY + Math.sin(angle) * distance;
        angle += speed;

        g.setColor(color);
        g.fillOval((int)x - radius, (int)y - radius, radius * 2, radius * 2);
    }
}