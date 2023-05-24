package noapplet.SolSystem;
import java.awt.*;
import java.util.Random;

public class Moonn extends noapplet.AnimationNoApplet{

    private int distance, radius, angle, speed;
    private Color color;
    private Planett planet;
    public Moonn(int distance, int radius,int angle, Color color, int speed, Planett planet){
        this.distance = distance;
        this.radius = radius;
        this.angle = angle;
        this.color = color;
        this.speed = speed;
        this.planet = planet;
    }
    private int calX() {
        int center = radius / 2;   // dim: dimension of this planet
        return (int) (center + distance * Math.cos(Math.toRadians(angle))); // angle in degrees (0-360)
    }
    public void drawMoon(Graphics g){
        var ran = new Random();
        var x = ran.nextInt(distance);
        var y = ran.nextInt(distance);
        //modify position of planets
        x = calX();
        y = calX();
        x = planet.getX() + distance * 2;
        y = planet.getX() + distance * 2;
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}