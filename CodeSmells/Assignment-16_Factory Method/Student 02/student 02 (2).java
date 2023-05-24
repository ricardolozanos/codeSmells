package noapplet.BalloonFactoryHW;

public class EnhancedModularBalloonApp {
    public Balloon createBalloon() {
        return new GrowingShrinkingBalloon();
    }
}
