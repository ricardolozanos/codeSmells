package plotter;

import java.awt.*;

public class SinCosinePlotter extends MultiPlotter{
    @Override
    protected void initMultiPlotter(){
        addFunction(new Cosine(), Color.BLUE);
        addFunction(new Sine(), Color.GREEN);
        addFunction(x-> x*x,Color.RED);
    }
    public static void main(String[] args){
        new SinCosinePlotter().run();
    }
}
