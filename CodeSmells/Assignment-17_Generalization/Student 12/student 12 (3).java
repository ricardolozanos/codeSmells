import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Graphics;

public class MultiPlotter extends Plotter{
    List<Function> functions = new ArrayList<Function>();
    List<Color> colors = new ArrayList<Color>();

    public void initMultiPlotter(){}
    public void addFunction(Function func, Color color){
        functions.add(func);
        colors.add(color);
    }
    @Override
    public void plotFunction(Graphics g){
        int i = 0;
        for(Function func: functions){
            g.setColor(colors.get(i));
            for (var px = 0; px < dim.width; px++) {
                try {
                    double x = (double)(px - xorigin) / (double)xratio; 
                    double y = func.apply(x); 

                    int py = yorigin - (int) (y * yratio); 
                    g.fillOval(px - 1, py - 1, 3, 3); 
                } catch (Exception ignored) {} 
            }
            i++;
        }

    }
    @Override
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
        initMultiPlotter();
    }
    @Override
    public double func(double x) {
        throw new UnsupportedOperationException("Unimplemented method 'func'");
    }
}
