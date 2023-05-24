package noapplet.example.DrawingBoard;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import noapplet.AnimationNoApplet;


@SuppressWarnings("serial")
//extended AnimationNoApplet intead of NoApplet in order to use the initAnimation instead of init()
public class DrawingBoard extends AnimationNoApplet {
	private List<Shape> shapes;
	
	public static void main(String[] args) {
		new DrawingBoard().run();
	}

	protected void initAnimation() {
		super.initAnimation();
		shapes = new ArrayList<>();
		//creates the shapes
		shapes.add(new Circle()) ;
		shapes.add(new Rectangle()) ;
		shapes.add(new Triangle()) ;
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//draws each shape in shapes
		for (Shape s: shapes)
			s.draw(g);
		g.setColor(Color.MAGENTA);
		g.drawString("Julieta C.", 160, 300);
		
	}

}
