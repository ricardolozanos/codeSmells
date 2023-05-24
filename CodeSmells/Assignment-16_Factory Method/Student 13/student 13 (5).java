package noapplet.balloon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import noapplet.AnimationNoApplet;

public class GrowingBalloon extends AnimationNoApplet implements Balloon {

    public int sizeY = 0;
    public int sizeX = 0;
    public int diff = 1;
    public int cardinality = 1;
    public GrowingBalloon(){}
    public void setCard(Dimension d){
        cardinality = 1;
    }
    @Override
    public void paintComponent(Graphics g) {
        Dimension d = getSize();
        this.setCard(d);
        this.sizeX += this.diff * cardinality;
        this.sizeY += this.diff * cardinality;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, d.width, d.height);
        g.setColor(Color.BLACK);
        g.fillOval((d.width - this.sizeX)/2, (d.height - this.sizeY)/2, this.sizeX, this.sizeY);
    }
}