package noapplet.Files;

import java.awt.*;

public class Rectangle extends Shapes{

    //Used the super keyword to call x, y and c for the color
    public Rectangle(int x, int y, Color c){
        super(x,y,c);
    }

    public void draw(Graphics g){
        g.setColor(getC());
        g.drawRect(100,100,100,100);
    }
}
