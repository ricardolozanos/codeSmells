package plotter;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class MultiPlotter extends Plotter {	
	
	List<Function> mp = new ArrayList<Function>();
	List<Color> c = new ArrayList<Color>();
	
	public MultiPlotter() {
		super();
	}

	@Override
	public void init() {
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

		initMultiPlotter();
	}

	
	public void initMultiPlotter() {
	}
	

	public void addFunction(Function f , Color t){
		mp.add(f);
		c.add(t);
	}

	@Override
	public void plotFunction(Graphics g) {
		
		for (var px = 0; px < dim.width; px++) {
            try {
            	for ( int i=0; i<mp.size(); ++i ) {
            		g.setColor(c.get(i));
            		double x = (double)(px - xorigin) / (double)xratio; 
            		double y = mp.get(i).apply(x); 
            		int py = yorigin - (int) (y * yratio); 
            		g.fillOval(px - 1, py - 1, 3, 3);
            	}
            } catch (Exception ignored) {} 
        }
	}

	@Override
	public double func(double x) {
		return x;
	}	

}


