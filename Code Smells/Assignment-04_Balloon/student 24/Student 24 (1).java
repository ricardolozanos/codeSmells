package noapplet.example;

import javax.swing.*;
import java.awt.*;

/**
 * Jesus Oropeza & Dante Lopez
 * Balloon2
 * Balloon grows and shrinks
 */
public class Balloon2 extends Balloon{
    public Balloon2(String[] params) {super(params);}

    public void paintComponent(Graphics g){
        if (flag || grow == 1){
            grow = grow + 1;
            flag = true;
        }
        if (grow == dim.width || !flag){
            flag = false;
            grow = grow - 1;
        }
        x = dim.width/2 - grow/2;
        y = dim.height/2 - grow/2;
        g.setColor(Color.BLACK);
        g.fillRect(0,0, dim.width, dim.height);
        g.setColor(Color.GREEN);
        g.fillOval(x, y, grow, grow);
    }
    public static void main(String[] args){
        new Balloon2(args).run();
    }
}
