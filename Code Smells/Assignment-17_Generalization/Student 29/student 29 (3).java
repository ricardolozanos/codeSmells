package plotter;

import java.awt.Color;

@SuppressWarnings("serial")
public class SineCosineMultiPlotter extends MultiPlotter {

	@Override
	public void initMultiPlotter() {
		addFunction(new Sine() , Color.GREEN);
		addFunction(new Cosine() , Color.BLUE);
		addFunction(new Sqrt() , Color.RED);
	}

	public static void main(String[] args) {
		new SineCosineMultiPlotter().run();
	}
}

class Sqrt implements Function {
	
	@Override
	public double apply(double x) {
		return Math.sqrt(x);
	}	
}

class Sine implements Function {

	@Override
	public double apply(double x) {
		return Math.sin(x);
	}
}

class Cosine implements Function {

	@Override
	public double apply(double x) {
		return Math.cos(x);
	}	
}
