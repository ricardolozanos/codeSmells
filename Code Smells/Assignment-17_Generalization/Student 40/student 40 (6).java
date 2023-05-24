package src.noapplet.example;

import java.awt.*;

public class SineCosineMultiPlotter extends MultiPlotter{
    public void initMultiPlotter(){
        addFunction(new Sine(), Color.green);
        addFunction(new Cosine(), Color.blue);
        addFunction(new Sqrt(), Color.RED);

    }
    public static void main(String [] args){
        new SineCosineMultiPlotter().run();
    }
}

class Sqrt implements Function{
    public double apply(double x){
        return Math.sqrt(x);
    }
}