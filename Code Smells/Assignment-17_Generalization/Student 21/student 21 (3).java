package noapplet.example;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class SineCosinePlotter extends MultiPlotter {
	public static Graphics a;

	public void initMultiPlotter() {
		List<Function> a = new ArrayList(); 
		a.addFunction(new Sine(), Color.BLUE);
		a.addfunction(new Cosine(), Color.RED);
	}

	public static void main(String[] args) {
		new SineCosinePlotter().run();
	}

	@Override
	public double func(double x) {
		return 0;
	}
}

class Sqrt {
	public double apply(double x) {
		return Math.sqrt(x);
	}
}

class Sine {
	public double apply(double x) {
		return Math.sin(x);

	}
}

class Cosine {
	public double apply(double x) {
		return Math.cos(x);

	}
}

interface Function{
	double func(double x);
}