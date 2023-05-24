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
        int rows = 0;
        int cols = 0;
        Dimension d = getSize();
        g.setColor(new Color(255, 161, 0));
        g.fillRect(0, 0, d.width, d.height);
        g.setFont(new Font("San-serif", Font.BOLD, 24));
        g.setColor(Color.BLACK);
        for(int i = 16; i > 0; i--){
            cols += 20;
            rows += 20;
            g.drawLine(0, rows, d.width, cols);
            g.drawLine(rows, 0, cols, d.height);
        }
        g.fillOval(150, 150, 20, 20);
        g.setColor(Color.red);
        g.fillOval(170,130, 20, 20);
        g.setColor(Color.blue);
        g.drawString("Jesus Oropeza", 60, 40);
//        g.drawImage(getImage("rabbit.jpg"), 40, 60, this);
    }  

    public static void main(String[] args) {
    	//new HelloWorld().run();
    	// or specify optional parameters such as the window size
        new HelloWorld(new String[] {"width=300", "height=300"}).run();
    }
}
