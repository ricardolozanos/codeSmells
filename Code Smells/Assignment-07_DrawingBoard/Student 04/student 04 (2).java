package noapplet.assignments.Shapes;
import java.awt.*;

public abstract class Shape {
    private int x;
    private int y;
    private Color color;

    protected Shape(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public abstract void draw(Graphics g);

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Color getColor(){ 
        return color;
    }
}
