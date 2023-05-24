package noapplet.example;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class main extends AnimationNoApplet {
    protected Timer timer;
    private Sun sun;
    private planet mars;
    private planet blueP;
    private moon bluePMoon;
    private moon marsMoon;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, dim.width, dim.height);
        g.setFont(new Font("San-serif", Font.BOLD, 15));
        g.setColor(Color.GREEN);
        g.drawString(" Braulio Bracamontes", 30, 40);
        g.setColor(Color.WHITE);
        g.fillOval(2, 3, 4, 4);
        g.fillOval(5, 75, 4, 4);
        g.fillOval(2, 42, 4, 4);
        g.fillOval(7, 32, 4, 4);
        g.fillOval(8, 4, 4, 4);
        g.fillOval(28, 6, 4, 4);
        g.fillOval(300, 45, 4, 4);
        g.fillOval(43, 243, 4, 4);
        g.fillOval(75, 256, 4, 4);
        g.fillOval(235, 132, 4, 4);
        g.fillOval(53, 456, 4, 4);
        g.fillOval(234, 234, 4, 4);
        g.fillOval(56, 453, 4, 4);
        g.fillOval(90, 125, 4, 4);
        g.fillOval(75, 389, 4, 4);
        g.fillOval(43, 476, 4, 4);
        g.fillOval(165, 90, 4, 4);
        g.fillOval(98, 199, 4, 4);
        g.fillOval(450, 78, 4, 4);
        g.fillOval(420, 345, 4, 4);
        g.fillOval(390, 235, 4, 4);
        g.fillOval(256, 482, 4, 4);
        g.fillOval(45, 325, 4, 4);
        g.fillOval(23, 190, 4, 4);
        g.fillOval(89, 210, 4, 4);
        g.fillOval(289, 425, 4, 4);
        g.fillOval(123, 170, 4, 4);
        g.fillOval(230, 280, 4, 4);
        g.fillOval(127, 164, 4, 4);
        g.fillOval(145, 250, 4, 4);
        g.fillOval(199, 350, 4, 4);
        g.fillOval(356, 450, 4, 4);
        g.fillOval(65, 472, 4, 4);
        g.fillOval(38, 380, 4, 4);
        g.fillOval(92, 299, 4, 4);
        g.fillOval(350, 300, 4, 4);
        g.fillOval(320, 350, 4, 4);
        g.fillOval(310, 400, 4, 4);
        g.fillOval(360, 320, 4, 4);
        g.fillOval(420, 350, 4, 4);
        g.fillOval(450, 200, 4, 4);
        g.fillOval(400, 150, 4, 4);



        sun.paint(g);
        mars.paint(g);
        blueP.paint(g);
        bluePMoon.paint(g);
        marsMoon.paint(g);
        // check if moving
        int newX = mars.calX();
        int newY = mars.calY();
        mars.x = newX;
        mars.y = newY;
        mars.angle += 1;

        int blueX = blueP.calX();
        int blueY = blueP.calY();
        blueP.x = blueX;
        blueP.y = blueY;
        blueP.angle += 2;

        int pinkMoonX = bluePMoon.calxMoon();
        int pinkMoonY = bluePMoon.calyMoon();
        bluePMoon.x = pinkMoonX;
        bluePMoon.y = pinkMoonY;
        bluePMoon.angle += 8;

        int greenMoonX = marsMoon.calXMoon();
        int greenMoonY = marsMoon.calYMoon();
        marsMoon.x = greenMoonX;
        marsMoon.y = greenMoonY;
        marsMoon.angle += 8;

    }

    public static void main(String[] args) {
        new main().run();
    }

    @Override
    protected void initAnimation() {
        super.initAnimation();
        sun = new Sun((dim.width / 2) - 25, (dim.height / 2) - 25, 120, Color.YELLOW);
        mars = new planet(dim.width / 2, dim.height / 2, 150, 40, 17, sun, Color.RED);
        blueP = new planet(dim.width / 2, dim.height / 2, 60, 10, 12, sun, Color.BLUE);
        bluePMoon = new moon(blueP.calX(), blueP.calY(), 4, 15, 30, Color.magenta, blueP);
        marsMoon = new moon(mars.calX(), mars.calY(), 4, 3, 30, Color.GREEN, mars);



        timer = new Timer(50, e -> repaint());
        timer.start();

    }

    public class planet {
        private int x, y, diameter, distance, angle;
        private Sun sun;
        private Color color;

        public planet(int x, int y, int distance, int angle, int diameter, Sun sun, Color color) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.angle = angle;
            this.diameter = diameter;
            this.sun = sun;
            this.color = color;
        }

        public void paint(Graphics g) {
            g.setColor(color);
            g.fillOval(x, y, diameter, diameter);
        }

        private int calX() {
            // dim: dimension of this planet
            return (int) (((sun.x) + 25) + distance * Math.cos(Math.toRadians(angle))); // angle in degrees (0-360)
        }

        private int calY() {
            // dim: dimension of this planet
            return (int) (((sun.y) + 25) + distance * Math.sin(Math.toRadians(angle))); // angle in degrees (0-360)
        }
    }

    public class Sun {
        public int x, y, diameter;
        private Color color;

        public Sun(int x, int y, int diameter, Color color) {
            this.x = x;
            this.y = y;
            this.diameter = diameter;
            this.color = color;
        }

        public void paint(Graphics g) {
            g.setColor(color);
            g.fillOval(x, y, diameter / 2, diameter / 2);
        }
    }

    public class moon {
        public int x, y, diameter, distance, angle;
        private planet mars;
        private Color color;

        public moon(int x, int y, int diameter, int distance, int angle, Color color, planet mars) {
            this.x = x;
            this.y = y;
            this.mars = mars;
            this.distance = distance;
            this.angle = angle;
            this.diameter = diameter;
            this.color = color;
        }

        private int calxMoon() {
            // dim: dimension of this planet
            return (int) (((blueP.calX()) + 4) + distance * Math.cos(Math.toRadians(angle))); // angle in degrees (0-360)
        }

        private int calyMoon() {
            // dim: dimension of this planet
            return (int) (((blueP.calY() + 4)) + distance * Math.sin(Math.toRadians(angle))); // angle in degrees (0-360)
        }

        private int calXMoon() {
            // dim: dimension of this planet
            return (int) (((mars.calX())) + (mars.distance / 4) * Math.cos(Math.toRadians(angle))); // angle in degrees (0-360)
        }

        private int calYMoon() {
            // dim: dimension of this planet
            return (int) (((mars.calY())) + (mars.distance / 4) * Math.sin(Math.toRadians(angle))); // angle in degrees (0-360)
        }

        public void paint(Graphics g) {
            g.setColor(color);
            g.fillOval(x, y, diameter, diameter);
        }
    }
    public void start() {
        timer.start();
    }

    // Stop the animation timer
    public void stop() {
        timer.stop();
    }
}
