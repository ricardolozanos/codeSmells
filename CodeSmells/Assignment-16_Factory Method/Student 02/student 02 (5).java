package noapplet.BalloonFactoryHW;

import noapplet.NoApplet;

public class Main extends NoApplet{

    public static void main(String[] args){
        ModularBalloonApp balloonFactory = new ModularBalloonApp();
        EnhancedModularBalloonApp enhancedBalloonFactory = new EnhancedModularBalloonApp();
        Balloon growingBalloon = balloonFactory.createBalloon();
        Balloon growingShrinkingBalloon = enhancedBalloonFactory.createBalloon();
        growingBalloon.run();
        growingShrinkingBalloon.run();
    }
}
