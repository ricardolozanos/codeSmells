package noapplet;
import java.awt.*;
public class DrawingBoard extends NoApplet {



@Override
protected void paintComponent(Graphics g) {
	Triangle t=new Triangle();
	Rectangle r=new Rectangle();
	Circle c=new Circle();
	c.draw(g);
	r.draw(g);
	t.draw(g);

}

public static void main(String [] args) {
	new DrawingBoard().run();
	
}
public void init(){}
}
