package DrawingBoard;

import java.awt.Color;
import java.awt.Graphics;
//import javax.swing.Timer;



@SuppressWarnings("serial")
public class DrawingBoardRunner extends noapplet.AnimationNoApplet {	
		
	protected void initAnimation() {
		super.init();
	}
	
	@Override
	protected void paintComponent(Graphics g) { 
		Shapes[] s = new Shapes[3];
		s[0] = new Circle(10,20,Color.RED);
		s[1] = new Rectangle(100,200,Color.BLUE);
		s[2] = new Triangle(320 , 400 , Color.ORANGE);
		
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, 400, 400);
		
		for(Shapes x: s) {
			x.drawShapes(g);
		}
	}

	public static void main(String[] args) {
		new DrawingBoardRunner().run();
	}

}
