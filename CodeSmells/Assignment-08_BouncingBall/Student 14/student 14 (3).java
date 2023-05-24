package BouncingBall;

import java.util.ArrayList;
import java.util.List;
import java.awt.Rectangle;

public class Colsdet {
    List<bouncable> balls = new ArrayList<bouncable>();

    public Colsdet(List<bouncable> in){
        this.balls = in;
    }


    public void colisions(){
        for (bouncable i : balls){
            for (bouncable j : balls){
                if (i == j){

                }
                else if (getbounds(i).intersects(getbounds(j))) {
                    i.flipx();
                    i.flipy();
                }
            }
        }
    }

    public Rectangle getbounds(bouncable i){
        int offset= i.getraid();
        return new Rectangle(i.getx()-offset, i.gety()-offset, offset*2, offset*2);

    }
    
}
