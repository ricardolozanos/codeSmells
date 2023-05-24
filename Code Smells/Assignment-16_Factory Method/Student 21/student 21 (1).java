package noapplet.example;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class EnhancedModularBalloonApp extends ModularBalloonApp{
	protected boolean flag = true;
	
	public EnhancedModularBalloonApp(String[] params) {
		super(params);
	}
	
	protected ModularBalloonApp createBalloon() {
		return this;
	}
	
	public void paintComponent(Graphics g) {
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

	public static void main(String[] args) {
		new EnhancedModularBalloonApp(new String[] {"width=500", "height=250"}).run();
	}
}
