package src.noapplet.example;

import java.awt.*;
import java.util.ArrayList;

public class MultiPlotter extends Plotter {
    private ArrayList<Function> functions;
    private ArrayList<Color> colors;

    public MultiPlotter(){
        super();
        functions = new ArrayList<>();
        colors = new ArrayList<>();
        initMultiPlotter();
    }

    public void initMultiPlotter() {

        functions = new ArrayList<>();
        colors = new ArrayList<>();

    }

    public void addFunction(Function function, Color color) {
        functions.add(function);
        colors.add(color);
    }

    @Override
    public void init() {
        initMultiPlotter();
    }

    @Override
    public double func(double x) {
       return 0;
    }
}