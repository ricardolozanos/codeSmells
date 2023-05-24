package noapplet;
import java.awt.*;
public class Circle extends Shape {
	Circle(){
		super(50,50,Color.RED);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawOval(getX(), getY(), getY(), getX());
		g.setFont(new Font("San-serif", Font.BOLD, 24));
	    g.setColor(new Color(255, 215,0));
		g.drawString("Carlos Sandoval", 150, 100);
		
	}

	

}
