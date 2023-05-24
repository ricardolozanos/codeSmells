package noapplet;

import java.awt.*;

public class Moon{
    Planet planet;
    int distance;
    int size;
    int speed;

    Color color;
    int angle;
    public Moon(Planet planet, int distance, int size, int speed, Color color) {
        this.planet = planet;
        this.distance = distance;
        this.size = size;
        this.speed = speed;
        this.color = color;
        this.angle = 0;
    }

    public void paintComponent(Graphics g) {
        g.setColor(color);
        g.drawOval(planet.getX()+calX(), planet.getY()+calY(), size,size);
        g.fillOval(planet.getX()+calX(), planet.getY()+calY(), size,size);
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
}
