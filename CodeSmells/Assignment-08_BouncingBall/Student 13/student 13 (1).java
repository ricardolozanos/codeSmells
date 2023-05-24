package noapplet.example;

import java.awt.*;

public abstract class Ball implements Bounceable{
    private Color color;
    private int[] position;
    private int dx;
    private int dy;
    public Ball(Color color, int[] position, int dx, int dy){
        this.color = color;
        this.position = position;
        this.dx = dx;
        this.dy = dy;
    }
    public Ball(int[] position){
        this.setColor(Color.RED);
        this.setDx(2);
        this.setDy(2);
        this.setPosition(position);
    }
    public int[] getNextPosition(){
        return new int[] {position[0] + this.dx, position[1] + this.dy};
    }
    public Color getColor(){
        return color;
    }
    public int[] getPosition(){
        return position;
    }
    public int getDx(){
        return dx;
    }
    public int getDy(){
        return dy;
    }
    public void setColor(Color color){
        this.color = color;
    }
    public void setPosition(int[] position){
        this.position = position;
    }
    public void setDx(int dx){
        this.dx = dx;
    }
    public void setDy(int dy){
        this.dy = dy;
    }
}
