package exercises.FactoryMethod;

public class BalloonFactory{
    public static Balloon createModularBalloon(){
        return new Balloon(new String[] {"width=350", "height=350"});
    }

    public static Balloon createEnhancedModularBalloon() {
        return new Balloon2(new String[] {"width=350", "height=350"});
    }
}

