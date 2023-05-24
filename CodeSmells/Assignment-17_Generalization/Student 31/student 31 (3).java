package noapplet.example;

import java.awt.*;
import java.util.function.Function;

public class SineCosineMultiPlotter extends MultiPloter {
    public void initMultiPlotter(){
        addFunction(new Sine(), Color.green);
        addFunction(new Cosine(), Color.blue);
        addFunction(x -> x*x*x, Color.BLACK);
    }
    public static void main(String[] args){
        new SineCosineMultiPlotter().run();
    }
}
class Sqrt implements Function {
    public double apply(double x) {
        return x * x;
    }

    @Override
    public Object apply(Object o) {
        return null;
    }
}
