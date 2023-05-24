package noapplet.example;
import java.awt.*;

/** BouncingBall(include?) ??? Bounceable. (aggregation, dependency inversion)
 * Bounceable - interface (pure form of abstract class)
 *  Ball (abstract) implements Bounceable (*dependency on abstractions*)
 *  CircleBall extends (abstract) Ball.
 */

public interface Bounceable {
    void sizeOfBall(int a);
    void DirectionChange(int dx, int dy);
    void numOfBalls(int a);
}

abstract class Ball implements Bounceable{
    private int x,y;
    private int dx,dy;
    private int radius;

    @Override
    public void sizeOfBall(int radius){
        this.radius = radius;
    }

    @Override
    public void DirectionChange(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }
}
class CircleBall extends Ball {
    private int num;
    @Override
    public void numOfBalls(int num){

    }

}
