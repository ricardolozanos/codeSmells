import noapplet.NoApplet;

import javax.swing.*;
import java.awt.*;

public class ModularBalloonApp extends NoApplet {

    protected int x, y;
    protected Timer timer;
    protected int balloon = 1;

    public ModularBalloonApp(String[] params) {
        super(params);
    }
    protected ModularBalloonApp createBalloon() {
        return this;
    }

    public void init() {
        timer = new Timer(10, e -> repaint());
    }
    public void start() {
        timer.start();
    }
    public void stop() {
        timer.stop();
    }
    protected void paintComponent(Graphics g) {
        Dimension dim = getSize();
        balloon += 1;
        x = dim.width/2 - balloon/2;
        y = dim.height/2 - balloon/2;
        g.setColor(Color.white);
        g.fillRect(0,0, dim.width, dim.height);
        g.setColor(Color.GREEN);
        g.fillOval(x, y, balloon, balloon);

    }



    public static void main(String[] args) {
        new ModularBalloonApp(new String[] {"width=350", "height=350"}).run();
    }
}
