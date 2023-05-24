package exercises.FactoryMethod;

public class ModularBalloonApp {
    public static void main(String[] args) {
        Balloon balloon = BalloonFactory.createModularBalloon();
        balloon.run();
    }
}
