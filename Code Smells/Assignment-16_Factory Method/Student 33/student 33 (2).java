package noapplet.example.Balloon;

public class EnhancedModularBalloonApp extends ModularBalloonApp{
    public EnhancedModularBalloonApp(){
        this.balloon = new GrowingShrinkingBalloon();
    }

    public static void main(String[] args) {
        EnhancedModularBalloonApp temp = new EnhancedModularBalloonApp();
        temp.createBall();
    }
}
