import java.awt.*;
import java.awt.geom.Path2D;
import javax.swing.JPanel;

public class Triangle extends Shape{
    public Triangle(){
        super();
    }
    public Triangle(String shape,int x, int y, int width, int height, Color color){
        super(shape, x,y, width, height, color);
    }

    public void paint(Graphics g) {
        g.drawLine(x,y,x+(height/2),y+height);
        g.drawLine(x+(height/2),y+height,x-(height/2),y+height);
        g.drawLine(x,y,x-(height/2),y+height);
    }
}
