package noapplet.example;
import noapplet.NoApplet;
import java.awt.*;

public class Board extends NoApplet {

	public Board() {
	}

	public Board(String[] params) {
		super(params);
	}
	
    protected void paintComponent(Graphics g) {
        Dimension d = getSize();
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, d.width, d.height);
        g.setFont(new Font("San-serif", Font.BOLD, 30));
        g.setColor(Color.RED);
        g.drawString("Alan Robles", 80, 80);
        int x = 0;
        int y = 0;
        /*
        Draw the horizontal lines in the grid using a for loop
        where X has the value 330
         */
        for (y = 0 ; y < 330; y += 30){
            g.drawLine(330,y,x,y);
        }
        /*
        This is to draw the vertical lines in the grid using a for loop where
        Y has a value of 330
         */
        x = 0;
        y = 0;
        for (x = 0; x < 330; x += 30){
            g.drawLine(x,330,x,y);
        }
        /*
        Draw the first circle
         */
        g.setColor(Color.BLACK);
        g.drawOval(22,23,15,15);
        g.fillOval(22,23,15,15);
        /*
        Drawing the second circle
         */
        g.setColor(Color.BLUE);
        g.drawOval(82,143,15,15);
        g.fillOval(82,143,15,15);

    }  

    public static void main(String[] args) {

        new Board(new String[] {"width=330", "height=320"}).run();
    }
}
