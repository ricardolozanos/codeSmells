import java.awt.*;

public class SineCosinePlotter extends MultiPlotter {
    public void initMultiPlotter() {
        addFunction(new Sine(), Color.GREEN);
        addFunction(new Cosine(), Color.BLUE);
    }

    public static void main(String[] args) {
        new SineCosinePlotter().run();
    }
}
