package noapplet.BallonAnim;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import noapplet.NoApplet;


public class ModularBalloonApp extends NoApplet {
    Timer timer;
    int size = 7;
    int offset = 3;
    drawable ballon;
    Dimension d = getSize();

    public ModularBalloonApp (){
        timer = new Timer(100, event -> repaint());
        getballon(); 
    }
    public ModularBalloonApp(String[] params) { 
        super(params);
        timer = new Timer(100, event -> repaint());
        ballon= getballon();  
        
    }

    public drawable getballon(){
        return new bballon(size, offset);
    }
    
    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    protected void paintComponent(Graphics g){
        d = getSize();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, d.width, d.height);
        ballon.draw(g, d.height, d.width);
        
    }

public static void main(String[] args ) {
    new ModularBalloonApp(new String [] {"height = 500", "width = 1000"}).run();
}

}



