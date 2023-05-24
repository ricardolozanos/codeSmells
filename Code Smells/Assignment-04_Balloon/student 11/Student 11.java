import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Balloon extends JPanel{
    private static int WIDTH = 300, HEIGHT = 300;
    private static int MIN_DIAMETER = 50, diameter = 100;
    private static boolean increasing = true;
    private static JPanel panel = new JPanel();
    private static Color balloonColor = new Color(155,255,0);

    static class Balloon2 extends Balloon{
        Balloon2(){
            super();
            Timer timer = new Timer(20/*ms*/, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(increasing){
                        diameter ++;
                        if(diameter > WIDTH) increasing = false;
                    }
                    else{
                        diameter --;
                        if(diameter < MIN_DIAMETER) increasing = true;
                    }
                }
            });
            timer.start();
        }
        @Override
        public void paintComponent(Graphics g){
            drawBalloon(g);
        }
    }
    public Balloon(){
        this.setSize(new Dimension(WIDTH,HEIGHT));
        this.setVisible(true);
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
        revalidate();
    }
    @Override
    public void paintComponent(Graphics g){
        drawBalloon(g);
    }
    public static void main(String ... args){
            JFrame frame = new JFrame();
            Balloon2 balloons = new Balloon2();
            frame.setSize(new Dimension(WIDTH,HEIGHT));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.add(balloons);
            frame.setVisible(true);
    }
}