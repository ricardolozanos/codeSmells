package noapplet.example.drawingboard;

import noapplet.NoApplet;

import java.awt.*;

public abstract class Shape extends NoApplet {
    private int x,y;
    private Color c;

    protected Shape(int x, int y, Color c){
        this.x = x;
        this.y = y;
        this.c = c;
    }
    public abstract void draw(Graphics g);
    public int getX(){return x;}
    public int getY(){return y;}
    public Color getColor(){return c;}

    public static void main(String[] args){

    }

}



