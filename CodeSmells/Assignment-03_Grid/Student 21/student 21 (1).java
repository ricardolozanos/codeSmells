package noapplet.example;

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
public class HelloWorld extends NoApplet {

	public HelloWorld() {
	}

	public HelloWorld(String[] params) {
		super(params);
	}
	
    protected void paintComponent(Graphics g) {
    	int row = 16;
    	int col = 16;
    			
        Dimension d = getSize();
        g.setColor(Color.orange);
        g.fillRect(0, 0, d.width, d.height);
        g.setFont(new Font("San-serif", Font.BOLD, 24));
        g.setColor(Color.black);
        g.drawString("Dante Lopez", 60, 40);
        g.setColor(Color.black);
        for(int i = 0; i < 16 + 1; i++) {
        	g.drawLine(50, 50 + i * 15, 50 + col * 15, 50 + i * 15);
        }
        for(int j = 0; j < 16 + 1; j++) {
        	g.drawLine(50 + j * 15, 50, 50 + j * 15, 50 + row * 15);
        }
        g.fillOval(117, 117, 15, 15);
        g.setColor(Color.red);
        g.fillOval(147, 162, 15, 15);
        g.setColor(Color.black);
    } 

    public static void main(String[] args) {
    	//new HelloWorld().run();
    	// or specify optional parameters such as the window size
        new HelloWorld(new String[] {"width=330", "height=350"}).run();
    }
}
