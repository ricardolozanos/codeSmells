package noapplet.excercise.plotter;

import java.awt.Color;

public class Cosine implements Function{
	private Color c;
	public Color getColor() {return c;}
	public Cosine() {
		this.c = Color.BLACK;
	}
	public Cosine(Color c) {
		this.c= c;
	}
	@Override
	public double apply(double x) {
		return Math.cos(x);
	}
}
