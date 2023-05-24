package noapplet.example;

public class EnhancedModularBalloonApp extends ModularBalloonApp{
	
	public EnhancedModularBalloonApp() {
		this.balloon = new ShrinkingBalloon();
	}
	public static void main(String[] args) {
		EnhancedModularBalloonApp temp = new EnhancedModularBalloonApp();
		temp.createBalloon();
	}
}
