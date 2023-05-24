package noapplet.Bouncing;
import java.awt.*;

interface Bounceable{
    void draw(Graphics g);
    int getX(int x);
    int getY(int y);
    int getdX(int dx);
    int getdY(int dy);
    public abstract void move();
    public abstract void changeDirection(Ball other);
    Color getColor(Color c);
    public abstract boolean intersect(Ball other);
}
