package noapplet;

import java.awt.*;

public class Sun{
    //List<Planet> planets = new ArrayList<>();
    Color color = Color.YELLOW;
    int x;
    int y;
    int size;
    public Sun(int x,int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void paintComponent(Graphics g) {
        g.setColor(color);
        g.drawOval(x,y,size,size);
        g.fillOval(x,y,size,size);
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
}
