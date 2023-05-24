package balloon;
/**
 *
 */
public class EnhModularBalloonApp extends ModularBalloonApp{
    protected GrowingShrinkingBalloon balloon;
    /**
     *
     */
    public EnhModularBalloonApp(){
        balloon = new GrowingShrinkingBalloon();
        setBall(balloon);
    }
    @Override
    public GrowingShrinkingBalloon createBalloon(){
        return balloon;
    }
    /**
     * @param newBalloon sets newBalloon to be a new balloon that will grow and shrink.
     */
    public void setBall(GrowingShrinkingBalloon newBalloon){
        balloon = newBalloon;
    }
    /**
     *@param args standard parameter for main.
     */
    public static void main(String[] args){
        new EnhModularBalloonApp().createBalloon().run();
    }
}
