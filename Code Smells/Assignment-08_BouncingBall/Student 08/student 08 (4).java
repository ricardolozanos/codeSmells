import java.awt.*;

public class CircleBall extends Ball{
    public CircleBall(int x, int y, int dx, int dy, int radius, Color color, BouncingBall parent) {super(x,y,dx,dy,radius,color,parent);}

    public void draw(Graphics g) {
        movement();
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}
