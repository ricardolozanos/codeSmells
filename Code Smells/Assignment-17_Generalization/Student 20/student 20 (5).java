public class Sine extends Function {

    Sine() {
        super(1, 1);
    }

    @Override
    public double apply(double x) {
        return Math.sin(x);
    }
}
