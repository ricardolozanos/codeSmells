import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Balloon2 extends JPanel implements ActionListener{
    Timer timer;
    int x = 250;
    int y = 250;
    int width = 1;
    int height = 1;
    boolean shrink = false;
    Balloon2(){
        this.setPreferredSize(new Dimension(500,500));
        timer = new Timer(10,this);
        timer.start();
    }
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.GREEN);
        g2D.fillOval(x,y,width,height);
        if(width > 500){
            shrink = true;
        }
        if(width <= 0){
            shrink = false;
        }
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(shrink){
            width -= 1;
            height -= 1;
        }
        else {
            width += 1;
            height += 1;
        }
        x = 250 - width/2;
        y = 250 - height/2;
        repaint();
    }
}
