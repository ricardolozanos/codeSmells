package exercises.FactoryMethod;

public class EnhancedModularBalloonApp {
    public static void main(String[] args) {
        Balloon balloon = BalloonFactory.createEnhancedModularBalloon();
        balloon.run();
    }
}

