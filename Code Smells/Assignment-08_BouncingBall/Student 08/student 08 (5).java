import java.util.List;
import java.util.ArrayList;
import java.awt.*;

public class collision {
    List<Bounceable> balls = new ArrayList<Bounceable>();
    public collision(List<Bounceable> b) {
        this.balls = b;
    }

    public void col() {
        for(Bounceable i: balls) {
            for(Bounceable j: balls) {
                if(i == j) {

                }
                else if (bounds(i).intersects(bounds(j))) {
                    i.flipX();
                    i.flipY();
                }
            }
        }
    }
    public Rectangle bounds(Bounceable b) {
        return new Rectangle(b.getX()-b.getRadius(), b.getY() - b.getRadius(),b.getRadius()*2,b.getRadius()*2);
    }

}
