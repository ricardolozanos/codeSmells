package guiboard.modelgui;

import noapplet.NoApplet;

import java.awt.*;

/** Model for Stone Piece. */

public class Stone extends NoApplet implements Drawer{
    private int dx;
    private int dy;
    private Color color;

    public Stone(int x, int y, Color color){
        this.dx = x;
        this.dy = y;
        this.color = color;
    }

    public Stone(String[] args){
        super(args);
    }
    /** Draws a Stone Piece.*/

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(dx,dy,20,20);
    }
}
