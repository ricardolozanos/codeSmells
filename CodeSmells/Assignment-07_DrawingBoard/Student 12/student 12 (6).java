
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;
public abstract class Shape {
    private int x,y;
    private Color c;
    public Shape(int x, int y, Color c){
        this.x = x;
        this.y = y;
        this.c = c;
    }
    public abstract void draw(Graphics g, boolean fill);
//--------------------------Getters/Setters-------------------------------------
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
    public Color getC() {
        return c;
    }
    public void setC(Color c) {
        this.c = c;
    }
    
}
