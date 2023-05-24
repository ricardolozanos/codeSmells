package noapplet.example;

public class ModularBalloonApp extends noapplet.NoApplet{
	
	
	public static void main(String[] args) {
		GrowingBalloon grow = new GrowingBalloon();
		GrowingShrinkingBalloon growShrink = new GrowingShrinkingBalloon();
		grow.run();
		growShrink.run();
	   }
	
}
