package BouncingBall;

import java.awt.Color;
import java.awt.Graphics;

public class roundball extends ball {
    public roundball(int x, int y, int dx, int dy, int radius, Color color, BouncingBall parent) {
        super(x, y, dx, dy, radius, color, parent);

    }
    public roundball(){

    }

    public void paint(Graphics g){
        super.movement(g);
        g.setColor(super.getColor());
        g.fillOval(super.getx()-super.getraid(), super.gety()-super.getraid(), super.getraid()*2, super.getraid()*2);

    }


    
}
