package balloon;

import noapplet.NoApplet;

import javax.swing.*;
import java.awt.*;
/**
 *
 */
public class GrowingBalloon extends NoApplet{
    protected Timer timer;
    protected Dimension dim;
    protected Color color = Color.GREEN;
    protected int size;
    /**
     *
     */
    public GrowingBalloon(){}
    /**
     *
     * @param params inherits parameters from NoApplet.
     */
    public GrowingBalloon(String[] params){super(params);}
    @Override
    public void init(){
        dim = getSize();
        size = 10;

        timer = new Timer(50,e -> repaint());
    }
    @Override
    public void start() {
        timer.start();
    }

    @Override
    public void stop() {
        timer.stop();
    }
    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,dim.width,dim.height);
        g.setColor(color);
        g.fillOval((dim.width/2)-(size/2),(dim.height/2)-(size/2),size,size);
        size = size +3;
        if(size >= dim.width){
            size = 10;
        }
    }
    /**
     *
     * @param params standard parameter for main.
     */
    public static void main(String[] params){
        new GrowingBalloon().run();
    }


}
