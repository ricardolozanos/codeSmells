package balloon;

public class EnhancedModularBalloonApp extends ModularBalloonApp {
	
	protected static Balloon createBalloon() {
		Balloon balloon  = new GrowingShrinkingBalloon(50,1,new String[] {"width=300", "height=300"});
		return balloon;
	}
	
	public static void main(String[]args) {
		createBalloon().run();
	}

}
