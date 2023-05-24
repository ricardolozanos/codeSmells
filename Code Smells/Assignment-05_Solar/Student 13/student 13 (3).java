package noapplet.solarsystem;

import noapplet.AnimationNoApplet;

import java.awt.*;

public class Planet{
    private Sun sun;
    private Color color;
    private int radius;
    private int distance;
    private int angle;
    private int[] position = new int[2];
    private int speed = 2;
    private int direction = 1;
    public Planet(int radius, Color color, Sun sun, int distance, int angle, int speed, boolean goesRight){
        this.speed = speed;
        this.distance = distance;
        this.sun = sun;
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
        position[0] = (int) (sun.getCenter()[0] + (distance * Math.cos(Math.toRadians(angle))));
        position[1] = (int) (sun.getCenter()[1] + (distance * Math.sin(Math.toRadians(angle))));
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
