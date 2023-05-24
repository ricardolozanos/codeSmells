package noapplet.example;

public class ModularBalloonApp {
    public ModularBalloonApp(String[] args) {
        new GrowingBalloon(args);
    }

    public static void main(String[] args){ new ModularBalloonApp(args);}
}
