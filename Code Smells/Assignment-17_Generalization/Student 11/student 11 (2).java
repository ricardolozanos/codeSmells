import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MultiPlotter extends Plotter{
    List<Function> functions;
    Color [] gColors = {Color.BLACK,Color.RED,Color.BLUE,Color.CYAN,Color.GREEN};
    public MultiPlotter(String [] args){
        super(args);
        initMultiPlotter();
    }
    public MultiPlotter(){
        super();
        initMultiPlotter();
    }
    protected void addFunction(Function f){
        functions.add(f);
    }
    protected void initMultiPlotter(){
        functions = new ArrayList<>();
    }
    @Override
    public void plotFunction(Graphics g) {
        int colorCount = 0;
        for(Function f : functions) {
            g.setColor(gColors[colorCount++]);
            colorCount = colorCount<gColors.length?colorCount:0;
            for (var px = 0; px < super.dim.width; px++) {
                try {
                    double x = (double) (px - super.xorigin) / (double) super.xratio;
                    double y = f.apply(x);
                    int py = super.yorigin - (int) (y * super.yratio);
                    g.fillOval(px - 1, py - 1, 3, 3);
                } catch (Exception ignored) {
                }
            }
        }
    }
    @Deprecated
    public double func(double x){
        try {
            throw new IllegalAccessException("Function cannot be used in MultiPlotter");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
