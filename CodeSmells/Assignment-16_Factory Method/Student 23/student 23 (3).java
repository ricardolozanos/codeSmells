package noapplet.Balloon;

import noapplet.NoApplet;
import java.awt.*;
import javax.swing.Timer;

    public class GrowingBalloon extends NoApplet implements Balloon {
        protected Dimension dim;
        protected int position,size;
        protected int pos_offset = 1;
        protected int size_offset = 2;
        protected int delay = 100;
        protected Timer timer;

        public GrowingBalloon() {
            timer = new Timer(1000, event -> repaint());
        }

        public GrowingBalloon(String[] params) {
            super(params);
        }

        public void paintComponent(Graphics g) {

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
    }


