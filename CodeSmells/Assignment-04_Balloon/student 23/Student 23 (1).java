package noapplet;

import java.awt.*;
import javax.swing.Timer;

public class Balloon extends NoApplet {
    protected Dimension dim;
    protected int position,size;
    protected int pos_offset = 1;
    protected int size_offset = 2;
    protected int delay = 100;
    protected Timer timer;

    public Balloon() {
        timer = new Timer(1000, event -> repaint());
    }

    public Balloon(String[] params) {
        super(params);
    }

    protected void paintComponent(Graphics g) {

        position -= pos_offset;
        size += size_offset;

        g.fillRect(0, 0, dim.width, dim.height);

        g.setColor(Color.RED);
        g.drawOval(position, position, size, size);
        g.fillOval(position, position, size, size);

    }


    public void start(){
        timer.start();
    }

    public void stop(){
        timer.stop();
    }

    public void init() {
        String att = getParameter("delay");
        if (att != null) {
            delay = Integer.parseInt(att);
        }

        // set the initial position of the text
        dim = getSize();
        size = 0;
        position = 250;

        // initialize the animation timer
        timer = new Timer(delay, e -> repaint());
    }



    public static void main(String[] args) {
        new Balloon(new String[] {"width=500", "height=500"}).run();


    }
}
