import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.Color;
class Ball {
    private int x, y, radius, vx, vy;
    private Color color;
    public Ball(int x, int y, int radius, int vx, int vy, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.vx = vx;
        this.vy = vy;
        this.color = color;
    }
//----------------------_GETTTERS_SETTERS_----------------------------
    public int getVy() {
        return vy;
    }
    public void setVy(int vy) {
        this.vy = vy;
    }
    public int getVx() {
        return vx;
    }
    public void setVx(int vx) {
        this.vx = vx;
    }
    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public Color getColor(){
        return this.color;
    }
}
