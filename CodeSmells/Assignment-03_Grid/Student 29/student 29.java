package noapplet.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import noapplet.NoApplet;

/**
 * Simple NoAppet app to draw a text and an image. The displayed image
 * is obtained from the file <code>src/image/rabbit.jpg</code>, where
 * <code>src</code> is the resource directory of your Java project.
 * Refer to your IDE to designate the resource directory of your project.
 */
@SuppressWarnings("serial")
public class Omok extends NoApplet {

	public Omok() {
	}

	public Omok(String[] params) {
		super(params);
	}
	
	
	@Override
    protected void paintComponent(Graphics g) {
        Dimension d = getSize();
        g.setColor(Color.BLACK);
        
        // For loops to create Omok Temp board
        for (int i =0; i<d.height; i+=d.height/10) {
        	g.drawLine(0, i , d.width, i);
        }
        for (int i=0; i<d.width; i+= d.width/10) {
        	g.drawLine(i, 0, i, d.height);
        }
        
        //Place red and blue ovals on board
        g.setColor(Color.RED);
        g.fillOval(30, 100, 10, 10);
        g.setColor(Color.BLUE);
        g.fillOval(65, 65, 10, 10);
        
        //Print my Name on board
        g.setFont(new Font("San-serif", Font.BOLD, 33));
        g.setColor(Color.ORANGE);
        g.drawString("Christian Revilla", 65, 150);
    }  

    public static void main(String[] args) {
    	//new HelloWorld().run();
    	// or specify optional parameters such as the window size
        new Omok(new String[] {"width=330", "height=350"}).run();
    }
}
