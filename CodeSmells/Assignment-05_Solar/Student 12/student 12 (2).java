import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

class Planet extends JPanel {
    public int size = 50;
    public int x;
    public int y;
    private Sun sun ;
    private Color color;
    private int angle;
    private int distance;
    private int speed;

    public ArrayList<Planet> moons;// only has moons if is planet
    public Planet planet; // only has planet if is Moon
    public boolean hasMoon = false;

    public Planet( int size, Sun sun, Color color, int distance,int speed){
        this.size = size;
        this.sun = sun;
        this.color = color;
        this.distance = distance;
        this.speed = speed;
    }
    public Planet( int size, Planet planet, Color color, int distance, int speed){
        this.size = size;
        this.planet = planet;
        this.color = color;
        this.distance = distance;
        this.speed = speed;
    }
    public void addMoons(Planet moon){
        if(!hasMoon){
            moons = new ArrayList<Planet>();
        }
        this.hasMoon = true;
        this.moons.add(moon);
    }

    public Color getColor(){
        return this.color;
    }
    public int getsize(){
        return this.size;
    }
    public int calX() {
        int center = sun.x + sun.getSunSize() / 2;
        return (int) (center + distance * Math.cos(Math.toRadians(this.angle))); // angle in degrees (0-360)
    }
    public int calY() {
        int center = sun.y + sun.getSunSize() / 2;
        return (int) (center + distance * Math.sin(Math.toRadians(this.angle))); // angle in degrees (0-360)
    }
    public void draw(Graphics g){
        angle();
        g.setColor(this.color);
        this.x =  calX();
        this.y =  calY();
        g.fillOval( x,y, size, size);
        if(hasMoon){
            for(Planet moon: moons){
                moon.drawMoon(g);
            }
        }

    }
    //-----------ANGLE-----------
    public int angle(){
        if(this.angle < 360){
            this.angle += speed;
        }else{
            this.angle= 0;
        }
        return angle;
     }
    //______________MOONS_________________
    public int calXPlanet() {
        int center = planet.x + planet.size / 2;
        return (int) (center + distance * Math.cos(Math.toRadians(this.angle))); // angle in degrees (0-360)
    }
    public int calYPlanet() {
        int center = planet.y + planet.size / 2;
        return (int) (center + distance * Math.sin(Math.toRadians(this.angle))); // angle in degrees (0-360)
    }
    public void drawMoon(Graphics g){
       angle();
       g.setColor(this.color);
       g.fillOval( calXPlanet(), calYPlanet(), size, size);
    }
}

    