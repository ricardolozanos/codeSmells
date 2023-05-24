package Misc.Plotter;

import noapplet.NoApplet;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;

public abstract class Plotter extends NoApplet {
    /** Dimension of the screen. */
    protected Dimension dim;

    /** Plotting color. */
    protected Color color = Color.black;

    /** Position of the origin. */
    protected int xorigin, yorigin;

    /** Number of pixels between 0 and 1 in x and y axles. */
    protected int xratio = 100, yratio = 100;

    public Plotter(String[] args) {
        super(args);
    }

    public Plotter() {
        super();
    }

    public abstract double func(double x);

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

    protected void paintComponent(Graphics g) {
        drawCoordinates(g);
        plotFunction(g);
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

    protected void drawCoordinates(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, dim.width, dim.height);

        g.setColor(color);
        g.drawLine(0, yorigin, dim.width, yorigin);
        g.drawLine(xorigin, 0, xorigin, dim.height);

        g.setFont(new Font("TimeRoman", Font.PLAIN, 10));
        int px, py;
        int i = 1;
        py = yorigin + 12;
        g.drawString("0", xorigin + 2, py);
        for (px = xorigin + xratio; px < dim.width; px += xratio) {
            g.drawString(Integer.toString(i++), px - 2, py);
            g.drawLine(px, yorigin - 2, px, yorigin + 2);
        }

        i = -1;
        for (px = xorigin - xratio; px >= 0; px -= xratio) {
            g.drawString(Integer.toString(i--), px - 2, py);
            g.drawLine(px, yorigin - 2, px, yorigin + 2);
        }

        i = 1;
        px = xorigin + 4;
        for (py = yorigin - yratio; py >= 0; py -= yratio) {
            g.drawString(Integer.toString(i++), px, py + 4);
            g.drawLine(xorigin - 2, py, xorigin + 2, py);
        }

        i = -1;
        for (py = yorigin + yratio; py < dim.height; py += yratio) {
            g.drawString(Integer.toString(i--), px, py + 4);
            g.drawLine(xorigin - 2, py, xorigin + 2, py);
        }
    }
}

interface Function {
    public double apply(double x);
    public Color getColor();
}

abstract class MultiPlotter extends Plotter {
    ArrayList<Function> arr;

    public MultiPlotter() {
        super();
        arr = new ArrayList<Function>();
    }
    public MultiPlotter(String[] str) {
        super(str);
        arr = new ArrayList<Function>();
    }

    protected void plotFunction(Graphics g, Function i) {
        g.setColor(i.getColor());
        for(var px = 0; px < dim.width; px++) {
            try {
                double x = (double)(px - xorigin) / (double)xratio;
                double y = i.apply(x);
                int py = yorigin - (int) (y*yratio);
                g.fillOval(px-1, py-1,3,3);
            } catch (Exception ignored) {}
        }
    }

    public void addFunction(Function x){
        arr.add(x);
    }

    @Override
    public void paintComponent(Graphics g) {
        drawCoordinates(g);
        for(var i:arr) {
            plotFunction(g,i);
        }
    }
}

class Cosine implements Function {
    private Color c;
    public Color getColor() {
        return c;
    }
    public Cosine() {
        this.c = Color.BLACK; // defaults
    }
    public Cosine(Color c) {
        this.c = c;
    }
    @Override
    public double apply(double x) {
        return Math.cos(x);
    }
}

class Sine implements Function {
    private Color c;
    public Color getColor() {
        return c;
    }
    public Sine() {
        this.c = Color.BLACK; // defaults
    }
    public Sine(Color c) {
        this.c = c;
    }
    @Override
    public double apply(double x) {
        return Math.sin(x);
    }
}

class Sqrt implements Function {
    private Color c;
    public Color getColor() {
        return c;
    }
    public Sqrt() {
        this.c = Color.BLACK; // defaults
    }
    public Sqrt(Color c) {
        this.c = c;
    }
    @Override
    public double apply(double x) {
        return x*x;
    }
}


// Main class to run it all together
class SineCosineMultiPlotter extends MultiPlotter{
    public SineCosineMultiPlotter(String[] params) {
        super(params);
        addFunction(new Sine(Color.green));
        addFunction(new Cosine(Color.red));
        addFunction(new Sqrt(Color.blue));
    }

    public static void main(String[] args) {
        new SineCosineMultiPlotter(new String[] {"width=330", "height=350"}).run();
    }
    @Override
    public double func(double x) {
        return 123;
    }

}