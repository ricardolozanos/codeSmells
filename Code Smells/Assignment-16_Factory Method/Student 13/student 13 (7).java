package noapplet.balloon;

public class ModularBalloonApp {
    public void run(){
        Balloon balloon = createBalloon();
        System.out.println(balloon.getClass());
        balloon.run();
    }
    public Balloon createBalloon(){
        return new GrowingBalloon();
    }
}
