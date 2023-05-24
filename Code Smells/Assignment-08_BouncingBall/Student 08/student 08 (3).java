
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class BouncingBall extends AnimationNoApplet {
    private int x, y;
    private int dx = -2, dy = -4;
    private int radius;
    private Color color;
    private static java.util.ArrayList<Bounceable> balls;

    private collision cols;

    @Override
    public void initAnimation() {
        balls = new ArrayList<>();
        balls.add(new CircleBall(100,100,dx,dy,25,Color.red,this));
        balls.add(new CircleBall(250,250,10,-5,25,Color.red, this));
        balls.add(new CircleBall(200,100,5,5,25,Color.red, this));
        cols = new collision(balls);
    }

    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, dim.width, dim.height);

        cols.col();
        for(Bounceable b: balls) {
            b.draw(g);
        }

        g.setColor(Color.WHITE);
        g.drawString("Marc Buster and Jesus Oropeza", 90, 35);
    }

    public static void main(String[] args) {
        new BouncingBall().run();
    }

}
