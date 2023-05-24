package bouncing_Ball;

import java.awt.Color;
import java.awt.Graphics;

public class ModularBalloonApp extends noapplet.AnimationNoApplet{	
	private GrowingBalloon balloon;
	
	private ModularBalloonApp() {
		
	}
	
	protected ModularBalloonApp(String[] args) {
    	super(args);
    }
	
	protected void initAnimation() {
        setBackground(Color.WHITE);
        balloon = new GrowingBalloon(20, 5, dim.width, dim.height);
    }
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		balloon.draw(g);
	}
	
	public static void main(String[] args) {
        new ModularBalloonApp().run();
    }
}
