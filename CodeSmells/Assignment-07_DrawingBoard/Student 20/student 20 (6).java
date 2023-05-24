import java.awt.*;

public class Circle extends Shape{
    public Circle(){
        super();
    }
    public Circle(String shape,int x, int y, int width, int height, Color color){
        super(shape, x,y, width, height, color);
    }

    //Setters

    //Getters

    //Methods
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x,y,width,height);
    }
}
