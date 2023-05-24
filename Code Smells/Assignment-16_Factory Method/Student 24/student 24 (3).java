package noapplet.example;

public class GrowingShrinkingBalloon extends Balloon2{
    public GrowingShrinkingBalloon(String[] args) {
        super(args);
        new Balloon2(args).run();
    }
}
