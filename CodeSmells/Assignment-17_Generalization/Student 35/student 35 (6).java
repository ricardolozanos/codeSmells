package multiFunction;

@SuppressWarnings("serial")
public class SineCosinePlotter extends MultiPlotter {
	
	Function sn = new Sine();
	Function csn = new Cosine();
	
	public SineCosinePlotter() {
		super();
	}
	
	public SineCosinePlotter(String[] args) {
		super(args);
	}

	
	@Override
	public void initMultiPlotter(){
		
		addFunction(sn);
		addFunction(csn);
		
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
	
	public static void main(String[] args) {
		SineCosinePlotter n = new SineCosinePlotter();
		n.run();


	}


}


