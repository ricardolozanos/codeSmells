import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Balloon extends JPanel implements ActionListener {
    final private Timer timer;
    private int  x = 250;
    private int y = 250;
    private int width = 1;
    private int height = 1;
    private boolean shrink = false;
    Balloon(){
        this.setPreferredSize(new Dimension(500,500));
        timer = new Timer(10,this);
        timer.start();
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public Boolean getShrink(){
        return shrink;
    }
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
    }
    public void setShrink(Boolean shrink){
        this.shrink = shrink;
    }
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setPaint(Color.orange);
        graphics2D.fillOval(x,y,width,height);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        width += 1;
        height += 1;

        x = 250 - width/2;
        y = 250 - height/2;
        repaint();
    }
}
