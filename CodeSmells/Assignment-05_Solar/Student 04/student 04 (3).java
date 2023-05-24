package noapplet.assignments.Solar;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Planet {
    private int distance;
    private int radius;
    private int angle;
    private Color color;
    private int speed;
    private Sun sun;
    private final List<Moon> moons;

    public Planet(int distance, int radius, int angle, Color color ,int speed, Sun sun ){
        this.distance = distance;
        this.radius = radius;
        this.angle = angle;
        this.color = color;
        this.speed = distance;
        this.sun = sun;

        moons = new ArrayList<>();
        moons.add(new Moon(50, 7, 0, Color.gray, 5, this));

    }

    public int getX(){
        return (int) (sun.getX() + distance * Math.cos(Math.toRadians(angle)));
    }
    
    public int getY(){
        return (int) (sun.getY() + distance * Math.sin(Math.toRadians(angle)));
    }
    
    public int getDistance(){
        return distance;
    }
    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }


    public void draw(Graphics g){
        int x = getX();
        int y = getY();
    
        g.setColor(color);
        g.fillOval(x - radius, y - radius, 2*radius, 2*radius);
    
        for(Moon m: moons){
            m.draw(g);
        }
        angle += 2; 
    }
    

}
