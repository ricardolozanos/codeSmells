package noapplet.Bouncing;
import java.awt.*;
public class CircleBall extends Ball {
    int x,y;
    int dx, dy;
    private Color c;
    protected CircleBall(int x, int y,int dx, int dy, Color c) {
        super(x, y,dx, dy, c);
        this.c = c;
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(c);
        g.fillOval(getX(),getY(),50,50);
    }
    @Override
    public void move(){
        x = getX();
        y = getX();
        dx = getdX();
        dy = getdY();
        if (x < 0 || x > 800 - 50) {
            dx = -dx;
        }
        if (y < 0 || y > 800 - 50) {
            dy = -dy;
        }
        x += dx;
        y += dy;
    }
    @Override
    public void changeDirection(Ball other) {
        int tmpDx = dx;
        int tmpDy = dy;
        dx = other.dx;
        dy = other.dy;
        other.dx = tmpDx;
        other.dy = tmpDy;
    }

    @Override
    public boolean intersect(Ball other) {
        int distanceX = (x + 50 / 2) - (other.getX() + 50 / 2);
        int distanceY = (y + 50 / 2) - (other.getY() + 50 / 2);
        double distance = (Math.sqrt(dx*dx+dy*dy));
        //double distance = (0);
        if(distance <= 20){
            return true;
        }
        return false;
    }
}