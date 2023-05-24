import java.awt.*;

public class Sun extends Circle{
    int centerX,centerY;
    public Sun(String name, int radius, Color color, int centerX, int centerY){
        super(name,radius,color);
        this.centerX = centerX;
        this.centerY = centerY;
    }
    int getCenterX(){return centerX;}
    int getCenterY(){return centerY;}
    public void draw(Graphics g){
        super.draw(centerX,centerY,g);
    }
}
