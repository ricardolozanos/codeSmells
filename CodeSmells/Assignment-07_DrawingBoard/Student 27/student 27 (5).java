package drawing_board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.*;
import java.util.*;

import noapplet.NoApplet;

@SuppressWarnings("serial")
public class DrawingBoard extends NoApplet{
	private java.util.List<Shape> shapes;
	
	
	public DrawingBoard() {
		
	}
	
	public DrawingBoard(String[] params) {
		super(params);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Rectangle rect = new Rectangle(700, 500, Color.RED);
		rect.draw(g);
		Circle circ = new Circle(100, 500, Color.BLUE);
		circ.draw(g);
		Triangle triangle = new Triangle(300, 300, Color.GREEN);
		triangle.draw(g);
		g.setColor(Color.BLACK);
		g.setFont(new Font("San-serif", Font.BOLD, 24));
        g.drawString("Nathanael Perez", 800, 50);
        	
    }  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// generates new window size to fit my computer
		new DrawingBoard(new String[] {"width=1000", "height=1000"}).run();
	}
}
