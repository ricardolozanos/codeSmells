package src.noapplet.example;
import java.awt.*;
import java.awt.geom.Area;

public interface Bounceable {
    void checkCollision(Bounceable ball);
    Area getArea();
    void bounce();
    void draw(Graphics g);


}

