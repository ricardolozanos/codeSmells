import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModularBalloonApp extends JPanel implements Balloon, ActionListener {

    public static int WIDTH = 300, HEIGHT = 400;
    private int MIN_DIAMETER = 50, MAX_DIAMETER = 300, diameter = 100;
    private boolean increasing = true;
    private Color balloonColor = new Color(155,255,0);
    private Timer timer;

    public ModularBalloonApp(){
        timer = new Timer(20,this);
        timer.start();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        timer.stop();
    }
    @Override
    public Balloon growingBalloon() {
        ModularBalloonApp app = new ModularBalloonApp(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(super.diameter < MAX_DIAMETER)
                    super.diameter++;
                else super.timer.stop();
            }
        };
        return app;
    }

    @Override
    public Balloon growingShrinkingBalloon() {
        ModularBalloonApp app = new ModularBalloonApp(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(super.increasing){
                    super.diameter++;
                    if(super.diameter > MAX_DIAMETER) super.increasing = false;
                }
                else{
                    super.diameter--;
                    if(super.diameter < MIN_DIAMETER) super.increasing = true;
                }
            }
        };
        return app;
    }
    public void drawBalloon(Graphics g){
        // set color to lime
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawLine(WIDTH/2, HEIGHT/2, WIDTH/2, HEIGHT);
        g.drawOval(WIDTH/2-diameter/2,HEIGHT/2-diameter/2,diameter, diameter);
        g.setColor(balloonColor);
        g.fillOval(WIDTH/2-diameter/2,HEIGHT/2-diameter/2,diameter,diameter);
        repaint();
    }
    @Override
    public void paintComponent(Graphics g){
        drawBalloon(g);
    }
    public Balloon createBalloon(){
        return growingBalloon();
    }
    public static void main(String ... args){
            JFrame frame = new JFrame("Balloon");
            ModularBalloonApp balloons = new ModularBalloonApp();
            frame.setSize(new Dimension(WIDTH,HEIGHT));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.add((ModularBalloonApp)balloons.createBalloon());
            frame.setVisible(true);
    }
}