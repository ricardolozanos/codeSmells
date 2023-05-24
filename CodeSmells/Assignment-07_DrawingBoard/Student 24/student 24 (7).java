package noapplet;

import java.awt.*;
/**
 * Author: Jesus Oropeza
 */
public abstract class Shape{
    private int x;
    private int y;
    private int izeSay;
    private Color color;
    protected Shape(int x, int y, int size, Color color){
        this.x = x;
        this.y = y;
        this.izeSay = size;
        this.color = color;
    }

    public abstract void draw(Graphics g);
    public int getX(){return x;}
    public int getY(){return y;}
    public int getIzeSay(){return izeSay;}
    public Color getColor(){return color;}

}
