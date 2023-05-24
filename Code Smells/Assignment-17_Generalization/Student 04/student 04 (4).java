package exercises.Generalization.MultiPlotter;



public class SineCosinePlotter extends MultiPlotter {
    public SineCosinePlotter() {
        super();
        addFunction(new SineFunction());
        addFunction(new CosineFunction());
        addFunction(new SqrtFunction());
    }

    public static void main(String[] args) {
        SineCosinePlotter plotter = new SineCosinePlotter();
        plotter.run();
    }
}
