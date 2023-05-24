package noapplet;

import noapplet.example.AnimationNoApplet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.util.*;

public class SolarSystem extends AnimationNoApplet {
    private Sun sun;
    private List<Planets> planets = new ArrayList<>();
    private List<Moon> moon = new ArrayList<>(); //moons for each planet
    private List<Moon> moon2 = new ArrayList<>();
    private List<Moon> moon3 = new ArrayList<>();


    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);                       //background color
        g.fillRect(0, 0, dim.width, dim.height); //fill in background
        g.setColor(Color.YELLOW);                      //Stars color
        g.fillOval(2, 2, 1, 1);     //Stars - start
        g.fillOval(200, 360, 1, 1);
        g.fillOval(129, 30, 1, 1);
        g.fillOval(57, 200, 1, 1);
        g.fillOval(390, 380, 1, 1);
        g.fillOval(10, 120, 1, 1);
        g.fillOval(200, 160, 1, 1);
        g.fillOval(165, 210, 1, 1);
        g.fillOval(10, 340, 1, 1);
        g.fillOval(355, 34, 1, 1);
        g.fillOval(350, 250, 1, 1);
        g.fillOval(300, 312, 1, 1); //Stars - end
        //drawing my name
        g.setFont(new Font("San-serif", Font.BOLD, 12));
        g.setColor(Color.MAGENTA);
        g.drawString("Nayeli Ramirez", 280, 350);
        //Finally draw the sun
        sun.draw(g);


    }
    public static void main(String[] args){
        new SolarSystem().run();
    }

    @Override
    protected void initAnimation() {
        super.initAnimation();
        sun = new Sun(dim.width / 2, dim.height/2, 30, Color.RED, planets);
        //first planet
        planets.add(new Planets(70, 10, 0, Color.GREEN, 1, sun, moon));
        //second planet
        planets.add(new Planets(120, 15, 90, Color.ORANGE, 1, sun, moon2));
        //third planet with no moons and it's fast
        planets.add(new Planets(200, 5, 180, Color.LIGHT_GRAY, 2, sun, moon3));
        //moon for first planet
        moon.add(new Moon(20, 3, 20, Color.GRAY, 2, planets.get(0)));
        //moons for second planet
        moon2.add(new Moon(30, 4, 0, Color.BLUE, 2, planets.get(1)));
        moon2.add(new Moon(30, 6, 30, Color.CYAN, 2, planets.get(1)));
    }

}
class Sun{
    private final int x;
    private final int y;
    private final int radius;
    private final Color color;
    private final List<Planets> planets;

    public Sun(int x, int y, int radius, Color color, List<Planets> planets){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        this.planets = planets; //takes in a list of planets
    }
    public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(x-radius, y-radius, radius*2, radius*2);
        for (var p: planets){
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
class Planets{
    public int x, y; //keep track of planet's x and y
    private final int distance;
    private final int radius;
    private int angle;
    private final Color color;
    private final int speed;
    private Sun sun;
    private final List<Moon> moon;
    public Planets(int distance, int radius, int angle, Color color, int speed, Sun sun, List<Moon> moon){
        this.distance = distance;
        this.radius = radius;
        this.angle = angle;
        this.color = color;
        this.speed = speed;
        this.sun = sun; //gets matched to a sun
        this.moon = moon;  //gets a list of corresponding moons

    }
    private int calX() {
        int center = radius;   //dimension of this planet
        return (int) (center + distance * Math.cos(Math.toRadians(angle)));
    }
    private int calY() {
        int center = radius;   // dim: dimension of this planet
        return (int) (center + distance * Math.sin(Math.toRadians(angle)));
    }
    public int getX(int angle){ //calculates x of planet based on angle
        this.angle = angle;
        return calX();
    }
    public int getY(int angle){ //calculates y of planet based on angle
        this.angle = angle;
        return calY();
    }

    public void draw(Graphics g){
        x = calX(); //x of planet
        y = calY(); //y of planet
        int sunX = sun.getX() - radius;
        int sunY = sun.getY() - radius;

        x = sunX + x;
        y = sunY + y;
        g.setColor(color);
        g.fillOval(x-radius, y-radius, radius*2, radius*2);
        angle = angle + speed; //increment angle by how fast we want planet to travel
        for (var m: moon){ //draw corresponding moons if any
            m.draw(g);
        }
    }
}
class Moon{
    private final int distance;
    private final int radius;
    private int angle;
    private final Color color;
    private final int speed;
    private Planets planet;
    public Moon(int distance, int radius, int angle, Color color, int speed, Planets planet){
        this.distance = distance;
        this.radius = radius;
        this.angle = angle;
        this.color = color;
        this.speed = speed;
        this.planet = planet; //moons corresponding planet

    }
    private int calMoonX() {
        int center = radius;   //dimension of this moon
        return (int) (center + distance * Math.cos(Math.toRadians(angle)));
    }
    private int calMoonY() {
        int center = radius;   //dimension of this moon
        return (int) (center + distance * Math.sin(Math.toRadians(angle)));
    }
    public void draw(Graphics g){
        int x = calMoonX();
        int y = calMoonY();
        int planetX = planet.x - radius;
        int planetY = planet.y - radius;

        x = planetX + x;
        y = planetY + y;
        g.setColor(color);
        g.fillOval(x-radius, y-radius, radius*2, radius*2);
        angle = angle + speed; //increment angle by how fast we want moon to travel

    }

}
