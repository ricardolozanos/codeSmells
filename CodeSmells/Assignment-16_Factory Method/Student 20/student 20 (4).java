import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GrowingShrinkingBalloon extends Balloon {
    GrowingShrinkingBalloon(){
        super();
    }
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setPaint(Color.orange);
        graphics2D.fillOval(getX(),getY(),getWidth(),getHeight());
        if(getWidth() > 500){
            setShrink(true);
        }
        if(getWidth() <= 0){
           setShrink(false);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(getShrink()){
            setWidth(getWidth() -1);
            setHeight(getHeight()-1);
        }
        else {
            setWidth(getWidth() + 1);
            setHeight(getHeight() + 1);
        }
        setX(250 - getWidth()/2);
        setY(250 - getHeight()/2 );
        repaint();
    }

}
