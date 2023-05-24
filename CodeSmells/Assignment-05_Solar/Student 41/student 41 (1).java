package noapplet;

import java.awt.*;

public class Planet{
    Sun sun;
    int distance;
    int size;
    int speed;
    Color color;
    int angle;
    public Planet(Sun sun,int distance, int size, int speed, Color color) {
        this.sun = sun;
        this.distance = distance;
        this.size = size;
        this.speed = speed;
        this.color = color;
        this.angle = 0;
    }
    public void paintComponent(Graphics g){
        g.setColor(color);
        g.drawOval(sun.getX()+calX(), sun.getY()+calY(), size,size);
        g.fillOval(sun.getX()+calX(), sun.getY()+calY(), size,size);
        angle+=speed;
    }
    private int calX() {
        int center = size / 2;   // dim: dimension of this planet
        return (int) (center + distance * Math.cos(Math.toRadians(angle))); // angle in degrees (0-360)
    }
    private int calY() {
        int center = size / 2;   // dim: dimension of this planet
        return (int) (center + distance * Math.sin(Math.toRadians(angle))); // angle in degrees (0-360)
    }
    public int getX(){
        return sun.getX()+calX();
    }
    public int getY(){
        return sun.getY()+calY();
    }
}
