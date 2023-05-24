package balloon;
/**
 *
 */

public class ModularBalloonApp implements Balloon<GrowingBalloon>{
    protected GrowingBalloon growBall;
    /**
     *
     */
    public ModularBalloonApp(){
        growBall = new GrowingBalloon();
        setGrowBall(growBall);
    }
    /**
     * @return a new GrowingBalloon.
     */

    @Override
    public GrowingBalloon createBalloon(){
        return growBall;
    }
    /**
     *
     * @param newGrowBall sets growBall to be a new growBall that will grow.
     *
     */
    public void setGrowBall(GrowingBalloon newGrowBall){
        growBall = newGrowBall;
    }
    /**
     *
     * @param args standard parameter for main.
     */

    public static void main(String[] args){
        new ModularBalloonApp().createBalloon().run();
    }
}
