package noapplet.example;

import java.util.ArrayList;
import java.util.List;

public abstract class MultiPlotter extends Plotter{
	
	protected void initMultiPlotter() {
		//Hook method for subclasses to set up functions to be plotted
	}
	
	public void init() {
		//Template method for initialization which calls initMultiPlotter()
		initMultiPlotter();
	}
	
	
	//Method to add a function to be plotted Auxiliary function called by paintComponet() to plot the functions
	public void addFunction() {
		addFunction();
	}
	
	public void plotFunction() {
		plotFunction(SineCosinePlotter.a);
	}
	
	public void func() throws Exception {
		// Method inherited from class Plotter that is no longer useful in this class
		throw new Exception("Isnt useful");
	}


}
