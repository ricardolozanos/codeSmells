package noapplet.SolSystem;


import java.awt.*;
import java.util.*;
public class Sol extends noapplet.AnimationNoApplet {
    private final int x;
    private final int y;
    private final int radius;
    private final Color color;
    private java.util.List<Planett> planets;

    public Sol(int x, int y, int radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        planets = new ArrayList<>();
        planets.add(new Planett(100, 10, 0, Color.ORANGE, 10, this));
        planets.add(new Planett(125, 6, 15, Color.YELLOW, 10, this));
        planets.add(new Planett(215, 14, 0, Color.GREEN, 10, this));
        planets.add(new Planett(280, 6, 0, Color.BLUE, 10, this));
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
        for (var p : planets) {
            p.draw(g);
        }
    }
    public int getX() {
        return x;
    }
}