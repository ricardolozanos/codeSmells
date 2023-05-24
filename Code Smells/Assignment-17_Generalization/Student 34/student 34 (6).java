package excs.plotterEX;

import java.awt.*;
import java.util.function.Function;

public class SineCosineMultiPlotter extends MultiPlotter{
    @Override
    public double func(double x) {
        return 0;
    }
    public void initMultiPlotter(){
        addFunction(new sine(), Color.green);
        addFunction(new cosine(), Color.RED);


    }

    public static void main(String[] args){
        new SineCosineMultiPlotter().run();
    }
}

