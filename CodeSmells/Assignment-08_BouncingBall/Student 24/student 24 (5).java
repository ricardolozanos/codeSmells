package noapplet.example;

import java.util.ArrayList;
import java.util.List;
import java.awt.Rectangle;

public class Collision {
    List<Bounceable> balls = new ArrayList<Bounceable>();
    public Collision(List<Bounceable> in){
        this.balls = in;
    }
    public void detect(){
        for (Bounceable b : balls){
            for (Bounceable c : balls){
                if (b == c){
                    continue;
                }
                else if (getbounds(b).intersects(getbounds(c))) {
                    b.flipX();
                    b.flipY();
                }
            }
        }
    }
    public Rectangle getbounds(Bounceable b){
        int offset= b.getRadius();
        return new Rectangle(b.getX()-offset, b.getY()-offset, offset*2, offset*2);

    }
}
