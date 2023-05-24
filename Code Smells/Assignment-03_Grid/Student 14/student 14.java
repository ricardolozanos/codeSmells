package noapplet.GridMaker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import noapplet.NoApplet;



public class GridMaker extends NoApplet {

public GridMaker() {
}

public GridMaker(String[] params) {
    super(params);

}

public void paint(Graphics g) {
    Dimension d = getSize();
    g.setColor(Color.lightGray);
    g.fillRect(0, 0, d.width, d.height);
    g.setColor(Color.gray);
    int linex = 0;
    for (int i=0; i<15; i++) {
        linex += d.width/16;
        g.fillRect(linex-2, 0, 4, d.height);
    }
    int liney = 0;
    for (int i=0; i<15; i++) {
        liney += d.height/16;
        g.fillRect(0, liney-2, d.width, 4);
    }
    g.setColor(Color.GREEN);
    g.fillOval(d.width/16-25, d.height/16-25, 50,50);
    g.setColor(Color.MAGENTA);
    g.fillOval(2*d.width/16-25, 2*d.height/16-25, 50,50);
    g.setColor(Color.BLUE);
    g.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
    g.drawString("William Dunlap", 0, liney);
}




public static void main(String[] args) {
    new GridMaker(new String[] {"width=1000", "height=1000"}).run();
}
}