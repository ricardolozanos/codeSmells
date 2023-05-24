public class Function{
    protected double exponent;
    protected double coefficient;
    Function(double coefficient, double exponent){
        this.coefficient = coefficient;
        this.exponent = exponent;
    }
    public double apply(double x){
        return coefficient*Math.pow(x,exponent);
    }
}
