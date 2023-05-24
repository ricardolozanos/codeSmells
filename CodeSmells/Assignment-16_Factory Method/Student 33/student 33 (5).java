package noapplet.example.Balloon;

public class ModularBalloonApp {
    BalloonInterface balloon;

    public ModularBalloonApp() {
        this.balloon = new GrowingBalloon();
    }
    void createBall() {
        this.balloon.runnable();
    }

    public static void main(String[] args) {
        ModularBalloonApp temporary = new ModularBalloonApp();
        temporary.createBall();
    }
}
