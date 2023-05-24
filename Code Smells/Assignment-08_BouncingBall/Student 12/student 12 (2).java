import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BallsGUI {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Bouncing Balls");
    BouncingBalls test = new BouncingBalls( ); 
    Ball ball1 = new Ball(50,100,15,5,8 ,Color.pink);
    Ball ball2 = new Ball(100,50,15,5,5 ,Color.red);
    Ball ball3 = new Ball(200,100,15,6,5 ,Color.green);
    Ball ball4 = new Ball(150,200,15,5,5 ,Color.orange);
    test.addBall(ball1); 
    test.addBall(ball2);
    test.addBall(ball3);
    test.addBall(ball4);
    frame.add(test);
    frame.setSize(new Dimension(400,400));
    frame.setVisible(true);
    Timer timer = new Timer(20, new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        test.repaint();
      }
    });
    timer.start();
  }
}