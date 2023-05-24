package noapplet.solarsystem;

import noapplet.AnimationNoApplet;

import java.awt.*;

public class Moon{
    private Planet planet;
    private Color color;
    private int radius;
    private int distance;
    private int angle;
    private int[] position = new int[2];
    private int speed = 2;
    private int direction = 1;
    public Moon(int radius, Color color, Planet planet, int distance, int angle, int speed, boolean goesRight){
        this.speed = speed;
        this.distance = distance;
        this.planet = planet;
        this.radius = radius;
        this.color = color;
        this.angle = angle;
        if (goesRight){
            this.direction = 1;
        }
        else{
            this.direction = -1;
        }
    }

    public int[] calculatePosition(Dimension d){
        angle += speed*direction;
        position[0] = (int) (planet.getCenter()[0] + (distance * Math.cos(Math.toRadians(angle))));
        position[1] = (int) (planet.getCenter()[1] + (distance * Math.sin(Math.toRadians(angle))));
        return position;
    }

    public Color getColor(){
        return color;
    }
    public int getRadius(){
        return radius;
    }
    public int[] getPosition(){
        return position;
    }
}
