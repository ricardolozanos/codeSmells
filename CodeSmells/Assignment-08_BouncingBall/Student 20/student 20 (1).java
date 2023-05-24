import java.awt.*;

public abstract class Ball implements Bounceable{
    private Color color = Color.GREEN;
    private int radius = 20;
    private int x, y;
    private int dx = -2, dy = -4;
//    private int dimHeight,dimWidth;

    public Ball(){}
    public Ball(Color color,int radius, int x, int y, int dx, int dy){
        this.color = color;
        this.radius = radius;
        this.x= x;
        this.y= y;
        this.dx= dx;
        this.dy= dy;
//        this.dimHeight = dimHeight;
//        this.dimWidth = dimWidth;
    }
    public void draw(Graphics g){
        if (x < radius || x > 300 - radius) {
            dx = -dx;
        }
        if (y < radius || y > 300 - radius) {
            dy = -dy;
        }
        x += dx;
        y += dy;
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
        }
    public void setX(int newX){
        this.x = newX;
    }
    public void setY(int newY){
        this.y = newY;
    }
    public void setDx(int newDx){
        this.dx = newDx;
    }
    public void setDy(int newDy){
        this.dy = newDy;
    }
    public int getRadius(){
        return radius;
    }
    public int getXball(){
        return x;
    }
    public int getYball(){
        return y;
    }
    public int getDx() {
        return dx;
    }
    public int getDy() {
        return dy;
    }
    public Color getColor(){
        return color;
    }
}
