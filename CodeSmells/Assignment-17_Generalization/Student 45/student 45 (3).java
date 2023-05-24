package plotter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MultiPlotter extends Plotter{
    protected List<Function> functionList;
    protected Function function;
    protected List<Color> funcColor;

    protected int i;
    public MultiPlotter(){
        this.functionList = new ArrayList<>();
        this.funcColor = new ArrayList<>();

    }
    public MultiPlotter(String[] params){
        super(params);
    }
    protected void initMultiPlotter(){
        //For Client use.
    }
    @Override
    public void init(){
        super.init();
        initMultiPlotter();
    }
    protected void addFunction(Function fun, Color col){
        functionList.add(fun);
        funcColor.add(col);
    }
    @Override
    protected void plotFunction(Graphics g) {
        for(i=0; i<functionList.size();i++){
            g.setColor(funcColor.get(i));
            function = functionList.get(i);
            super.plotFunction(g);
        }
    }

// x -> x*x*x   lambda notation
    @Override
    public double func(double x) {
        return function.apply(x);
    }
}

