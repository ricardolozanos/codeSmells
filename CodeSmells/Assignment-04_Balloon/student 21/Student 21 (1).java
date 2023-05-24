package noapplet;

import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author Dante Lopez
 * Partner: Jesus Oropeza
 * Balloon grows
 *
 */

public class Balloon extends noapplet.NoApplet{
	protected Timer t;
	protected int x, y;
	protected int d = 1;
	protected int grow = 1;
	
	public Balloon(String[] params) {
		super(params);
	}
	public void init() {
		t = new Timer(d, e-> repaint());
	}
	public void start() {
		t.start();
	}
	public void stop() {
		t.stop();
	}
	public void paintComponent(Graphics g) {
		// paint the current frame
		Dimension s = getSize();
		grow += 1;
		x = s.width/2 - grow/2;
        y = s.height/2 - grow/2;
		g.setColor(Color.WHITE);
        g.fillRect(0, 0, s.width, s.height);
        g.setColor(Color.GREEN);
        g.fillOval(x, y, grow, grow);
        
		
	}
	// other fields an methods
	  public static void main(String[] args) {
		  // or specify optional parameters such as the window size
		  new Balloon(new String[] {"width=500", "height=250"}).run();
	  }
}
