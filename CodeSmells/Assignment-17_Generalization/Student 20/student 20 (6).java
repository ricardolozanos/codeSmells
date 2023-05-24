import java.awt.Color;
public class SineCosinePlotter extends MultiPlotter{
    public void initMultifunction(){
        addFunction(new Sine(), Color.blue);
        addFunction(new Cosine(),Color.magenta);
        addFunction(new Sqrt(), Color.red);
    }
    public static void main(String[] args){
        new SineCosinePlotter().run();
    }
}
class Sqrt extends Function{
    Sqrt() {
        super(1, 1);
    }

    @Override
    public double apply(double x) {
        return Math.sqrt(x);
    }
}
