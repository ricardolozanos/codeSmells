package omokThings;

import java.awt.*;

class Stone extends Board {
    Color color;
    int posX;
    int posY;

    public Stone(Color color, int posX, int posY){
        this.color = color;
        this.posX = posX;
        this.posY = posY;
    }

    public void stoneX(int x){
        this.posX = x;
    }
    public void stoneY(int y){
        this.posY = y;
    }

    public void drawStone(Graphics g){
        g.setColor(color);
        g.drawOval(posX, posY, 30,30);
    }

}
