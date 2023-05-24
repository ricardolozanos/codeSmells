package noapplet.solarsystem;

import noapplet.AnimationNoApplet;

import java.awt.*;

public class SolarSystem extends AnimationNoApplet {
    private Sun sun = new Sun(Color.ORANGE, 50);
    private Planet earth = new Planet(10, Color.GREEN, sun, 55, 20, 2, true);
    private Planet saturn = new Planet(30, Color.RED, sun, 110, 300, 1, false);
    private Moon earthMoon = new Moon(4, Color.PINK, earth, 12, 220, 1, false);
    private Moon saturnMoon = new Moon(5, Color.YELLOW, saturn, 20, 20, 1, true);
    private Planet[] planetArray = new Planet[] {earth, saturn};
    private Moon[] moonArray = new Moon[] {earthMoon, saturnMoon};
    private int numStars = 20;
    private int[][] starArray;
    public int[][] generateStars(Dimension d, int numStars){
        int[][] starArray = new int[numStars][2];
        for (int i=0; i < numStars; i ++) {
            starArray[i][0] = (int) ((Math.random() * (d.width - 10)) + 0);
            starArray[i][1] = (int) ((Math.random() * (d.height - 10)) + 0);
        }
        return starArray;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Dimension d = getSize();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, d.width, d.height);

        g.setColor(Color.WHITE);
        if (starArray == null) {
            starArray = generateStars(d, numStars);
        }
        for (int i = 0; i < numStars; i++){
            g.fillOval(starArray[i][0], starArray[i][1], 2, 2);
        }

        g.setColor(sun.getColor());
        sun.calculatePosition(d);
        g.fillOval(sun.getPosition()[0], sun.getPosition()[1], sun.getRadius(), sun.getRadius());

        for (int i = 0; i < planetArray.length; i++){
            g.setColor(planetArray[i].getColor());
            planetArray[i].calculatePosition(d);
            g.fillOval(planetArray[i].getPosition()[0], planetArray[i].getPosition()[1], planetArray[i].getRadius(), planetArray[i].getRadius());
        }

        for (int i = 0; i < moonArray.length; i++){
            g.setColor(moonArray[i].getColor());
            moonArray[i].calculatePosition(d);
            g.fillOval(moonArray[i].getPosition()[0], moonArray[i].getPosition()[1], moonArray[i].getRadius(), moonArray[i].getRadius());
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("San-serif", Font.BOLD, 24));
        g.drawString("Emilio Tadeo de la Rocha Galan", 0, 25);
    }

    public static void main(String[] args){
        new SolarSystem().run();
    }
}

