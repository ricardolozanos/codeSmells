import java.awt.*;

public class sinecosine public class SineCosinePlotter extends MultiPlotter {

    public SineCosinePlotter() {
        super();

        FunctionData sineData = new FunctionData(new SineFunction(), Color.blue);
        FunctionData cosineData = new FunctionData(new CosineFunction(), Color.red);

        addFunction(sineData);
        addFunction(cosineData);
    }

    @Override
    public double func(double x) {
        return 0; // This method is not used by SineCosinePlotter
    }

    private static class SineFunction implements Function {

        @Override
        public double func(double x) {
            return Math.sin(x);
        }
    }

    private static class CosineFunction implements Function {

        @Override
        public double func(double x) {
            return Math.cos(x);
        }
    }
}

