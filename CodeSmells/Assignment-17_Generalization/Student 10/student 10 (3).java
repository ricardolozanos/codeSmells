package noapplet.example.plotter;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class MultiPlotter extends Plotter{
	
	private int yorigin;
	private int xorigin;
	List<Function> listOfFunctions;

	void initMultiPlotter(){
		dim = getSize(); 
        String att = getParameter("xratio");
        if (att != null) 
            xratio = Integer.parseInt(att); 
        att = getParameter("yratio");
        if (att != null) 
            yratio = Integer.parseInt(att); 
        att = getParameter("xorigin");
        if (att != null) 
            xorigin = Integer.parseInt(att); 
        else 
            xorigin = dim.width / 2; 
        att = getParameter("yorigin");
        if (att != null) 
            yorigin = Integer.parseInt(att); 
        else 
            yorigin = dim.height / 2; 
	};
	
	
	void addFunction(Function f, Color color){
		listOfFunctions.add(f);
	}
	
	protected void plotFunction(Graphics g) {
		for(Function f :listOfFunctions) {
			for (var px = 0; px < dim.width; px++) {
	            try {
	                double x = (double)(px - xorigin) / (double)xratio; 
	                double y = f.apply(x); 
	                int py = yorigin - (int) (y * yratio); 
	                g.fillOval(px - 1, py - 1, 3, 3); 
	            } catch (Exception ignored) {} 
	        }
		}
        
    }

	@Override
	public double func(double x) {
		// TODO Auto-generated method stub
		return 0;
	}
	


}
