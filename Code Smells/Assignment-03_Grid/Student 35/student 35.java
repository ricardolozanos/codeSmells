package goodDay;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import noapplet.NoApplet;

@SuppressWarnings("serial")
public class GomokuDisplay extends NoApplet {
	
	public GomokuDisplay() {
		
	}
	
	public GomokuDisplay(String[] params) {
		super(params);
	}
	
	protected void paintComponent(Graphics g) {
		Dimension d = getSize();
		
		//Background set up
		g.setColor(Color.ORANGE);
		g.fillRect(0,  0,  d.width, d.height);
		
		
		// temp Variables that are needed for calculations
		int tempWidth = (int) d.width/15;
		int tempHeight = (int) d.height/15;
		int max = Math.max(tempWidth, tempHeight);
		
		//Line Drawing
		g.setColor(Color.black);
		for(int i=1; i<=15; i++) {
			g.drawLine(tempWidth*i, 0, tempWidth*i, d.height);
			g.drawLine(0, tempHeight*i, d.width, tempHeight*i);
		}
		
		
		// Red Ball
		int [] positionR = {9, 5};
		g.setColor(Color.RED);
		g.fillOval((positionR[0] * tempWidth) + (int) (tempWidth / 2), (positionR[1] * tempHeight) + (int) (tempHeight / 2), max, max);
		
		// Blue Ball
		
		int [] positionB = {7, 3};
		g.setColor(Color.BLUE);
		g.fillOval((positionB[0] * tempWidth) + (int) (tempWidth / 2), (positionB[1] * tempHeight) + (int) (tempHeight / 2), max, max);
		
		// Name
		g.setColor(Color.CYAN);
		g.setFont(new Font("San-serif", Font.ITALIC, tempHeight));
		g.drawString("Danilo Romero", (int) d.width / 2,d.height - tempHeight);
		
		
		
	}
	public static void main(String[] args) {
		
		new GomokuDisplay(new String[] {"width=600", "height=600"}).run();
	}
}
