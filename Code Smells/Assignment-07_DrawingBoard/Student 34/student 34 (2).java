package noapplet;

import java.awt.*;

abstract public class shape {
    protected int x, y;
    protected Color c;

    public shape(int x, int y, Color c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

    public shape() {

    }
    public abstract void drawShapes(Graphics g);

}

class circle extends shape{
    public circle(int x, int y, Color c){
        this.x = x;
        this.y = y;
        this.c = c;
    }
    @Override
    public void drawShapes(Graphics g){
        g.setColor(c);
        g.fillOval(x,y,40,40);
    }
}
class rectangle extends shape{
    public rectangle(int x, int y, Color c){
        this.x = x;
        this.y = y;
        this.c = c;
    }
    @Override
    public void drawShapes(Graphics g){
        g.setColor(c);
        g.fillRect(x,y, 50,50);
    }
}

class triangle extends shape{
    public triangle(int x, int y, Color c){
        this.x = x;
        this.y = y;
        this.c = c;
    }
    @Override
    public void drawShapes(Graphics g){
        g.setColor(c);
        //g.fillRect(x,y, 50,50);
        int [] x = {this.x ,this.x + 20, this.x + 40};
        int [] y = {this.y + 100,this.y,this.y + 100};
        g.fillPolygon(x,y,3);
    }
}
