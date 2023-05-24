package noapplet.excercise.plotter;

import java.awt.Color;
import java.awt.Graphics;

import noapplet.example.HelloWorld;

public class SineCosineMultiPlotter extends MultiPlotter{

	public SineCosineMultiPlotter() {
		super();
		addFunction(new Sine(Color.green));
		addFunction(new Cosine(Color.red));
		addFunction(new Sqrt(Color.blue));
	}
	public SineCosineMultiPlotter(String[] params) {
		super(params);
		addFunction(new Sine(Color.green));
		addFunction(new Cosine(Color.red));
		addFunction(new Sqrt(Color.blue));
	}
		
	class Sqrt implements Function{
		private Color c;
		public Color getColor() {return c;}
		public Sqrt() {
			this.c = Color.BLACK;
		}
		public Sqrt(Color c) {
			this.c= c;
		}
		@Override
		public double apply(double x) {
			return x * x;
		}
	}
	public static void main(String[] args) {
		new SineCosineMultiPlotter(new String[] {"width=330", "height=350"}).run();
	}
	@Override
	public double func(double x) {
		return 0;
	}
	
}
