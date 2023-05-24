package noapplet.example;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import noapplet.NoApplet;

public class DrawingBoard extends NoApplet{
	final ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public static void main(String[] args) {
        new DrawingBoard().run();
    }
	public void init() {
		shapes.add(new Circle(10,10,Color.RED));
		shapes.add(new Rectangle(70,70,Color.GRAY));
		shapes.add(new Triangle(200,200,Color.BLUE));
		
	}
	public void paintComponent(Graphics g) {
		for(Shape s: shapes) {
			s.Draw(g);
		}
	}
}

