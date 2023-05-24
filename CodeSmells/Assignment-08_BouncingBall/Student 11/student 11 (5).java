import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

public class BouncingBall extends JPanel implements Bounceable, ActionListener {
    static final int HEIGHT = 600, WIDTH = 400;
    ArrayList<CircleBall> balls = new ArrayList<>();
    HashSet<String> locations = new HashSet<>();
    public BouncingBall(int ballCount, int ballRadius){
        this.setPreferredSize(new Dimension(HEIGHT,WIDTH));
        for(int i = 1; i <= ballCount; i++){
            /**
             * while(true){
             *      int posX = (int)(Math.random() * HEIGHT) + radius;
             *      int posY = (int)(Math.random() * WIDTH) + radius;
             *      if locations contains "posX+posY" :
             *          continue
             *
             *      balls.add(new CircleBall(radius))
             *      balls.setStartingPosition(posX,posY);
             */
            // TODO : didn't have time to implement a real physics collusion
            // https://en.wikipedia.org/wiki/Elastic_collision
            CircleBall b = new CircleBall(ballRadius);
            b.setStartingPosition((int)(Math.random() * HEIGHT ) + ballRadius, (int)(Math.random() * WIDTH ) + ballRadius);
            balls.add(b);
        }
        Timer t = new Timer(10,this);
        t.start();
    }
    public BouncingBall(int ballCount){
        this(ballCount,25);
    }
    public void actionPerformed(ActionEvent e){
        for (int i = 0; i < balls.size(); i++) {
            CircleBall ball1 = balls.get(i);
            for (int j = i+1; j < balls.size(); j++) {
                CircleBall ball2 = balls.get(j);
                double distance = Math.sqrt(Math.pow(ball1.posX - ball2.posX, 2) + Math.pow(ball1.posY - ball2.posY, 2));
                if (distance < (ball1.radius + ball2.radius / 2)) {
                    // Balls have collided, update their velocities
                    int tempDX = ball1.dX;
                    int tempDY = ball1.dY;
                    ball1.dX = ball2.dX;
                    ball1.dY = ball2.dY;
                    ball2.dX = tempDX;
                    ball2.dY = tempDY;
                }
            }
            if (ball1.posX < ball1.radius || ball1.posX > WIDTH - ball1.radius) {
                ball1.dX = -ball1.dX;
            }
            if (ball1.posY < ball1.radius || ball1.posY > HEIGHT - ball1.radius) {
                ball1.dY = -ball1.dY;
            }
            ball1.posX += ball1.dX;
            ball1.posY += ball1.dY;
        }
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        // paint background
        g.fillRect(0,0,WIDTH,HEIGHT);
        balls.forEach(e -> e.paintComponent(g));
        repaint();
        revalidate();
    }

}
