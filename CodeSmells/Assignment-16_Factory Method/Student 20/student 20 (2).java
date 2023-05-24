public class EnhancedModularBalloonApp extends ModularBalloonApp{
    private Balloon growingShrinkingBalloon;
    EnhancedModularBalloonApp(){
        createBalloon();
    }
    public Balloon createBalloon(){
        growingShrinkingBalloon = new GrowingShrinkingBalloon();
        return growingShrinkingBalloon;
    }
    public Balloon getBalloon(){
        return  growingShrinkingBalloon;
    }
}
