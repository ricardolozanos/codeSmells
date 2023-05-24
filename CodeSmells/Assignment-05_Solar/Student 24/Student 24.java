package noapplet.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
/**
 * Author: Jesus Oropeza, Dante Lopez
 */
public class SolarSystem extends AnimationNoApplet{

    protected Sun sun;
    private Color color = new Color(255,215,0);
    private int radius = 20;
    private int x, y;
    protected Font font = new Font("Monospaced", Font.BOLD, 25);
    private int[] stars = new int[100];
    Random rand = new Random();

    public SolarSystem(String[] args){
        super(args);
        for(int i=0; i<100;i++){
            stars[i] = rand.nextInt(500);
        }
    }

    public static void main(String[] args){
        new SolarSystem(args).run();
    }

    @Override
    protected void initAnimation(){
        int center = (dim.width/2);
        x = dim.width/2 - radius;
        y = dim.height/2 - radius;
        sun = new Sun(x,y,radius, center, color);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        // Create space
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, dim.width, dim.height);
        // Create stars
        g.setColor(Color.WHITE);
        for(int i=0; i<99; i++){
            g.fillOval(stars[i],stars[i+1], 2,2);
        }
        
        // Create sun
        g.setColor(color);
        sun.draw(g);

        // Create planet
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString(String.format("Jesus Oropeza & Dante Lopez"), 10, 400);
    }
}
/////////////////////////////////////////////////////////////////////////////////
class Sun{
    private final int x;
    private final int y;
    private final int radius;
    private final Color color;
    private final java.util.List<Planet> planets;
    private final int center;

    public Sun(int x, int y, int radius, int center, Color color){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.center = center;
        this.color = color;

        int distance = ((int) Math.sqrt(Math.pow((double) x, 2) + Math.pow((double) y, 2))) / 3; // Calculating distance from the sun
        planets = new ArrayList<>();
        planets.add(new Planet(distance, 10, 0, new Color(240,180,140), 3, center, "Tattooine"));
        planets.add(new Planet(distance, 15, 200, Color.BLUE, 3, center, "Alderaan"));
        planets.add(new Planet(distance*2,30, 180, new Color(224,255,255), 1, center, "Hoth"));

    }
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, radius*2, radius*2);

        for(var p : planets){
            p.draw(g);
        }
    }
}
//////////////////////////////////////////////////////////////////////////
class Planet {
    private final int center;
    private int distance, radius, angle, speed;
    private Color color;
    private int x, y;
    private int dx, dy;
    private final java.util.List<Moon> moons;
    protected String planetName;

    public Planet(int distance, int radius, int angle, Color color, int speed, int center, String planetName){
        this.distance = distance;
        this.radius = radius;
        this.angle = angle;
        this.color = color;
        this.speed = speed;
        this.center = center;
        this.planetName = planetName;

        moons = new ArrayList<>();
        if(planetName == "Tattooine"){
            moons.add(new Moon(5, 0, new Color(139,0,0), 15, radius));
        }
        if(planetName == "Alderaan"){
            moons.add(new Moon(2, 0, new Color(0,255,0), 20, radius));
            moons.add(new Moon(4, 90, new Color(75,0,130), 15, radius));
        }
        if(planetName == "Hoth"){
            moons.add(new Moon(10, 0, new Color(173,216,230), 2, radius));
        }
    }
    
    // draw planets
    public void draw(Graphics g){

        angle += speed;
        if (angle == 360){
            angle = 0;
        }
        var dx = calX();
        var dy = calY();

        g.setColor(color);
        g.fillOval(dx-radius, dy-radius, radius*2, radius*2);
        // Calculate planets' center to be passed into Moon draw
        int plCenterX = dx-radius/2;
        int plCenterY = dy-radius/2;
        for(var m : moons){
            m.draw(g, plCenterX, plCenterY);
        }
    }
    public int calX(){
        return (int) (center + distance * Math.cos(Math.toRadians(angle))); // angle in degrees 0-360
    }
    public int calY(){
        return (int) (center + distance * Math.sin(Math.toRadians(angle)));
    }

}
////////////////////////////////////////////////////////////////////////
class Moon{

    private final int radius;
    private int angle;
    private final Color color;
    private final int speed;
    private final int pRadius;

    public Moon(int radius, int angle, Color color, int speed, int pRadius){
        this.radius = radius;
        this.angle = angle;
        this.color = color;
        this.speed = speed;
        this.pRadius = pRadius;
    }
    // Moon draw
    public void draw(Graphics g, int x, int y){
        angle += speed;
        if (angle == 360){
            angle = 0;
        }

        int distance = (((int) Math.sqrt(Math.pow((double) x, 2) + Math.pow((double) y, 2)))/pRadius) + pRadius; // Calculate distance from planet
        var dx = calX(distance, x);
        var dy = calY(distance, y);

        g.setColor(color);
        g.fillOval(dx-radius, dy-radius, radius*2, radius*2);

    }
    public int calX(int distance, int center){
        return (int) (center + distance * Math.cos(Math.toRadians(angle))); // angle in degrees 0-360
    }
    public int calY(int distance, int center){
        return (int) (center + distance * Math.sin(Math.toRadians(angle)));
    }
}