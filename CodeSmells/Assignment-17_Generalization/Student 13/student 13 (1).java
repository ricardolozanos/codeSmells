package noapplet;

import java.awt.*;

public abstract class Multiplotter extends Plotter{
    Function[] functions = new Function[0];
    public void initMultiplotter(){
    }
    @Override
    public void init(){
        initMultiplotter();
        super.init();
    }
    public void plotFunction(Graphics g){
        for (int i = 0; i < functions.length; i ++){
            for (var px = 0; px < super.dim.width; px++) {
                try {
                    double x = (double)(px - super.xorigin) / (double)super.xratio;
                    double y = functions[i].apply(x);
                    int py = super.yorigin - (int) (y * super.yratio);
                    g.fillOval(px - 1, py - 1, 3, 3);
                } catch (Exception ignored) {}
            }
        }
    }
    public void addFunction(Function func){
        Function[] newFunctions = new Function[functions.length + 1];
        for (int i = 0; i < functions.length; i++){
            newFunctions[i] = functions[i];
        }
        newFunctions[newFunctions.length-1] = func;
        functions = newFunctions;
    }
    @Override
    public double func(double x){
        throw new RuntimeException();
    }
}
