package noapplet;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {

    @Override
    public void paintComponent(Graphics g){
        Dimension d = getSize();
        g.setColor(Color.black);
        for(int i = 0; i < 16; i++){
            g.drawLine(0,i*(d.width/15),d.width,i*(d.width/15));
            g.drawLine(i*(d.width/15),0,i*(d.width/15),d.width-1);
        }
    }
    public void placeStone(Graphics g, Color color, int x, int y){
        g.setColor(color);
        g.drawOval((x*30)+40,(y*30)+167,20,20);
        g.fillOval((x*30)+40,(y*30)+167,20,20);
    }
}
