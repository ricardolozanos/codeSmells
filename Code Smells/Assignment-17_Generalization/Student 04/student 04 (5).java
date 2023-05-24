package exercises.Generalization.MultiPlotter;

import exercises.Generalization.Plotter.Function;

public class SineFunction extends Function {
    public double func(double x) {
        return Math.sin(x);
    }
}