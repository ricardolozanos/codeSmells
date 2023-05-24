package noapplet.Files;
import java.awt.*;

public abstract class Shapes {

    private int x;
    private int y;
    private Color c;

    public Shapes (int x, int y, Color C){
        this.x = x;
        this.y = y;
        this.c = c;
    }

    public abstract void draw(Graphics G);

    public int getX(){

        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public Color getC(){
        return this.c;
    }

}
