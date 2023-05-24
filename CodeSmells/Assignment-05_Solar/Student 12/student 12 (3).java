import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SolarSystem {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Solar System");
    Sun sun = new Sun( );
    Planet planet2 = new Planet( 15, sun, Color.BLUE, 100, 4);
    Planet planet1 = new Planet( 23, sun, Color.PINK, 200, 2 );
    Planet planet3 = new Planet( 28, sun, Color.orange, 150, 1);
    Planet planet4 = new Planet( 19, sun, Color.green, 50, 3);
    Planet planet5 = new Planet( 30, sun, Color.green, 280, 4);
    Planet moon1 = new Planet(6, planet1, Color.GRAY, 20,16);
    Planet moon2 = new Planet(8, planet1, Color.white, 37, 18);
    Planet moon3 = new Planet(6, planet5, Color.GRAY, 20,16);
    Planet moon4 = new Planet(8, planet5, Color.white, 37, 18);
    Planet moon5 = new Planet(8, planet5, Color.pink, 40, 12);

    planet1.addMoons(moon1);
    planet1.addMoons(moon2);

    planet5.addMoons(moon3);
    planet5.addMoons(moon4);
    planet5.addMoons(moon5);

    sun.addPlanets(planet2);
    sun.addPlanets(planet1);
    sun.addPlanets(planet3);
    sun.addPlanets(planet4);
    sun.addPlanets(planet5);
    frame.add(sun);
    frame.setSize(new Dimension(400,400));
    frame.setVisible(true);
    Timer timer = new Timer(20, new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        sun.repaint();
      }
    });
    timer.start();
  }
}