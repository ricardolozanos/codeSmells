package noapplet.example;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
@SuppressWarnings("serial")
public class Balloon extends noapplet.NoApplet {

	protected Timer timer;
	protected int delay=100;
	protected Dimension dim; 
	protected int offset = 2;
	protected int x, y,h,w; 
	
	public void init() {
		  // get parameters "delay"  
		  String att = getParameter("delay");
		  if (att != null) {
		    delay = Integer.parseInt(att);
		  }

		  // set the initial position and dimensions of the balloon 
		  dim = getSize();
		  //balloon coordinates will be centered
		  x = dim.height/2;
		  y = dim.width/2;
		  //width and height of balloon
		  h = 0;
		  w = 0;

		  // initialize the animation timer
		  timer = new Timer(delay, event -> repaint());

			   }
	
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
		}
	
	public void start() {
		 timer.start();
		}
		  
	public void stop() {
		 timer.stop(); 
		}
	
	public static void main(String[] args) {
       new Balloon().run();
   }
}
