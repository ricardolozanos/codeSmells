package noapplet.example;

public class ModularBalloonApp {
	
	BalloonsFactory balloon;
	
	public ModularBalloonApp() {
		this.balloon = new GrowingBalloon();
	}
	protected void createBalloon() {
		this.balloon.runthis();
	}
	
	public static void main(String[] args) {
		ModularBalloonApp temp = new ModularBalloonApp();
		temp.createBalloon();
	}
}
