package noapplet.BallonAnim;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class bballonadv extends bballon{
    int size;
    int offset;
    boolean shrink = false;


    
    


    public void draw(Graphics g, int h, int w){
        g.setColor(Color.GREEN);
        if(shrink) {
            size = size - offset;
            if(size == 7) {
                shrink = false;
            }
        }
        else {
            size = size + offset;
            if(w <= size || h <= size) {
                shrink = true;
            }
        }
        g.fillOval(w/2-size/2, h/2-size/2, size, size);
    };





    public bballonadv(int size, int offset) {
        super(size, offset);
        this.size = size;
        this.offset = offset;
       }





    





}
