package src.noapplet.example;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import noapplet.NoApplet;
@SuppressWarnings("serial")
public class OmokuGrid extends NoApplet{
    public OmokuGrid(){
    }

    public OmokuGrid(String[] params) {
        super(params);
    }

    protected void paintComponent(Graphics g) {
        Dimension d = getSize();
        //g.setColor(Color.ORANGE);
        g.fillRect(0, 0, d.width, d.height);
        g.setFont(new Font("San-serif", Font.BOLD, 24));
        g.setColor(new Color(255, 215,0));
        g.setColor(Color.BLACK);
        int mainValue = 400 / 16;
        int x1 = 40;
        int y1 = 40;
        g.setColor(Color.RED);
        g.drawString("Samantha Silva", 23,23);

        g.drawRect(x1,y1, 400,400);
        g.setColor(Color.ORANGE);
        g.fillRect(40,40,400,400);
        g.setColor(Color.BLACK);

        for (int i = 0; i <= 15; i++){
            x1 = x1 + mainValue;
            g.drawLine(x1, y1, x1, 440);
        }

        for (int i = 0; i <= 15; i++){
            y1 = y1 + mainValue;
            g.drawLine(40, y1, 440, y1);
        }
        g.drawOval(82,107,15,15); //x + 25
        g.setColor(Color.BLACK);
        g.fillOval(82,107,15,15);
        g.drawOval(82 + mainValue,107 + mainValue,15,15); // y + 25
        g.setColor(Color.WHITE);
        g.fillOval(82 + mainValue,107 + mainValue,15,15);



    }


    public static void main(String[] args) {
        //new HelloWorld().run();
        // or specify optional parameters such as the window size
        new OmokuGrid(new String[] {"width=500", "height=500"}).run();
    }
}
