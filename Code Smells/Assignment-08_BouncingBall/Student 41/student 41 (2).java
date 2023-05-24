package noapplet;

import java.awt.*;

public class BouncingBall extends AnimationNoApplet {
    CircleBall b1 = new CircleBall(15,Color.red,400,400);
    CircleBall b2 = new CircleBall(15,Color.GREEN,400,400);
    CircleBall b3 = new CircleBall(15,Color.GREEN,400,400);
    CircleBall b4 = new CircleBall(15,Color.GREEN,400,400);
    CircleBall b5 = new CircleBall(15,Color.GREEN,400,400);
    CircleBall[] b = {b1,b2,b3,b4,b5};
    public void init() {
        super.init();
    }
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 400, 400);
        for (CircleBall ball : b) {
            ball.draw(g,b);
        }
        g.setColor(Color.YELLOW);
        g.drawString("Gary Turner",170,15);
    }
    public static void main(String[] args) {
        new BouncingBall().run();
    }
}
