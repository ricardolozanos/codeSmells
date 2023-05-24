package noapplet.example;

import java.awt.*;

public interface Bounceable {
    public void draw(Graphics g, Dimension dim);
    public int getLeftEdge();
    public int getRightEdge();
    public int getUpEdge();
    public int getDownEdge();
}
