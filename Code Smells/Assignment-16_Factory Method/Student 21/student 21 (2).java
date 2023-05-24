package noapplet.example;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.Timer;
import noapplet.NoApplet;

public class ModularBalloonApp extends NoApplet{
	
	protected Timer t;
	protected int x, y;
	protected int d = 1;
	protected int grow = 1;
	
	public ModularBalloonApp(String[] params) {
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
	
	protected ModularBalloonApp createBalloon() {
		return this;
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
	
	public static void main(String[] args) {
		new ModularBalloonApp(new String[] {"width=500", "height=250"}).run();
	}
}
