package noapplet;

import java.awt.*;

public class Triangle extends Shape{
    public Triangle(int x,int y,int width,int height, Color color,boolean filled){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.filled = filled;
        this.xCorners = xCorners();
        this.yCorners = yCorners();
    }
    public int[] xCorners(){
        int[] xCorners = new int[3];
        xCorners[0] = x;
        xCorners[1] = x+(width/2);
        xCorners[2] = x-(width/2);
        return xCorners;
    }
    public int[] yCorners(){
        int[] yCorners = new int[3];
        yCorners[0] = y-(height/2);
        yCorners[1] = y+(height/2);
        yCorners[2] = y+(height/2);
        return yCorners;
    }
    @Override
    public void draw(Graphics g){
        g.setColor(color);
        g.drawPolygon(xCorners,yCorners,3);
        if(filled){
            g.fillPolygon(xCorners,yCorners,3);
        }
    }
}
