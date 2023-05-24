package noapplet.solar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.Timer;
@SuppressWarnings("serial")
public class Sun extends noapplet.AnimationNoApplet{
    private final int x;
    private final int y;
    private final int radius;
    private final Color color;
    private final java.util.List<Planet>planets;

    public Sun(int x, int y, int radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;

        planets = new ArrayList<>();
        planets.add(new Planet(90, 20, 0, Color.GREEN, .03, 0, 0, this));
        planets.add(new Planet(170, 20, 0, Color.BLUE, .02, 0, 0,this));
        planets.add(new Planet(250, 20, 0, Color.YELLOW, .01, 0, 0,this));
    }
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);

        for(var p : planets){
            p.draw(g);
        }
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
