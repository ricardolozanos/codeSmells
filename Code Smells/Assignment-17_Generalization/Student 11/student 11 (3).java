import java.util.ArrayList;

public class SineCosinePlotter extends MultiPlotter{
    public void initMultiPlotter(){
        super.initMultiPlotter();
        addFunction(Math::sin); // sine
        addFunction(Math::cos); // cosine
    }
    public static void main(String ... args){
        SineCosinePlotter plotter = new SineCosinePlotter();
        plotter.run();
    }
}
