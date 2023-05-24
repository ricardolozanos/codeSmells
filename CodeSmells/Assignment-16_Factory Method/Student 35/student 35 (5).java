package balloon;

public class ModularBalloonApp {
	
	protected static Balloon createBalloon() {
		Balloon balloon  = new GrowingBalloon(50,1,new String[] {"width=300", "height=300"});
		return balloon;
	}
	
	public static void main(String[]args) {
		createBalloon().run();
	}

}
