package noapplet.example;

import java.awt.*;

interface Bounceable {
    void paintComponent(Graphics g);
    int getX();
    void setX(int x);
    int getY();
    void setY(int y);
    int getDX();
    void setDX(int dx);
    int getDY();
    void setDY(int dy);
    Color getColor();
    void setColor(Color color);

}
