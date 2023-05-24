package drawingBoard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import noApplet.NoApplet;

@SuppressWarnings("serial")
public class DrawingBoard extends NoApplet{
	
	public DrawingBoard() {
		
	}

	public DrawingBoard(String [] args) {
		super(args);
	}
	
	@Override
	public void init() {
		
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		
		Dimension d = getSize();
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, d.width, d.height);
		
		Shape c = new Circle(50, 200, Color.RED);
		c.drawShape(g);
		
		Shape r = new Rectangle(150, 50, Color.CYAN);
		r.drawShape(g);
		
		Shape t = new Triangle(200, 200, Color.WHITE);
		t.drawShape(g);
		
		g.setColor(Color.CYAN);
		g.setFont(new Font("Dialog", 2, 30));
		g.drawString("Danilo Romero", d.width - 250, d.height - 50);
		

		
	}
	
	public static void main(String[] args) {
		new DrawingBoard(new String[] {"width=300", "height=350"}).run();
	}
	
}
