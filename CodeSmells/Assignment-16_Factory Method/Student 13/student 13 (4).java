package noapplet.balloon;

public class EnhancedModularBalloonApp extends ModularBalloonApp {
    @Override
    public Balloon createBalloon(){
        return new GrowingShrinkingBalloon();
    }
}
