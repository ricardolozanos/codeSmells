package noapplet;

public class SineCosine extends Multiplotter{
    public void initMultiplotter(){
        addFunction(x -> Math.sin(x));
        addFunction(x -> Math.cos(x));
    }
    public static void main(String[] args){
        SineCosine x = new SineCosine();
        x.run();
    }
}
