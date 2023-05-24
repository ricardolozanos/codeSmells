package noapplet.example;

import java.awt.*;

public class MultiPlotter extends Plotter {
    protected Dimension dim;

    /** Plotting color. */
    protected Color color = Color.black;

    /** Position of the origin. */
    protected int xorigin, yorigin;

    /** Number of pixels between 0 and 1 in x and y axles. */
    protected int xratio = 100, yratio = 100;

    @Override
    protected void painComponent(Graphics g) {

    }

    @Override
    public double func(double x) {
        return Math.sin(x);
    }

    @Override
    public double func1(double X) {
        return Math.cos(X);
    }

    @Override
    public double func2(double equis){
        double rad = Math.toRadians(equis);
        return Math.cos(rad);
    }
    @Override
    public double funC(double x) {
        return x;
    }
}

