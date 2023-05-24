package noapplet.example;

import noapplet.NoApplet;

import java.awt.*;


public class omok extends NoApplet{

    public omok() {
    }

    public omok(String[] params) {super(params);
    }

    protected void paintComponent(Graphics g) {
        Dimension d = getSize();
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, d.width, d.height);
        g.setColor(new Color(0, 0,0));
        int i = 0;
        while (i <= d.width){
            g.drawLine(i, 0, i, d.height);
            i += 22;
        }
        i = 0;
        while (i <= d.height){
            g.drawLine(0, i, d.width, i);
            i += 22;
        }
        g.setColor(Color.BLUE);
        g.drawOval(33, 33, 20, 20);
        g.fillOval(33, 33, 20, 20);

        g.setColor(Color.RED);
        g.drawOval(33, 55, 20, 20);
        g.fillOval(33, 55, 20, 20);

        g.setColor(Color.BLACK);
        g.drawString("Anthony Romero", 150, 150);

        // divide the width to get the amount needed.
        //then you need to do the X axis as well

        
    }

    public static void main(String[] args)
    {
        //new HelloWorld().run();
        // or specify optional parameters such as the window size
        new omok(new String[]{"width=330", "height=350"}).run();
    }
}