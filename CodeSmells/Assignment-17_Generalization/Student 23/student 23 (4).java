import java.awt.*;
import java.util.*;

public class MultiPlotter extends Plotter {
    private HashMap<Function,Color> func_map;

    public MultiPlotter(String[] args) {
        super(args);
    }

    public MultiPlotter() {
        super();
    }

    public void initMultiPlotter() {}

    public void addFunction(Function func, Color color) {
        func_map.put(func, color);
    }

    public void init() {
        func_map = new HashMap<>();
        initMultiPlotter();

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

    public void plotFunction(Graphics g) {
        for(var entry : func_map.entrySet()) {
            g.setColor(entry.getValue());
            for (var px = 0; px < dim.width; px++) {
                try {
                    double x = (double) (px - xorigin) / (double) xratio;
                    double y = entry.getKey().apply(x);
                    int py = yorigin - (int) (y * yratio);
                    g.fillOval(px - 1, py - 1, 3, 3);
                } catch (Exception ignored) {
                }
            }
        }
    }

    public double func(double x) {
        return 0;
    }

}
