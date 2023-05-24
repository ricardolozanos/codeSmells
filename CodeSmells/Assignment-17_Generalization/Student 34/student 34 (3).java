package excs.plotterEX;

import java.awt.*;
import java.util.ArrayList;

public class MultiPlotter extends Plotter{
    ArrayList<Function> funcList = new ArrayList<Function>();
    ArrayList<Color> colorList = new ArrayList<Color>();

    public void addFunction(Function f ,Color c){
        funcList.add(f);
        colorList.add(c);
    }
    public void plotFunction(Graphics g){
        for (var px = 0; px < dim.width; px++) {
            try {
                double x = (double)(px - xorigin) / (double)xratio;
                double y = func(x);
                int py = yorigin - (int) (y * yratio);
                g.fillOval(px - 1, py - 1, 3, 3);
            } catch (Exception ignored) {}
        }
    }

    @Override
    public double func(double x) {
        return 0;
    }
}
