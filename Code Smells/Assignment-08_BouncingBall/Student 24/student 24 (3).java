package noapplet.example;

import noapplet.Shape;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Jesus Oropeza
 */
public class BouncingBall extends AnimationNoApplet{

    private int radius;
    private int w, h, numBalls;
    private int dx = -2, dy = -4;
    Collision col;
    Random ran = new Random();
    Font font = new Font("Monospaced", Font.BOLD, 25);
    protected java.util.List<Bounceable> ballList = new ArrayList<Bounceable>();
    protected static java.util.List<Color> colors = new ArrayList<>();

    public BouncingBall(String[] args, int numBalls) {
        super(args);
        this.numBalls = numBalls;
        colors.add(Color.RED);
        colors.add(Color.YELLOW);
        colors.add(Color.BLUE);
        colors.add(Color.GREEN);
        colors.add(Color.MAGENTA);
    }

    @Override
    protected void initAnimation() {
        for (int i = 0; i<numBalls; i++){
            int radius = ran.nextInt(50);
            int x = ran.nextInt(radius+10,dim.width-(radius+10) );
            int y = ran.nextInt(radius+10,dim.height-(radius+10) );
            int dx = ran.nextInt(-5, 5);
            if(dx == 0){
                dx = ran.nextInt(-5, 5);
            }
            int dy = ran.nextInt(-5,5);
            if(dy == 0){
                dy = ran.nextInt(-5, 5);
            }
            Color color = colors.get(ran.nextInt(colors.size()));
            ballList.add(new CircleBall(x,y,dx,dy,radius,color, this));
        }
        col = new Collision(ballList);
        w=dim.width;
        h=dim.height;
    }

    /** Display the current time. */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//         fill the background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, dim.width, dim.height);
        g.setColor(Color.WHITE);
        g.drawString(String.format("Jesus Oropeza, Marc Buster"), 10, 450);
        col.detect();
        for(Bounceable b: ballList){
            b.draw(g);
        }
    }
    public static void main(String[] args) {
        new BouncingBall(new String[] {"with=500", "height=500"}, 7).run();
    }
}
