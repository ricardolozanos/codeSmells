package noapplet.example;

import java.awt.*;

abstract class Ball implements Bounceable{

    private Color color;
    private int radius;
    private int x, y;
    private int dx, dy;

    protected Ball(Color color, int radius, int x, int y, int dx, int dy){
        this.color = color;
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }
    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x){
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {

    }

    @Override
    public int getDX() {
        return dx;
    }

    @Override
    public void setDX(int dx) {

    }

    @Override
    public int getDY() {
        return dy;
    }

    @Override
    public void setDY(int dy) {

    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {

    }
    public int getRadius() {
        return radius;
    }
}
