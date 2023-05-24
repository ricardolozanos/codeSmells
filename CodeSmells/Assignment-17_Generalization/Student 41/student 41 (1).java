package noapplet;

import java.awt.*;
import java.util.function.Function;

public class MultiPlotter extends Plotter{
    protected Function[] functions = new Function[10];
    protected Color[] colors = new Color[10];
    protected int num = 0;

    @Override
    public double func(double x) {
        return 0;
    }
    public void initMultiPlotter() {

    }
    @Override
    public void init() {
        super.init();
        initMultiPlotter();
    }

    protected void addFunction(Function f, Color c){
        if (num < functions.length){
            functions[num] = f;
            colors[num] = c;
            num++;
        }
    }
    @Override
    protected void plotFunction(Graphics g) {
        for(int i = 0; i < num; i++){
            g.setColor(colors[i]);
        for (var px = 0; px < dim.width; px++) {
            try {
                double x = (double)(px - xorigin) / (double)xratio;
                double y = (double)functions[i].apply(x);
                int py = yorigin - (int) (y * yratio);
                g.fillOval(px - 1, py - 1, 3, 3);
            } catch (Exception ignored) {}
        }
        }
    }

    public static void main(String[] args){
        MultiPlotter multi = new MultiPlotter();
        multi.addFunction(x -> Math.pow((double)x,2), Color.RED);
        multi.addFunction(x -> Math.log((double)x), Color.GREEN);
        multi.addFunction(x -> x, Color.BLUE);
        multi.run();
    }
}
