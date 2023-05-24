package noapplet;

import java.awt.*;

public class Gomoku extends NoApplet{
    public void paint(Graphics g){
        drawGrid(g);
        placeStone(g,Color.black,6,5);
        placeStone(g,Color.white,5,5);

        g.setFont(new Font("San-serif", Font.BOLD, 24));
        g.setColor(Color.RED);
        g.drawString("Gary Turner", 133, 200);

    }
    public void placeStone(Graphics g, Color color, int x, int y){
        g.setColor(color);
        g.drawOval((x*25)+15,(y*25)+15,20,20);
        g.fillOval((x*25)+15,(y*25)+15,20,20);
    }
    public void drawGrid(Graphics g){
        Dimension d = getSize();
        g.setColor(Color.black);
        for(int i = 0; i <= 16; i++){
            //rows
            g.drawLine(0,i*(d.height/16),d.width,i*(d.height/16));
            //cols
            g.drawLine((d.width/16)*i,0,(d.width/16)*i,d.height);
        }
    }
    public static void main(String[] args) {
    	new Gomoku().run();
    }
}
