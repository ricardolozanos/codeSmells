package noapplet.Bouncing;
import java.awt.*;

public abstract class Ball{
    private int x, y;
    int dx;
    int dy;
    private Color c;

    protected Ball(int x, int y, int dx, int dy, Color c){
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.c = c;
    }
    public abstract void draw(Graphics g);
    public int getX(){return x;}
    public int getdX(){return dx;}
    public int getdY(){return dy;}
    public int getY(){return y;}
    public abstract void move();
    public abstract void changeDirection(Ball other);
    public Color getColor(){return c;}
    public abstract boolean intersect(Ball other);
}
