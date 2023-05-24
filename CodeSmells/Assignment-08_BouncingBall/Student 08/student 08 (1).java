
import java.awt.*;

public abstract class Ball implements Bounceable{
    protected int x, y, dx, dy, radius;
    protected Color color;
    protected BouncingBall parent;
    protected Bounceable bounceable;
    protected Ball(int x, int y, int dx, int dy, int radius, Color color, BouncingBall parent) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.radius = radius;
        this.color = color;
        this.parent = parent;
    }

    public abstract void draw(Graphics g);
    protected void movement() {
        if (x < radius || x > 500 - radius) {
            dx = -dx;
        }
        if (y < radius || y > 500 - radius) {
            dy = -dy;
        }
        x += dx;
        y += dy;

    }
    public Color getColor() {return color;}
    public int getX() {return x;}
    public int getY() {return y;}
    public int getRadius() {return radius;}
    public void flipX() {dx = -dx;}
    public void flipY() {dy = -dy;}


}
