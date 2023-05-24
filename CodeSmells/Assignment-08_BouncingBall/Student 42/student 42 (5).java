package noapplet.BouncingBalls;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
class CircleBall extends Ball {
    public CircleBall(int x, int y, int radius, int dx, int dy, Color color, List<Bounceable> balls){
        super(x,y,radius,dx,dy,color,balls);
    }
    @Override
    public void draw(Graphics g){
        g.setColor(getColor());
        g.fillOval(getX(),getY(),radius*2, radius*2);
    }
}
