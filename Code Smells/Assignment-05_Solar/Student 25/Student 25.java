//Victor Orozco
//Ruben Bolado

import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import noapplet.NoApplet;


public class SolarSystem extends JFrame {
    // Class for the Sun
    private class Sun {
        int x, y, radius;
        Color color;
        
        public Sun(int x, int y, int radius, Color color) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.color = color;
        }
        
        public void draw(Graphics g) {
            g.setColor(color);
            g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
            g.setColor(Color.red);
            g.drawString("Sun", x, y);
        }
    }
    
    // Class for the Planet
    private class Planet {
        int x, y, radius;
        Color color;
        int orbitRadius;
        double angle;
        double orbitSpeed;
        
        public Planet(int x, int y, int radius, Color color, int orbitRadius, double orbitSpeed) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.color = color;
            this.orbitRadius = orbitRadius;
            this.orbitSpeed = orbitSpeed;
        }
        
        public void draw(Graphics g) {
            x = (int)(x + orbitRadius * Math.cos(angle));
            y = (int)(y + orbitRadius * Math.sin(angle));
            g.setColor(color);
            g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
            g.setColor(Color.green);
            g.drawString("Planet", x, y);
            angle += orbitSpeed;
        }
    }
    
    // Class for the Moon
    private class Moon {
        int x, y, radius;
        Color color;
        int orbitRadius;
        double angle;
        double orbitSpeed;
        
        public Moon(int x, int y, int radius, Color color, int orbitRadius, double orbitSpeed) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.color = color;
            this.orbitRadius = orbitRadius;
            this.orbitSpeed = orbitSpeed;
        }
        
        public void draw(Graphics g) {
            x = (int)(x + orbitRadius * Math.cos(angle));
            y = (int)(y + orbitRadius * Math.sin(angle));
            g.setColor(color);
            g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
            g.setColor(Color.black);
            g.drawString("Moon", x, y);
            angle += orbitSpeed;
        }
    }
    
    public SolarSystem() {
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void paint(Graphics g) {
        Sun sun = new (Sun);
    }