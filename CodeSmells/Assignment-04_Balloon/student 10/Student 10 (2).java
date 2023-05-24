package noapplet.example;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Balloon2 extends Balloon {
	
	protected void paintComponent(Graphics g) {
		// adjust the size and coordinates of the balloon from the previous frame
		h = h + offset;
		w = w + offset;
		//this is done in order for the balloon to always be centered 
		x = dim.height/2 - h/2;
		y = dim.width/2 - w/2;
		
		// set the pen color and draw the background 
		g.setColor(Color.BLACK);             
		g.fillRect(0, 0, dim.width, dim.height);    

		 // set the pen color and draw the balloon
		 g.setColor(Color.GREEN); 
		 g.fillOval(x, y, h, w);
		 
		 //checks if the balloon is shrinking or growing
		 if (h >= dim.height | h<0){
			 offset = -offset;
			 }
		}
	
	public static void main(String[] args) {
	       new Balloon2().run();
	   }

}
