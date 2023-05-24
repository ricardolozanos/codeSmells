package noapplet;

import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author Dante Lopez
 * Partner: Jesus Oropeza
 * Balloon grows and shrinks
 *
 */

public class Balloon2 extends Balloon{
	protected boolean flag = true;
	
	public Balloon2(String[] params) {
		super(params);
	}
	
	public void paintComponent(Graphics g) {
		// paint the current frame
		Dimension s = getSize();
		if(flag || grow == 1) {
			grow += 1;
			flag = true;
		}
		if(grow == s.height || !flag) {
        	flag = false;
        	grow -= 1;
        }
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
		  new Balloon2(new String[] {"width=500", "height=250"}).run();
	  }
}
