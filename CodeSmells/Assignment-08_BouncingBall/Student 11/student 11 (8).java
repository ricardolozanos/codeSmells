import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Ball extends JPanel implements Bounceable {
    protected int posX, posY,
            dX, dY,
            radius;
    Color color;
    Ball(int radius){
        this.radius = radius;
        this.color = Color.WHITE;
        // initial velocity
        this.dX = (int)(Math.random() * 7) + 1;
        this.dY = (int)(Math.random() * 7) + 1;
//        this.dX = 5;
//        this.dY = 5;
        if(Math.random() > .5)
            this.dX = -this.dX;
        if(Math.random() > .5)
            this.dY = -this.dY;
    }
    Ball(int radius, Color color){
        this(radius);
        this.color = color;
    }
    public void setStartingPosition(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }
    public void invertVelocity(){
        this.posX += this.dX;
        this.posY += this.dY;
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(this.color);
        g.fillOval(posX,posY,radius,radius);
        repaint();
        revalidate();
    }

}