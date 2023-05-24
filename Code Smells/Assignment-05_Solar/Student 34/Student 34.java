package noapplet.solarsystem;
import noapplet.AnimationNoApplet;

import noapplet.AnimationNoApplet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

import static java.awt.Color.red;

public class ssMain extends AnimationNoApplet {
    private Sun sun;
    private Planet planet;

    @Override
    protected void paintComponent(Graphics g) {
        Random rand = new Random();

        Dimension d = getSize();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, d.width, d.height);
        g.setColor(Color.BLUE);
        g.drawString("Anthony Romero", 20,20);
        g.setColor((Color.white));
        g.fillOval(rand.nextInt(400), rand.nextInt(400), 1, 1);
        g.fillOval(rand.nextInt(400), rand.nextInt(400), 1, 1);
        g.fillOval(rand.nextInt(400), rand.nextInt(400), 1, 1);
        g.fillOval(rand.nextInt(400), rand.nextInt(400), 1, 1);
        sun.draw(g);



    }
    public static void main(String[] args){
        new ssMain().run();
    }
    @Override
    protected void initAnimation() {

        super.initAnimation();
        //System.out.println(dim.width);
        sun = new Sun( dim.width / 2, dim.height / 2, 90, Color.YELLOW);


    }
}

class Sun {
    private final int x;
    private  final int y;
    private final int radius;
    private final Color color;
    private  final java.util.List<Planet> planets;


    public Sun ( int x, int y, int radius, Color color){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        System.out.print(x);

        planets = new ArrayList<>();
        planets.add(new Planet(123, 9, 60, Color.GREEN, this));
        planets.add(new Planet(152, 4, 60, Color.RED, this));
        planets.add(new Planet(45, 8, 60, Color.ORANGE, this));
    }

    public void draw(Graphics g) {
        g.setColor(color);
        // was fill oval
        g.fillOval(x, y, radius, radius);


        for (var p: planets){
            //System.out.println(planets.size());
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

class Planet {

    private int distance, radius, angle;
    private Color color;
    private Sun sun;

    public Planet(int distance, int radius, int angle, Color color, Sun sun) {
        this.distance = distance;
        this.radius = radius;
        this.angle = angle;
        this.color = color;
        this.sun = sun;

    }

    public void draw(Graphics g) {

        int x1 = calX();
        int y1 = calY();
        int x = x1 + sun.getX();
        int y = y1 + sun.getX();
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);


    }

    public int getX(){

        int center = 200;   // dim: dimension of this planet
        return (int) (center + distance * Math.cos(Math.toRadians(angle))); // angle in degrees (0-360)
    }

    public int getY(){
        int center = 200;   // dim: dimension of this planet
        return (int) (center + distance * Math.cos(Math.toRadians(angle))); // angle in degrees (0-360)
    }
    private int calX() {
        int x = (int) (distance * Math.cos(Math.toRadians(angle))); // angle in degrees (0-360)
        System.out.println(x);
        return x;
    }
    private int calY() {

        int y = (int) (distance * Math.cos(Math.toRadians(angle))); // angle in degrees (0-360)
        System.out.println(y);
        return y;
    }

}

