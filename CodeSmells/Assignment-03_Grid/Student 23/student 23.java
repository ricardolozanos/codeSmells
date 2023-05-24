package noapplet;

import java.awt.*;

public class Omok extends NoApplet{

    public Omok() {
    }

    public Omok(String[] params) {
        super(params);
    }

    protected void paintComponent(Graphics g) {
        Dimension d = getSize();
        g.setColor(new Color(236, 200,43));
        g.fillRect(0, 0, d.width, d.height);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Serif", Font.BOLD, 25));
        g.drawString("オモック", 200, 35);
        g.setFont(new Font("Consolas", Font.ITALIC, 10));
        g.drawString("By Dannell Munoz", 310, 35);
        for (int i = 0; i < 15; i++){   // Horizontal Lines
            g.drawLine(40, 50+(i* 30), 460, 50+(i* 30));
            g.drawLine(40+(i*30), 50, 40+(i*30), 470);
        }
        g.drawOval(240, 250, 20, 20);
        g.fillOval(240, 250, 20, 20);
        g.setColor(Color.WHITE);
        g.drawOval(270, 280, 20, 20);
        g.fillOval(270, 280, 20, 20);
    }
    public static void main(String[] args) {
        new Omok(new String[] {"width=500", "height=500"}).run();


    }
}
