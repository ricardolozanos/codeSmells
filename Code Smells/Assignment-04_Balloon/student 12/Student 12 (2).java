package noapplet.example;
import noapplet.NoApplet;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Balloon2 extends NoApplet {
    private Timer timer;
    private int ballonSize;
    public int width = 400;
    public int height = 400;
    public boolean reachedEdge = false;
    public boolean currBallonColor = false;
    public Balloon2(String[] params) {
        timer = new Timer(1, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!reachedEdge){
                    ballonSize+=1;
                }else{
                    ballonSize-=1;
                }

                if (ballonSize == width) {
                    reachedEdge = true;
                } else if (ballonSize == -1) {
                    reachedEdge = false;
                    currBallonColor = !currBallonColor;
                }
                repaint();
            }
        });
        timer.start();
    }
    public static void main(String[] args) {
        new Balloon2(new String[] {"width=400", "height=400"}).run();
    }
    protected void paintComponent(Graphics g) {
        Color[] ballonColor = {new Color(255, 215,0), new Color(0, 144, 255)};
        Dimension d = getSize();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, d.width, d.height);
        g.setFont(new Font("San-serif", Font.BOLD, 24));
        g.setColor(ballonColor[currBallonColor ? 1: 0 ]);
        g.fillOval(width/2 - ballonSize/2, height/2 - ballonSize/2, ballonSize, ballonSize);
    }
    public void start(){
        timer.start();
    }
    public void stop(){
        timer.stop();
    }

}