public class Cosine extends Function{

    Cosine() {
        super(1, 1);
    }

    @Override
    public double apply(double x) {
        return Math.cos(x);
    }
}
