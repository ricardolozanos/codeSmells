import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

public class Triangle extends Shape {
    private int size = 20;
    public Triangle(int x, int y, Color c, int size){
        super(x, y, c);
        this.size = size;
    }
    public int[][] getPoints(){
        int x = getX();
        int y = getY();
        int[][] coordinates = {{ x,x+size, x-size },{  y-size,y+size,y+size}};
        return coordinates;
    }
    @Override
    public void draw(Graphics g, boolean fill){
        g.setColor(getC());
        if(fill){
            g.fillPolygon(getPoints()[0],getPoints()[1],3);
        }else{
            g.drawPolygon(getPoints()[0],getPoints()[1],3);
        }
    }
}
