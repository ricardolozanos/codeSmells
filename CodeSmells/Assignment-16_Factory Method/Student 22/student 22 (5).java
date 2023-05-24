public class ModularBalloonApp {
    public static void main(String[] args) {
        // Create a new Balloon object using createBalloon method
        Balloon balloon = createBalloon();

        // Cast the Balloon object to a GrowingBalloon object
        GrowingBalloon growingBalloon = (GrowingBalloon) balloon;
    }

    public static Balloon createBalloon() {
        return new GrowingBalloon();
    }
}
