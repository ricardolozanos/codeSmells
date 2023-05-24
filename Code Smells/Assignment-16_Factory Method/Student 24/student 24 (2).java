package noapplet.example;

public class GrowingBalloon extends Balloon{
   public GrowingBalloon(String[] args){
       super(args);
       new Balloon(args).run();
   }
}
