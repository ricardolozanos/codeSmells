package noapplet.example;

import java.awt.*;

public interface Bounceable {
	void draw(Graphics g);
	int getX();
	int getY();
	int getdx();
	int getdy();
	int getRadius();
	Color getColor();
	void flipx();
	void flipy();
}
