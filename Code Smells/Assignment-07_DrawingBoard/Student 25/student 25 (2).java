package noapplet.example;
import java.awt.*;


public class shape {
    int x;
    int y;
    Color color;

    public Shape(int x, int y, Color color){
        this.x=x;
        this.y=y;
        this.color=color;
    }
    public void circle(int radius, Graphics g){
        g.setColor(this.color);
        g.fillOval(this.x, this.y, radius, radius);

    }
    public void triangle(int h, int w, Graphics.g){
        g.setColor(set.color);
        g.drawPolygon(new int[] {x, x + 10, x + 20}, new int[] {y, y - 80, y}, 3);

        
    }
    public void square(int radius, Graphics g){
        g.setColor(set.color);
        g.draw Rect(this.x, this.y, h, w);
        
    }
    public void name(Graphics g){
        g.setColor(set.color);
        g.drawString("Victor Orozco", x, y);
        
    }
    

    
}
