package Solar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.Timer;

import noapplet.NoApplet;
import java.awt.*;
import java.util.*;

@SuppressWarnings("serial")
public class Solar_system extends noapplet.AnimationNoApplet {
	private Sun sun;
	
	protected Solar_system() {
    }

    protected Solar_system(String[] args) {
    	super(args);
    }
    
	protected void initAnimation(){
        super.initAnimation();
        sun = new Sun(dim.width/2, dim.height/2,30, Color.RED);
    }   	
    
    @Override 
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	g.setColor(Color.BLACK);
        g.fillRect(0, 0, dim.width, dim.height);
        sun.draw(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("San-serif", Font.BOLD, 24));
        g.drawString("Nathanael Perez", 800, 50);
    } 
    
    //protected void Sun()
    
	public static void main(String[] args) {
		new Solar_system(new String[] {"width=1000", "height=1000"}).run();
	}

}

