import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JApplet;
public abstract class MultiPlotter extends Plotter {

    protected ArrayList<FunctionData> functionDataList;

    public MultiPlotter() {
        functionDataList = new ArrayList<>();
    }

    public void addFunction(FunctionData functionData) {
        functionDataList.add(functionData);
    }

    protected void plotFunction(Graphics g, FunctionData functionData) {
        for (var px = 0; px < dim.width; px++) {
            try {
                double x = (double)(px - xorigin) / (double)xratio;
                double y = functionData.getFunction().func(x);
                int py = yorigin - (int) (y * yratio);
                g.setColor(functionData.getColor());
                g.fillOval(px - 1, py - 1, 3, 3);
            } catch (Exception ignored) {}
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        drawCoordinates(g);
        for (FunctionData functionData : functionDataList) {
            plotFunction(g, functionData);
        }
    }

    public static class FunctionData {

        private Function function;
        private Color color;

        public FunctionData(Function function, Color color) {
            this.function = function;
            this.color = color;
        }

        public Function getFunction() {
            return function;
        }

        public Color getColor() {
            return color;
        }
    }
}

