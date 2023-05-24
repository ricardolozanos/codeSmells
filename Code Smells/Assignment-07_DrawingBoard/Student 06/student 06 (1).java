package noapplet.example;

import java.awt.*;

import noapplet.NoApplet;

/**
 * Simple NoAppet app to draw a text and an image. The displayed image
 * is obtained from the file <code>src/image/rabbit.jpg</code>, where
 * <code>src</code> is the resource directory of your Java project.
 * Refer to your IDE to designate the resource directory of your project.
 */
@SuppressWarnings("serial")
public class HelloWorld extends NoApplet {
	public HelloWorld() {
	}

	public HelloWorld(String[] params) {
		super(params);
	}

    protected void paintComponent(Graphics g) {
        Shape circle = new Shape(30, 30, Color.black);
        Shape square = new Shape(100, 100, Color.cyan);
        Shape triangle = new Shape(30, 200, Color.red);
        Shape name = new Shape(100, 400, Color.orange);
        circle.circle(60, g);
        square.square(60, 60, g);
        triangle.triangle(60, 60, g);
        name.name(g);

//        Dimension d = getSize();
//        g.setColor(new Color(168, 116,67));
//        g.fillRect(0, 0, d.width, d.height);
//        g.setFont(new Font("Arial", Font.ITALIC, 12));
//        g.setColor(Color.black);
//        g.drawString("Ruben Bolado - OMOK BOARD, 80594955", 150, 600);
////        g.drawImage(getImage("rabbit.jpg"), 40, 60, this);
//        for(int i=0; i<570; i+=30){
//            for(int j=0; j<570; j+=30){
//                g.drawRect(i, j, 30, 30);
//            }
//        }
//        g.fillOval(198, 198, 24, 24);
//        g.setColor(Color.white);
//        g.fillOval(198,228, 24, 24 );
    }

    public static void main(String[] args) {
    	//new HelloWorld().run();
    	// or specify optional parameters such as the window size
        new HelloWorld(new String[] {"width=570", "height=620"}).run();
    }
}
