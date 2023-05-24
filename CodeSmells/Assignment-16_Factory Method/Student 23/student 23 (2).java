package noapplet.Balloon;

public class EnhancedModularBalloonApp {
    public static void main(String[] args) {
        new GrowingShrinkingBalloon(new String[] {"width=500", "height=500"}).run();
    }
}
