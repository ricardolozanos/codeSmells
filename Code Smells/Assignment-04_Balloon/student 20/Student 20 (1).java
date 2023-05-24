import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Balloon extends JPanel implements ActionListener{
    Timer timer;
    int x = 250;
    int y = 250;
    int width = 1;
    int height = 1;
    Balloon(){
        this.setPreferredSize(new Dimension(500,500));
        timer = new Timer(10,this);
        timer.start();
    }
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.GREEN);
        g2D.fillOval(x,y,width,height);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        width += 1;
        height += 1;
        x = 250 - width/2;
        y = 250 - height/2;
        repaint();
    }
}
