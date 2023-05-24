package noapplet.example;

import java.awt.*;

public abstract class MultiPlotter extends Plotter{
    private Object f;
    private Color c;

    public void addFunction(Object f, Color c){
        this.f = f;
        this.c = c;
    }

    public void initMultiPlotter(){
        //Hook method for subclasses to set up functions to be plotted
    }

    public void init(){
        //Template method for initialization which calls initMultiPlotter()
        initMultiPlotter();
    }

    public void plotFunction(){
        plotFunction();
    }

    public void func() throws Exception{
        throw new Exception("Isn't useful");
    }
}
