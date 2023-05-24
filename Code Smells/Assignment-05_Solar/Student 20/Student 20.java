//import src.noapplet.Sun;

import src.noapplet.AnimationNoApplet;

import java.awt.*;
import java.util.ArrayList;

public class Main extends AnimationNoApplet {
    private Sun sun;
    private java.util.List<Planet> planets;

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        sun.draw(g);


    }

    public static void main(String[] args) {
            new Main().run();
    }
    @Override
    protected void initAnimation(){
        super.initAnimation();
        sun = new Sun(dim.width/2,dim.height/2,30,Color.yellow, dim.width,dim.height,planets);
    }
}
class Sun {
    private final int x;
    private final int y;
    private final int width,height;
    private final int radius;
    private final Color color;
    private final java.util.List<Planet> planets;

    public Sun(int x, int y, int radius, Color color,int width,int height,java.util.List<Planet> planets ) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        this.width = width;
        this.height = height;
        this.planets = planets;

        planets = new ArrayList<>();
        planets.add(new Planet(40,10,360,Color.green,10,width,height,this));
        planets.add(new Planet(50,5,180,Color.blue,10,width,height,this));
    }

    public void draw(Graphics g){
       g.setColor(color);
       g.fillOval(x-radius,y-radius,radius*2,radius*2);
       for (var p: planets){
            p.draw(g);
        }
    }
    public int getX(){
      return this.x;
    }
    public int getY(){
        return this.y;
    }
}

class Planet{
    private int x;
    private int y;
    private int distance;
    private int radius, angle,speed,width,height;
    private Color color;
    private Sun sun;
    private java.util.List<Moon> moons;
    public Planet(int distance, int radius, int angle, Color color, int speed,int width, int height,Sun sun){
        this.x = 0;
        this.y = 0;
        this.distance=distance;
        this.radius=radius;
        this.angle=angle;
        this.color=color;
        this.speed=speed;
        this.width = width;
        this.height = height;
        this.sun=sun;
        moons = new ArrayList<>();
        moons.add(new Moon(5,5,70,Color.green, this));
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public void draw(Graphics g){
        x = sun.getX() + distance;
        y = sun.getY() + distance;
        g.setColor(color);
        g.fillOval(x-radius,y-radius,radius*2,radius*2);
        x = calX();
        y = calY();

    }
    private int calX() {
        int center = width / 2;   // dim: dimension of this planet
        return (int) (center + distance * Math.cos(Math.toRadians(angle++))); // angle in degrees (0-360)
    }
    private int calY() {
        int center = width / 2;   // dim: dimension of this planet
        return (int) (center + distance * Math.sin(Math.toRadians(angle++))); // angle in degrees (0-360)
    }

}
class Moon{
    private int distance;
    private int radius, angle;
    private Color color;
    private Planet planet;


    public Moon(int distance, int radius, int angle, Color color, Planet planet){
        this.distance = distance;
        this.radius = radius;
        this.angle = angle;
        this.color = color;
        this.planet = planet;
        }
    public void draw(Graphics g){
        int x = planet.getX() + distance;
        int y = planet.getY() + distance;
        g.setColor(color);
        g.fillOval(x-radius,y-radius,radius*2,radius*2);
        x = calX();
        y = calY();

    }
    private int calX() {
        int center = planet.getX();   // dim: dimension of this planet
        return (int) (center + distance * Math.cos(Math.toRadians(angle++))); // angle in degrees (0-360)
    }
    private int calY() {
        int center = planet.getX();   // dim: dimension of this planet
        return (int) (center + distance * Math.sin(Math.toRadians(angle++))); // angle in degrees (0-360)
    }
}
