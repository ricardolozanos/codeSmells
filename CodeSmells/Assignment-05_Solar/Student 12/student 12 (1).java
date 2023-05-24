import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

class Sun extends JPanel {
    private int sunSize = 50;
    public int x = 200;
    public int y = 200;
    private ArrayList<Planet> planets = new ArrayList<Planet>();
    public int getSunSize(){
        return sunSize;
    }
    public void addPlanets(Planet planet){
        this.planets.add(planet);
    }
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
        this.x = (getWidth() - sunSize) / 2;
        this.y = (getHeight() - sunSize) / 2;
        g.setColor(Color.RED);
        g.fillOval( x,y, sunSize, sunSize);

        g.setColor(Color.white);
        g.drawString("Carlos Cisneros", 200, 50);
        for(Planet planet: planets){
            planet.draw(g);
        }
    }    
  }