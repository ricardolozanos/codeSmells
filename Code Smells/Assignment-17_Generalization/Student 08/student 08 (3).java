import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MultiPlotter extends Plotter{
    public List<Function> functions = new ArrayList<>();

    public void initMultiPlotter() {

    }
    public void init() {
        //drawCoordinates();
        for(Function f: functions) {
          //  plotFunction(f);
        }
    }

    public void addFunction(Function f, Color color) {
        functions.add(f);
    }
    protected void plotFunction(Function f, Graphics g) {
        for (var px = 0; px < dim.width; px++) {
            try {
                double x = (double)(px - xorigin) / (double)xratio;
                double y = f.apply(x);
                int py = yorigin - (int) (y * yratio);
                //g.setColor();
                g.fillOval(px - 1, py - 1, 3, 3);
            } catch (Exception ignored) {}
        }
    }
    @Override
    public double func(double x) {
        new Exception("Not Needed");
        return x;
    }

}
