package noapplet.solar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Timer;
@SuppressWarnings("serial")
public class Moon extends noapplet.AnimationNoApplet {
    private int distance, radius;
    private double angle, speed;
    private Color color;
    private Planet planet;
    public Moon(int distance, int radius, double angle, Color color, double speed, Planet planet){
        this.distance = distance;
        this. radius = radius;
        this.angle = angle;
        this.color = color;
        this.speed = speed;
        this.planet = planet;
    }
    public void draw(Graphics g){
        var x = (planet.getX()) + Math.cos(angle) * distance;
        var y = (planet.getY()) + Math.sin(angle) * distance;
        angle += speed;



        g.setColor(color);
        g.fillOval((int)x, (int)y, radius, radius);
    }
}
