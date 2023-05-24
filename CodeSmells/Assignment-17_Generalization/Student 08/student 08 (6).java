import java.awt.*;

public class SineCosinePlotter extends MultiPlotter{
    public void initMultiPlotter() {
        addFunction(new Sine(), Color.green);
        addFunction(new Cosine(), Color.blue);
    }

    public static void main(String[] args) {
        new SineCosinePlotter().run();
    }

}
