package noapplet.example;

import java.awt.*;

interface Bounceable{
    public abstract void draw(Graphics g);
    public int getX();
    public int getY();
    public int getRadius();
    public void flipX();
    public void flipY();
    Color getColor();
}
