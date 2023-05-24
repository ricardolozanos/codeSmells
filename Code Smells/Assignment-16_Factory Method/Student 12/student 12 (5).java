public class ModularBalloonApp {
    public ModularBalloonApp(){}
    public Balloon createBalloon(){
        Balloon balloon = new GrowingBallon();
        balloon.createBalloon(new String[] {"width=400", "height=400"}).run();
        return balloon;
    }
}
