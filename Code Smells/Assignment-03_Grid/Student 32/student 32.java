package noapplet;

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
        Dimension d = getSize();
        g.setColor(new Color(102,255,102));
        g.fillRect(0, 0, d.width, d.height);
        g.setFont(new Font("San-serif", Font.BOLD, 24));
        g.setColor(Color.BLUE);
        g.drawString("Emilio Rojero", 80, 40);
        //g.drawImage(getImage("rabbit.jpg"), 40, 60, this);
        g.setColor(Color.BLACK);
        int x = 0, y = 0;
        for ( x = 0; x <= 320; x += 20){
            g.drawLine(x, y, x, 336);
        }
        x = 0;
        for ( y = 0; y <= 336; y += 21){
            g.drawLine(x, y, 320, y);
        }
        g.setColor(Color.RED);
        g.drawOval(154, 183,12, 12);
        g.fillOval(154, 183,12, 12);

        g.setColor(Color.BLACK);
        g.drawOval(174, 203,12, 12);
        g.fillOval(174, 203,12, 12);
    }

    public static void main(String[] args) {
    	//new HelloWorld().run();
    	// or specify optional parameters such as the window size
        new HelloWorld(new String[] {"width=330", "height=350"}).run();
    }
}
