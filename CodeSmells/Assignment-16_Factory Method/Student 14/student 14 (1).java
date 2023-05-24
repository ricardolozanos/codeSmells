package noapplet.BallonAnim;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class bballon implements drawable{
    int size;
    int offset;

    
    


    public void draw(Graphics g, int h, int w){
    g.setColor(Color.GREEN);
    size = size + offset;
    g.fillOval(w/2-size/2, h/2-size/2, size, size);
    }





    public bballon(int size, int offset) {
        this.size = size;
        this.offset = offset;
    }





}
