package exercises.Generalization.MultiPlotter;

import java.util.ArrayList;

import exercises.Generalization.Plotter.Plotter;
import exercises.Generalization.Plotter.Function;

import java.awt.Graphics;

public class MultiPlotter extends Plotter {
    private ArrayList<Function> functions;
    private int numFunctions;
    private int[] colors;
    
    public MultiPlotter() {
        functions = new ArrayList<>();
        numFunctions = 0;
        colors = new int[] {0xFF0000, 0x00FF00, 0x0000FF, 0xFFFF00, 0xFF00FF, 0x00FFFF};
    }
    
    public void initMultiPlotter() {
        init();
    }
    
    public void addFunction(Function f) {
        if (numFunctions < colors.length) {
            f.setColor(colors[numFunctions]);
        }
        functions.add(f);
        numFunctions++;
    }
    
    public void plotFunction(Graphics g) {
        for (Function f : functions) {
            g.setColor(f.getColor());
            for (var px = 0; px < dim.width; px++) {
                try {
                    double x = (double)(px - xorigin) / (double)xratio; 
                    double y = f.func(x); 
                    int py = yorigin - (int) (y * yratio); 
                    g.fillOval(px - 1, py - 1, 3, 3); 
                } catch (Exception ignored) {} 
            }
        }
    }
    
    public double func(double x) {
        return 0;
    }
}
