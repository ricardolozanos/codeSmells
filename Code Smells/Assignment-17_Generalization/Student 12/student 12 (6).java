import java.awt.Color;
public class SineCosineMultiPlotter extends MultiPlotter {
    public void initMultiPlotter(){
        addFunction(new Sine(), Color.GREEN);
        addFunction(new Cosine(), Color.RED);
        addFunction( x -> x * x, Color.YELLOW);

    }
    public static void main(String[] args){
        new SineCosineMultiPlotter().run();
    }

    
}
