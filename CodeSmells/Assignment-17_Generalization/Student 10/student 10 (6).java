package noapplet.example.plotter;

import java.awt.Color;

public class SineCosinePlotter extends MultiPlotter {
	public void initMultiplotter() {
		addFunction(new Sine(),Color.green);
		addFunction(new Cosine(),Color.green);
	}
	
	public static void main(String[]args){
		new SineCosinePlotter.run();
	}

}
