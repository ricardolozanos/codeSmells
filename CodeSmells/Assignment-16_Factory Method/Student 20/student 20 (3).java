import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GrowingBalloon extends Balloon {
    GrowingBalloon(){ super(); }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setPaint(Color.orange);
        graphics2D.fillOval(getX(),getY(),getWidth(),getHeight());
    }
}
