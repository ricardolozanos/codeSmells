package noapplet.example;
import noapplet.NoApplet;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Balloon extends NoApplet {
    private Timer timer;
    private int ballonSize;
    public int width = 400;
    public int height = 400;
    public Balloon(String[] params) {
        timer = new Timer(1, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ballonSize += 1;
                repaint();
            }
        });
        timer.start();
    }
    public static void main(String[] args) {
        new Balloon(new String[] {"width=400", "height=400"}).run();
    }
    protected void paintComponent(Graphics g) {
        Color ballonColor = new Color(255, 215,0);
        Dimension d = getSize();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, d.width, d.height);
        g.setFont(new Font("San-serif", Font.BOLD, 24));
        g.setColor(ballonColor);
        g.fillOval(width/2 - ballonSize/2, height/2 - ballonSize/2, ballonSize, ballonSize);
    }
    public void start(){
        timer.start();
    }
    public void stop(){
        timer.stop();
    }

}
