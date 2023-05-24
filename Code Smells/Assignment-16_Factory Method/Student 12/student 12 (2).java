public class EnhancedModularBalloonApp extends ModularBalloonApp{
    public EnhancedModularBalloonApp(){}
    @Override
    public Balloon createBalloon(){
        Balloon balloon = new GrowingShrinkingBalloon();
        balloon.createBalloon(new String[] {"width=400", "height=400"}).run();
        return balloon;
    }
    
    
}
