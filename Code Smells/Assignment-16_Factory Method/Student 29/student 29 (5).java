package Balloon;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SuppressWarnings("serial")
public class ModularBalloonApp extends noapplet.AnimationNoApplet {
	List<Balloon> b = new ArrayList<Balloon>();
	Random r = new Random();

	protected ModularBalloonApp(String[] args) {
    	super(args);
    }
	
	@Override
	public void init() {
		dim = getSize();
		int x, y, rate;
	
		Color randomColor = new Color (r.nextInt(255),r.nextInt(255),r.nextInt(255));
		rate = 1;
		x = dim.width/2;
		y = dim.height/2;

		b.add(createBalloon(x,y,1,1,rate,randomColor));
	}
	
	protected Balloon createBalloon(int x , int y , int t , int d , int rate , Color randomColor) {
		return new GrowingBalloon(x, y, t, d, rate, randomColor );
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.fillRect(0, 0, dim.width, dim.height);    
		for ( Balloon a : b ) {
			a.draw(g);
		}

	}
    
	public static void main(String[] args) {
		new ModularBalloonApp(new String[]{"width=400", "height=400", "delay=100"}).run();
    }
}
