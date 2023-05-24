package noapplet.excercise.plotter;

import java.awt.Color;

import noapplet.example.HelloWorld;

public class Sine implements Function{
	private Color c;
	public Color getColor() {return c;}
	public Sine() {
		this.c = Color.BLACK;
	}
	public Sine(Color c) {
		this.c= c;
	}
	
	@Override
	public double apply(double x) {
		return Math.sin(x);
	}
}
