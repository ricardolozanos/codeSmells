package noapplet.excercise.plotter;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public abstract class MultiPlotter extends Plotter{
	ArrayList<Function> functions;
	
	public MultiPlotter(String[] args) {
		super(args);
		functions = new ArrayList<Function>();
	}
	public MultiPlotter() {
		super();
		functions = new ArrayList<Function>();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		drawCoordinates(g);
		for(var v:functions) {
			plotFunction(g, v);
			
		}
	}
	protected void plotFunction(Graphics g, Function f) {
		g.setColor(f.getColor());
        for (var px = 0; px < dim.width; px++) {
            try {
                double x = (double)(px - xorigin) / (double)xratio; 
                double y = f.apply(x); 
                int py = yorigin - (int) (y * yratio); 
                g.fillOval(px - 1, py - 1, 3, 3); 
            } catch (Exception ignored) {} 
        }
    }
		
	public void addFunction(Function a){
		functions.add(a);
	}
}
