package noapplet.assignments.Solar;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Sun {
    private final int x;
    private final int y;
    private final int radius;
    private final Color color;
    private final List<Planet> planets;
    


    public Sun(int x, int y, int radius, Color color){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;

        planets = new ArrayList<>();
        
        planets.add(new Planet(100, 10, 0, Color.green, 100, this ));
        

    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    } 

    public int getRadius(){
        return radius;
    }

    public List<Planet> getPlanets() {
        return planets;
    }



    public void draw(Graphics g){
        g.setFont(new Font("San-serif", Font.BOLD, 20));
        g.setColor(Color.white);
        g.drawString("Diego Jared Avina", 60, 40);
        g.setColor(color);
        g.fillOval(x - radius, y - radius, 2*radius, 2*radius);

        for (Planet p: planets){
            p.draw(g);
        }
    }
}
