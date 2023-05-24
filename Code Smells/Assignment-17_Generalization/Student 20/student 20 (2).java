import java.awt.*;

public class MultiPlotter extends Plotter{
    @Override
    public void init() {
        xorigin = 0;
        initMultiPlotter();
    }

    public void initMultiPlotter(){
        addFunction(new Function(1,2), Color.blue);
        addFunction(new Function(-1,1),Color.magenta);
        addFunction(new Function(3,3), Color.red);
    }

    @Override
    protected void plotFunction(Graphics g) {
        super.plotFunction(g);
    }

    public void addFunction(Function func, Color color){
        yorigin = (int)func.apply(xorigin);
        color = color;
    }

    @Override
    public double func(double x) {
        return 0;
    }
}
