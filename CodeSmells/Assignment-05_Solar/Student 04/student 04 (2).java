package noapplet.assignments.Solar;
import java.awt.*;


public class Moon {
    private int distance;
    private int radius;
    private int angle;
    private Color color;
    private int speed;
    private Planet planet;
    
    public Moon(int distance, int radius, int angle, Color color, int speed, Planet planet){
        this.distance = distance;
        this.radius = radius;
        this.angle = angle;
        this.color = color;
        this.speed = speed;
        this.planet = planet;

    }

    public void draw(Graphics g){
        int x = (int) (planet.getX() + distance * Math.cos(Math.toRadians(angle)));
        int y = (int) (planet.getY() + distance * Math.sin(Math.toRadians(angle)));
        g.setColor(color);
        g.fillOval(x - radius, y - radius, 2*radius, 2*radius);
        angle = (angle + speed) % 360;

    }
}
