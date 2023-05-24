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
public class OmokBoard extends NoApplet {

	public OmokBoard() {
	}

	public OmokBoard(String[] params) {
		super(params);
	}

    /**
     *
     * @param g the <code>Graphics</code> object to protect
     * @return 2D grid representing the Omok Board Game with my name and 2 filled circles as playing stones
     *
     */
    protected void paintComponent(Graphics g) {
        Dimension d = getSize();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, d.width, d.height);
        g.setFont(new Font("Times New Roman", Font.BOLD, 24));
        g.setColor(new Color(128, 255,255));
        g.drawString("Adrian Urquizo", 70, 20);

        int x = 0;
        int y = 22;
        int len = 1000;
        int i = 0;
        while(i != 15){
            g.setColor(Color.white);
            g.drawLine(x, y, len, y);
            y+=22;
            i++;
        }
        x = 21;
        y = 0;
        i = 0;
        while(i != 15){
            g.setColor(Color.white);
            g.drawLine(x, y, x, len);
            x+=21;
            i++;
        }
        g.setColor(Color.green);
        g.fillOval(137, 188, 20, 20);
        g.setColor(Color.cyan);
        g.fillOval(158, 166, 20, 20);
    }

    public static void main(String[] args) {
    	//new OmokBoard().run();
    	// or specify optional parameters such as the window size
        new OmokBoard(new String[] {"width=330", "height=350"}).run();
    }
}
