package noapplet.Files;

import java.awt.*;

public class Circle extends Shapes{

    //Used the super keyword to call x, y and c for the color
    public Circle(int x, int y, Color c){
        super(x,y,c);
    }

    public void draw(Graphics g){
        g.setColor(getC());
        g.drawOval(50,50,50,50);
    }

}

