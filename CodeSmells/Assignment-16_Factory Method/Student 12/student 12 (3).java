import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GrowingBallon extends NoApplet implements Balloon {
    public Timer timer;
    public int ballonSize;
    public int width = 400;
    public int height = 400;
    public GrowingBallon() {
        super();
    }
    @Override
    protected void paintComponent(Graphics g) {
        Color ballonColor = new Color(255, 215,0);
        Dimension d = getSize();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, d.width, d.height);
        g.setFont(new Font("San-serif", Font.BOLD, 24));
        g.setColor(ballonColor);
        g.fillOval(width/2 - ballonSize/2, height/2 - ballonSize/2, ballonSize, ballonSize);
    }

    @Override
    public Balloon createBalloon(String[] parms) {
        timer = new Timer(1, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resize();
                repaint();
            }
        });
        timer.start();
        return this;
    }

    @Override
    public void resize(){
        ballonSize += 1;
    }

    @Override
    public void start(){
        timer.start();
    }
    @Override
    public void stop(){
        timer.stop();
    }
}
