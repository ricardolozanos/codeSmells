package noapplet.example;

import java.awt.*;

public class MultiPloter extends Plotter{
    public void initMultiPlotter(){
        addFunction(new Sine(), Color.green);
        addFunction(new Cosine(), Color.blue);
        addFunction(x -> x*x*x, Color.BLACK);
    }

    private void addFunction(Object o, Color black) {
    }

    private void addFunction(Cosine cosine, Color blue) {
    }

    private void addFunction(Sine sine, Color green) {
    }

    public void init() {
        dim = getSize();
        String att = getParameter("xratio");
        if (att != null)
            xratio = Integer.parseInt(att);
        att = getParameter("yratio");
        if (att != null)
            yratio = Integer.parseInt(att);
        att = getParameter("xorigin");
        if (att != null)
            xorigin = Integer.parseInt(att);
        else
            xorigin = dim.width / 2;
        att = getParameter("yorigin");
        if (att != null)
            yorigin = Integer.parseInt(att);
        else
            yorigin = dim.height / 2;
    }
    public static void addFunction(){

    }
    protected void plotFunction(Graphics g) {
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

    private class Sine {
    }
    private class Cosine {
    }
}
