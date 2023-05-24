package noapplet.Solar;


import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.Font;

import noapplet.example.AnimationNoApplet;


class Solar extends AnimationNoApplet {
    private Sun sun;
    private Random ran;
    private List<Integer> xv = new ArrayList<>();
    private List<Integer> yv = new ArrayList<>();

    public Solar(String[] params) {
        super(params);
    }

    @Override
    protected void initAnimation() {
        ran = new Random();
        super.initAnimation();
        sun = new Sun(dim.width/2, dim.height/2, 100, Color.RED);
        for (int i=0; i<21; i++) {
            xv.add(ran.nextInt(dim.width));
            yv.add(ran.nextInt(dim.height));
        }

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, dim.width, dim.height);
        g.setColor(Color.white);
        for (int i=0; i<21; i++) {
            g.fillOval(xv.get(i), yv.get(i), 10, 10);
        }
        sun.paint(g);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        g.setColor(Color.WHITE);
        g.drawString("William Dunlap", 100, 100);
    }
    public static void main(String[] args) {
        new Solar(new String[] {"width=1500", "height=1000"}).run();
    }


}



class Sun {
    private int x, y, radius;
    private Color color;
    private List<Planet> planets = new ArrayList<Planet>();
    

    public Sun(int x,int y, int radius,Color color) {
        this.x =x;
        this.y = y;
        this.radius = radius;
        this.color = color;

        planets.add(new Planet(100, 5, 30, 3, Color.blue, this));
        planets.get(0).addmoon(40, 0, 15, 5, Color.MAGENTA, planets.get(0));
        planets.add(new Planet(300, 5, 30, 1, Color.green, this));
        planets.get(1).addmoon(40, 0, 15, 2, Color.yellow, planets.get(1));
        planets.get(1).addmoon(60, 0, 10, -3, Color.CYAN, planets.get(1));
        planets.add(new Planet(500, 100, 50, -1, Color.gray, this));

    }

    public void paint(Graphics g){
        g.setColor(color);
        g.fillOval(x-radius/2, y-radius/2, radius, radius);
        for (Planet i: planets) {
            i.paint(g);
        }
    }

    public int getx(){
        return x;
    }

    public int gety(){
        return y;
    }



}


class Planet {
    private int x, y, radius, distance, angle, speed;
    private Color color;
    private Sun sun;
    private List<Moon> moons = new ArrayList<Moon>();

    public Planet (int distance, int angle, int radius, int speed, Color color, Sun sun) {
        this.distance=distance;
        this.angle=angle;
        this.radius = radius;
        this.color = color;
        this.sun = sun;
        this.speed = speed;
    }

    private int Calx(){
        return (int)(sun.getx()+distance*Math.cos(Math.toRadians(angle)));
    }

    private int Caly(){
        return (int)(sun.gety()+distance*Math.sin(Math.toRadians(angle)));
    }

    public void paint(Graphics g) {
        angle = angle+speed;
        x = Calx();
        y = Caly();
        g.setColor(color);
        g.fillOval(x-radius/2, y-radius/2, radius, radius);

        for (Moon i: moons) {
            i.paint(g);
        }
    }

    public int getx(){
        return x;
    }

    public int gety(){
        return y;
    }

    public void addmoon(int distance, int angle, int radius, int speed, Color color, Planet planet){
        moons.add(new Moon(distance, angle, radius, speed, color, planet));
    }


}

class Moon {
    private int x, y, radius, distance, angle, speed;
    private Color color;
    private Planet sun;

    public Moon (int distance, int angle, int radius, int speed, Color color, Planet sun) {
        this.distance=distance;
        this.angle=angle;
        this.radius = radius;
        this.color = color;
        this.sun = sun;
        this.speed = speed;
    }

    private int Calx(){
        return (int)(sun.getx()+distance*Math.cos(Math.toRadians(angle)));
    }

    private int Caly(){
        return (int)(sun.gety()+distance*Math.sin(Math.toRadians(angle)));
    }

    public void paint(Graphics g) {
        angle = angle+speed;
        x = Calx();
        y = Caly();
        g.setColor(color);
        g.fillOval(x-radius/2, y-radius/2, radius, radius);
    }

}