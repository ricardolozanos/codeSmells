package noapplet.BallonAnim;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import noapplet.NoApplet;


public class Balloon extends NoApplet {
    Timer timer;
    int size = 7;
    int offset = 3;

    public BallonAnim (){
        timer = new Timer(100, event -> repaint()); 
    }
    public BallonAnim(String[] params) { 
        super(params);
        timer = new Timer(100, event -> repaint()); 
        
    }
    
    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    protected void paintComponent(Graphics g){
        Dimension d = getSize();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, d.width, d.height);
        g.setColor(Color.GREEN);
        size = size + offset;
        g.fillOval(d.width/2-size/2, d.height/2-size/2, size, size);
    }

public static void main(String[] args ) {
    new BallonAnim(new String [] {"height = 500", "width = 1000"}).run();
}

}



