package bouncing_Ball;

import java.awt.Color;
import java.awt.Graphics;

public class EnhancedModularBalloonApp extends noapplet.AnimationNoApplet{
	private GrowingShrinkingBalloon balloon;
	
	private EnhancedModularBalloonApp() {
		
	}
	
	protected EnhancedModularBalloonApp(String[] args) {
    	super(args);
    }
	
	protected void initAnimation() {
        setBackground(Color.WHITE);
        balloon = new GrowingShrinkingBalloon(20, 5, dim.width, dim.height);
    }
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		balloon.draw(g);
	}
	
	public static void main(String[] args) {
        new EnhancedModularBalloonApp().run();
    }

}
