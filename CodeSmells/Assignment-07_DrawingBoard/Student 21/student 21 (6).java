package noapplet.example;

import noapplet.NoApplet;
import java.awt.*;
import java.util.ArrayList;


public class DrawingBoard extends NoApplet{
	protected static java.util.List<Shape> shapes;
	public void init() {
		super.init();
		shapes = new ArrayList<	>();
		shapes.add(new Circle(20,20, Color.RED));
		shapes.add(new Rectangle(100,150, Color.BLUE));
		shapes.add(new Triangle(400,400, Color.GREEN));
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 500, 500);
		
		g.setColor(Color.BLACK);
    	g.setFont(new Font("San-serif", Font.BOLD, 24));
        g.drawString("Dante Lopez", 60, 40);
		
		for (Shape s: shapes) {
			   s.draw(g);
			}

	}
	
	public static void main(String[] args) {
		new DrawingBoard().run();
	}
}
