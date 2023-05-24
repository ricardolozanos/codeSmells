import java.awt.*;

public class Rectangle extends Shape{
    public Rectangle(){
        super();
    }
    public Rectangle(String shape,int x, int y, int width, int height, Color color){
        super(shape, x,y, width, height, color);
    }
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(x,y,width,height);
    }
}
