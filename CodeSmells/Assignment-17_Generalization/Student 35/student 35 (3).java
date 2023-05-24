package multiFunction;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("serial")
public class MultiPlotter extends Plotter {
	
	
	List<Function> f = new LinkedList<Function>();
	
	public MultiPlotter() {
		super();
	}
	
	public MultiPlotter(String[] args) {
		super(args);
	}
	

	@Override
	public double func(double x) {

		return -1;
		
	}
	
	public void initMultiPlotter(){
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
		
	}
	
	public void init() {
		
		initMultiPlotter();
		
	}
	
	public void addFunction(Function func) {
		
		f.add(func);

		
	}
	
	public void plotFunction(Graphics g) {
		
		for (var px = 0; px < dim.width; px++) {
            try {
                double x = (double)(px - xorigin) / (double)xratio; 
                for(int i = 0; i < f.size(); i ++) {
                	double y = f.get(i).apply(x);
                	int py = yorigin - (int) (y * yratio); 
                	g.fillOval(px - 1, py - 1, 3, 3); 
                }
                
            } catch (Exception ignored) {} 
        }
		
	}
	
	
	

}
