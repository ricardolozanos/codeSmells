package noapplet.example;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import noapplet.NoApplet;
public class grid2D extends NoApplet{

    public grid2D() {
    }

    public grid2D(String[] params) {
        super(params);
    }

    protected void paintComponent(Graphics g) {
        int ROWS = 16;
        int COLS = 16;
        int squareSize = 30;
        setBackground(Color.WHITE);
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                int x1 = col * squareSize;
                int y1 = row * squareSize;
                g.drawRect(x1, y1, squareSize, squareSize);
            }
        }
        g.setFont(new Font("San-serif",Font.BOLD,25));
        g.drawString("Braulio Bracamontes",150,350);
        g.setColor(Color.PINK);
        g.fillOval(20,20,20,20);
        g.setColor(Color.GREEN);
        g.fillOval(140,140,20,20);
        g.setColor(Color.BLUE);
        g.fillOval(110,110,20,20);
        g.setColor(Color.YELLOW);
        g.fillOval(110,80,20,20);
    }

    public static void main(String[] args) {
        //new HelloWorld().run();
        // or specify optional parameters such as the window size
        new grid2D(new String[] {"width=485", "height=485"}).run();
    }
}
