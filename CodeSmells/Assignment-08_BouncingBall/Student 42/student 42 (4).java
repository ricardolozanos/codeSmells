package noapplet.BouncingBalls;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
@SuppressWarnings("serial")
public class BouncingBalls extends noapplet.AnimationNoApplet {
    private List<Bounceable> balls = new ArrayList<>();
    protected int numOfBalls = 3;
    public BouncingBalls(String[] args) {super(args);}
    @Override
    protected void initAnimation() {
        Random rand = new Random();
        for(int i=0; i<numOfBalls; i++) {
            balls.add(new CircleBall(rand.nextInt(dim.width), rand.nextInt(dim.height), 20, -2,-4, Color.RED, balls));
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // fill the background
        Dimension d = getSize();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, d.width, d.height);
        g.setFont(new Font("Times New Roman", Font.BOLD, 30));
        g.setColor(new Color(128, 255,255));
        g.drawString("Adrian Urquizo", 100, 30);

        for (Bounceable ball : balls) {
            ball.move();
            ball.draw(g);
        }
    }
    public static void main(String[] args) {
        new BouncingBalls(new String[] {"width=400", "height=400"}).run();
    }
}