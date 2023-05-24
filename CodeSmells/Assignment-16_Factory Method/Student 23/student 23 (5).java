package noapplet.Balloon;

public class ModularBalloonApp {
    public static void main(String[] args) {
        new GrowingBalloon(new String[] {"width=500", "height=500"}).run();
    }
}
