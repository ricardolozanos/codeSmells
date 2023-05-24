public class EnhancedModularBalloonApp {
    public static void main(String[] args) {
        // Create a new Balloon object using createBalloon method
        Balloon balloon = createBalloon();

        // Cast the Balloon object to a GrowingShrinkingBalloon object
        GrowingShrinkingBalloon growingShrinkingBalloon = (GrowingShrinkingBalloon) balloon;
    }

    public static Balloon createBalloon() {
        return new GrowingShrinkingBalloon();
    }
}
