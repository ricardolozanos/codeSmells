package noapplet.example;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import noapplet.NoApplet;

public class Omok extends NoApplet {
    public static void main(String[] args) { // main
        new Omok(new String[] {"width=350", "height=350"}).run();
    }

    public Omok() {
    }

    public Omok(String[] params) {
        super(params);
    }

    protected void paintComponent(Graphics g) {
        Dimension d = getSize();
        g.setColor(new Color(255, 200, 0));
        g.fillRect(0, 0, d.width, d.height);
        g.setFont(new Font("San-serif", Font.BOLD, 24)); // name
        g.setColor(new Color(0, 0,0));

        //g.drawImage(getImage("rabbit.jpg"), 40, 60, this);
        for(int i = 0; i < 15; i++){ // beautiful :)
            int lineOffset = (int)((float)d.width/16 * (i+1)); // useful for later
            g.drawLine(lineOffset,0,lineOffset,d.height);
            g.drawLine(0, lineOffset, d.width, lineOffset);
        }

        int center = d.width/2;
        int squareOffset = d.width / 16;
        // first Circle
        g.fillOval(center-10,center-10,20,20);

        // second Circle
        g.setColor(Color.red);
        g.fillOval(center-10 + squareOffset,center-10 - squareOffset,20,20);
        g.setColor(Color.white);
        g.drawOval(center-10 + squareOffset ,center-10 - squareOffset,20,20);

        // Type Name
        g.setColor(Color.BLACK);
        g.drawString("Francisco A. Roman", 60, 40);
    }
}
