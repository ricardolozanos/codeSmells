package noapplet.example;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Jesus Oropeza & Dante Lopez
 * Balloon
 * Balloon grows indefinitely
 */

public class Balloon extends noapplet.NoApplet {
    protected Timer timer;
    protected Dimension dim;
    protected int x, y;
    protected int delay = 1;
    protected int grow = 1;
    protected boolean flag = true;

    public Balloon(String[] params){super(params);}

    public void init(){
        dim = getSize();
        timer = new Timer(delay, e -> repaint());
    }
    public void start(){
        timer.start();
    }
    public void stop(){
        timer.stop();
    }
    public void paintComponent(Graphics g){

        grow = grow + 1;
        x = dim.width/2 - grow/2;
        y = dim.height/2 - grow/2;
        g.setColor(Color.BLACK);
        g.fillRect(0,0, dim.width, dim.height);
        g.setColor(Color.GREEN);
        g.fillOval(x, y, grow, grow);
    }
    public static void main(String[] args){
        new Balloon(args).run();
    }
}
