package guiboard.modelgui;
import noapplet.NoApplet;

import java.awt.*;
/** Model for Omok Board Background. */
public class Boarder extends NoApplet implements Drawer{
    public Boarder(){}
    public Boarder(String[] args){
        super(args);
    }
    /** Draws an Empty Board */
    @Override
    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g; // provides more control over
        //shapes and line size and etc
        g2.setStroke(new BasicStroke(2));
        g2.setColor(new Color(252,232,177));
        g2.fillRect(0,0, 300,300);
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(1));
        int w = 0;
        while(w < 300+(300/15)) {//vertical lines
            g2.drawLine(w, 0, w, 300);
            w = w + (300/15);
        }
        int h = 0;
        while(h <300+(300/15)){//horizontal lines
            g2.drawLine(0, h, 300, h);
            h = h + (300/15);
        }
    }

}
