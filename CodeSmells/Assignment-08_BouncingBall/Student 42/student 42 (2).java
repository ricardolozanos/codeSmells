package noapplet.BouncingBalls;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
public abstract class Ball implements Bounceable{
    protected int x,y;
    protected int dx, dy;
    protected int radius;
    protected Color color;
    protected List<Bounceable> balls;

    protected Ball(int x, int y, int radius, int dx, int dy, Color color, List<Bounceable> balls){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.dx = dx;
        this.dy = dy;
        this.color = color;
        this.balls = balls;
    }
    public abstract void draw(Graphics g);
    public void isColliding(){
        double distance;
        int tempDx, tempDy;
        CircleBall tempBall;
        for(Bounceable ball: balls) {
            tempBall = (CircleBall) ball;
            distance = Math.sqrt((tempBall.x - x)*(tempBall.x - x) + (tempBall.y - y)*(tempBall.y - y));
            if(distance <= (radius + tempBall.radius)) {
                tempDx = dx;
                tempDy = dy;
                dx = tempBall.dx;
                dy = tempBall.dy;
                tempBall.dx = tempDx;
                tempBall.dy = tempDy;
            }
        }
    }
    @Override
    public void move(){
        isColliding();
        if (x < radius || x > 400 - radius) {dx = -dx;}
        if (y < radius || y > 400 - radius) { dy = -dy;}
        x += dx;
        y += dy;
    }
    public int getX(){return x;}
    public int getY(){return y;}
    public int getDX(){return dx;}
    public int getDY(){return dy;}
    public Color getColor(){return color;}
}
