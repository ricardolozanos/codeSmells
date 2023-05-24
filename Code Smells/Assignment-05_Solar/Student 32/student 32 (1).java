package noapplet.example.SolarSystem;
import noapplet.NoApplet;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Main2 extends AnimationNoApplet {
    Sun2 sun = new Sun2(200, 200, 30, Color.RED);

    public static void main(String[] args){
        new Main2().run();
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0,0,dim.width, dim.height);
        g.setColor(Color.BLUE);
        g.drawString("Emilio Rojero", 80, 40);
        sun.draw(g);
    }
}

class Sun2{
    private final int x;
    private final int y;
    private final int radius;
    private final Color color;
    private final java.util.List<Planet> planets;

    public Sun2(int x, int y, int radius, Color color){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;

        planets = new ArrayList<>();
        planets.add(new Planet(130, 16, 0, Color.BLUE, 10, this));
        planets.add(new Planet(50, 7, 90, Color.GREEN, 20, this));
        planets.add(new Planet(85, 13, 130, Color.RED, 30, this));
        planets.add(new Planet(190, 4, 200, Color.ORANGE, 10, this));
    }

    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
        for(var p: planets){
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

class Planet{

    private int distance, radius, angle, speed;
    private Color color;
    private Sun2 sun;
    int posX = 0, posY = 0;
    private final java.util.List<Moon> moons;
    public Planet (int distance, int radius, int angle, Color color, int speed, Sun2 sun){
        this.distance = distance;
        this.radius = radius;
        this.angle = angle;
        this.color = color;
        this.speed = speed;
        this.sun = sun;
        moons = new ArrayList<>();
        moons.add(new Moon(16, 5, 0, Color.GRAY, 40, this));
    }
    public void draw(Graphics g){
        int x = sun.getX(), y = sun.getY();
        double radians = Math.toRadians(angle);

        posX = Math.round((float)(x + Math.cos(radians) * (radius + distance)));
        posY = Math.round((float)(y + Math.sin(radians) * (radius + distance)));
        int velocity = speed / 10;
        angle += velocity;
        if (angle >= 360)
                angle = 0;
        g.setColor(color);
        g.fillOval(posX - radius, posY - radius, radius * 2, radius * 2);
        for(var m: moons){
            m.draw(g);
        }
    }
    public int getX(){
        return posX;
    }
    public int getY(){
        return posY;
    }
}
class Moon{
    private int distance, radius, angle, speed;
    private Color color;
    private Planet planet;
    public Moon (int distance, int radius, int angle, Color color, int speed, Planet planet){
        this.distance = distance;
        this.radius = radius;
        this.angle = angle;
        this.color = color;
        this.speed = speed;
        this.planet = planet;
    }
    public void draw(Graphics g){
        int x = planet.getX(), y = planet.getY();
        double radians = Math.toRadians(angle);
        int posX = 0, posY = 0;

        posX = Math.round((float)(x + Math.cos(radians) * (radius + distance)));
        posY = Math.round((float)(y + Math.sin(radians) * (radius + distance)));
        int velocity = speed / 10;
        angle += velocity;
        if (angle >= 360)
            angle = 0;
        g.setColor(color);
        g.fillOval(posX - radius, posY - radius, radius * 2, radius * 2);
    }
}
