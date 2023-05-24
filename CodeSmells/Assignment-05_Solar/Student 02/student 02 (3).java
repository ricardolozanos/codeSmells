package noapplet.example.solar;

import noapplet.example.AnimationNoApplet;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Main extends AnimationNoApplet {
    private Sun sun;
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        sun.draw(g);
    }
    public static void main(String[] args){
        new Main().run();
    }

    protected void initAnimation(){
        super.initAnimation();
        sun = new Sun(dim.width /2, dim.height /2, 10, Color.RED);
    }

}
class Sun {
    private final int x;
    private final int y;
    private final int radius;
    private final Color color;
    private final java.util.List<Planet> planets;
    public Sun(int x, int y, int radius, Color color){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;

        planets = new ArrayList<>();
        planets.add(new Planet(80,5,0,Color.GREEN, 3, this));
        planets.add(new Planet(100,12,0,Color.CYAN, 2, this));
        planets.add(new Planet(150,18,0,Color.YELLOW, 3, this));
        planets.add(new Planet(200,4,0,Color.PINK, 2, this));
    }

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 500, 400);
        g.setColor(Color.RED);
        g.setFont(new Font("San-serif", Font.BOLD, 12));
        g.drawString("Jordan Aguon", 0, 20);
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);

        for (var p: planets){
            p.draw(g);
        }
    }

    public int getX(){
        return x;
    }
}

class Planet {

    private int distance;
    private int radius;
    private int angle;
    private int x;
    private int y;
    private Color color;
    private int speed;
    private Sun sun;
    private final java.util.List<Moon> Moons;


    public Planet(int distance, int radius, int angle, Color color, int speed, Sun sun) {
        this.distance = distance;
        this.radius = radius;
        this.angle = angle;
        this.color = color;
        this.speed = speed;
        this.sun = sun;

        Moons = new ArrayList<>();
        Moons.add(new Moon(10,2,0,Color.DARK_GRAY, 3, this));
    }

    public void draw(Graphics g) {
        var ran = new Random();
        x = ran.nextInt(distance);
        y = ran.nextInt(distance);
        x = ran.nextBoolean() ? x : -x;
        y = ran.nextBoolean() ? y : -y;

        x = sun.getX() + x;
        y = sun.getX() + y;

        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius *2);

        for (var p: Moons){
            p.draw(g);
        }
    }

    public int getX(){
        return x;
    }
}
class Moon {

    private int distance;
    private int radius;
    private int angle;
    private Color color;
    private int speed;
    private Planet planet;


    public Moon(int distance, int radius, int angle, Color color, int speed, Planet planet) {
        this.distance = distance;
        this.radius = radius;
        this.angle = angle;
        this.color = color;
        this.speed = speed;
        this.planet = planet;
    }

    public void draw(Graphics g) {
        var ran = new Random();
        var x = ran.nextInt(distance);
        var y = ran.nextInt(distance);
        x = ran.nextBoolean() ? x : -x;
        y = ran.nextBoolean() ? y : -y;

        x = planet.getX() + x;
        y = planet.getX() + y;

        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius *2);
    }
}


