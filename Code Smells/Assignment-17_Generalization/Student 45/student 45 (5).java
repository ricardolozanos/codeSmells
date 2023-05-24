package plotter;

import static java.lang.Math.*;

public class Sine implements Function{
    @Override
    public double apply(double x) {
        return sin(x);
    }
}
