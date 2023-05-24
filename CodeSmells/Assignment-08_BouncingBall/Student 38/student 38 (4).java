package noapplet.Bouncing;
import noapplet.AnimationNoApplet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MultipleBouncingBalls extends AnimationNoApplet implements ActionListener {
   private static final int width = 800;
   private static final int height = 800;
   private static final int delay = 15;
   private java.util.List<Ball>balls;
    @Override
    protected void initAnimation(){
        super.initAnimation();
        balls = new ArrayList<>();
        balls.add(new CircleBall(200, 250, 2, 5, Color.RED));
        balls.add(new CircleBall(450, 360, 3, 2, Color.GREEN));
        balls.add(new CircleBall(550, 390, 5, 3, Color.BLUE));
        balls.add(new CircleBall(730, 530, 5, 3, Color.PINK));
        balls.add(new CircleBall(630, 430, 5, 3, Color.ORANGE));
    }
   @Override
   protected void paintComponent(Graphics g){
       super.paintComponent(g);
       g.setColor(Color.BLACK);
       g.fillRect(0, 0, dim.width, dim.height);
       //Draw name
       g.setFont(new Font("San-serif", Font.BOLD, 24)
       );
       g.setColor(Color.YELLOW);
       g.drawString("Jose San Miguel", 310, 740);
       for(Ball b: balls){
           b.draw(g);
       }
   }
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < balls.size(); i++) {
            Ball ball1 = balls.get(i);
            for (int j = i + 1; j < balls.size(); j++) {
                Ball ball2 = balls.get(j);
                if (ball1.intersect(ball2)) {
                    ball1.changeDirection(ball2);
                    ball2.changeDirection(ball1);
                }
            }
            ball1.move();
        }
        repaint();
    }
    public static void main(String[] args)
    {
        new MultipleBouncingBalls().run();
    }
}
