package noapplet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class OmokBoard extends NoApplet {
    
    @Override
    protected void paintComponent(Graphics g) {
        Dimension dim = getSize();
        g.setColor(Color.white);
        g.fillRect(0, 0, dim.width, dim.height); // paint background
        
        g.setColor(Color.black);
        g.drawLine(2, 0, 2, 400);
        g.drawLine(28, 0, 28, 400);
        g.drawLine(54, 0, 54, 400);
        g.drawLine(80, 0, 80, 400);
        g.drawLine(106, 0, 106, 400);
        g.drawLine(132, 0, 132, 400);
        g.drawLine(158, 0, 158, 400);
        g.drawLine(184, 0, 184, 400);
        g.drawLine(210, 0, 210, 400);
        g.drawLine(236, 0, 236, 400);
        g.drawLine(262, 0, 262, 400);
        g.drawLine(288, 0, 288, 400);
        g.drawLine(314, 0, 314, 400);
        g.drawLine(340, 0, 340, 400);
        g.drawLine(366, 0, 366, 400);

        g.drawLine(0, 2, 400, 2);
        g.drawLine(0, 28, 400, 28);
        g.drawLine(0, 54, 400, 54);
        g.drawLine(0, 80, 400, 80);
        g.drawLine(0, 106, 400, 106);
        g.drawLine(0, 132, 400, 132);
        g.drawLine(0, 158, 400, 158);
        g.drawLine(0, 184, 400, 184);
        g.drawLine(0, 210, 400, 210);
        g.drawLine(0, 236, 400, 236);
        g.drawLine(0, 262, 400, 262);
        g.drawLine(0, 288, 400, 288);
        g.drawLine(0, 314, 400, 314);
        g.drawLine(0, 340, 400, 340);
        g.drawLine(0, 366, 400, 366);

        g.setColor(new Color(0, 255,255));
        g.fillOval(171, 197, 26, 26);

        g.setColor(new Color(255, 0,255));
        g.fillOval(249, 171, 26, 26);

        g.setFont(new Font("San-serif", Font.BOLD, 12));
        g.setColor(new Color(25, 0,255));
        g.drawString("Nayeli Ramirez", 280, 330);
        
    }

    public static void main(String[] args) {
        new OmokBoard().run();
    }
}