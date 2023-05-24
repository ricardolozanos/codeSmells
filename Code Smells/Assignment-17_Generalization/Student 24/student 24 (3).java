package noapplet.example;

import java.awt.*;
import java.util.function.Function;

public class SineCosineMultiPlotter extends MultiPlotter {

    public void initMultiPlotter(){
        addFunction(new Sine(), Color.GREEN);
        addFunction(new Cosine(), Color.blue);
        addFunction(new Sqrt(), Color.RED);
    }

    public void SineCosineMultiPlotter(){
        initMultiPlotter();
        plotFunction();
    }

    public static void main(String[] args){
        new SineCosineMultiPlotter().run();
    }

    @Override
    public double func(double x) {
        return 0;
    }
}
class Sine implements Function{

    @Override
    public Object apply(Object o) {
        return null;
    }
    public double apply(double x){
        return Math.sin(x);
    }
}
class Cosine implements Function{

    @Override
    public Object apply(Object o) {
        return null;
    }
    public double apply(double x){
        return Math.cos(x);
    }
}
class Sqrt implements Function {
    public double apply(double x){
        return Math.sqrt(x);
    }

    @Override
    public Object apply(Object o) {
        return null;
    }
}