import src.noapplet.example.AnimationNoApplet;

import java.awt.*;



import java.util.ArrayList;
import java.util.Random;



public class Main extends AnimationNoApplet {

    private Sun sun;

    //private Planet planet;


    protected void initAnimation() {
        sun = new Sun(dim.width / 2, dim.height / 2, 30, Color.ORANGE);




    }



    Main() {
    }


    public static void main(String [] args){
        new Main().run();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, dim.width, dim.height);
        g.setColor(Color.PINK);
        g.fillOval(60,60,10,10);
        g.setColor(Color.BLUE);
        g.fillOval(90,90,10,10);
        g.setColor(Color.CYAN);
        g.fillOval(120,-10,10,10);
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(183,100,10,10);
        g.setColor(Color.MAGENTA);
        g.fillOval(160,40,10,10);
        g.setColor(Color.RED);
        g.fillOval(200,11,10,10);
        g.drawString("Samantha Silva", 250,34);
        sun.draw(g);
        //planet.draw(g);
        //what we wanna have for the moon part


    }
}

    class Sun {
        private final int x;
        private final int y;
        private final int radius;
        private final Color color;
        private final  java.util.List<Planet> planets;
        public Sun(int x, int y, int radius, Color color) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.color = color;
            planets = new ArrayList<>();
            planets.add(new Planet(120,20,360, 100,Color.GREEN,this));
            planets.add(new Planet(60,10,360, 30,Color.BLUE,this));
        }


        public void draw(Graphics g){
            g.setColor(color);
            g.fillOval(x - radius, y - radius, radius * 2, radius * 2);

            for (var p: planets) {
                p.draw(g);
            }
        }
        public int getX(){
            return x;
        }
    }



class Planet{
    private int distance, radius, angle, speed;
    private Color color;
    private Sun sun;
    private final java.util.List<Moon> moons;

    public Planet(int distance, int radius, int angle, int speed, Color color, Sun sun){
        this.sun = sun;
        this.distance = distance;
        this.radius = radius;
        this.angle = angle;
        this.color = color;
        this.speed = speed;

        moons = new ArrayList<>();
        moons.add(new Moon(150,10,360, 10,Color.GRAY,this));



    }
    protected int calX() {
        int center = 400 / 2;   // dim: dimension of this planet
        return (int) (center + distance * Math.cos(Math.toRadians(angle++))); // angle in degrees (0-360)
    }
    protected int calY() {
        int center = 400 / 2;   // dim: dimension of this planet
        return (int) (center + distance * Math.sin(Math.toRadians(angle++))); // angle in degrees (0-360)
    }
    public void draw(Graphics g){

        var x = this.calX();
        var y = this.calY();

        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
        for (var m: moons) {
            m.draw(g);
        }

    }
}
class Moon{
    private int distance, radius, angle, speed;
    private Color color;
    private Planet planet;

    public Moon(int distance, int radius, int angle, int speed, Color color, Planet planet){
        this.planet = planet;
        this.distance = distance;
        this.radius = radius;
        this.angle = angle;
        this.color = color;
        this.speed = speed;
        this.planet = planet;
    }
    protected int calX() {
        //int center = 400 / 2;   // dim: dimension of this planet
        return (int) (planet.calX() + distance * Math.cos(Math.toRadians(angle++))); // angle in degrees (0-360)
    }
    protected int calY() {
        //int center = 400 / 2;   // dim: dimension of this planet
        return (int) (planet.calY() + distance * Math.sin(Math.toRadians(angle++))); // angle in degrees (0-360)
    }
    public void draw(Graphics g){

        var x = this.calX();
        var y = this.calY();

        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}
