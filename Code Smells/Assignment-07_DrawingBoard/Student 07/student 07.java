package noapplet.example;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class drawingBoard extends AnimationNoApplet {
    protected Timer timer;
    private shape s[] = new shape[3];
    private circle cir;
    private rectangle rec;
    private square Square;


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, dim.width, dim.height);
        g.setFont(new Font("San-serif", Font.BOLD, 15));
        g.setColor(Color.GREEN);
        g.drawOval(4, 5, 50, 40);
        g.setColor(Color.PINK);
        g.fillRect(300, 300, dim.width/2, dim.height/2);
        g.setColor(Color.BLUE);
        g.fillOval(100,200,100,100);



    }

    public static void main(String[] args) {
        new drawingBoard().run();

    }

    @Override
    protected void initAnimation() {
        super.initAnimation();
        shape[] s = new shape[3];
        s[0] = new circle(4, 5, 10, Color.GREEN);
        s[1] = new rectangle(5,10,30,10,Color.GREEN);
        s[2] = new square(350, 250, 40, 40, Color.magenta);

    }


    public abstract class shape extends JFrame {
        protected int x, y;
        protected Color color;

        public abstract void draw(Graphics g);
    }


        public  class circle extends shape {
            int diameter;


            public circle(int x, int y, int diameter, Color color) {
                this.x = x;
                this.y = y;
                this.diameter = diameter;
                this.color = color;
            }

            public void draw(Graphics g) {
                g.setColor(color);
                g.fillOval(x, y, diameter, diameter);
            }
        }

        public class square extends shape {
          int  size, size2;


            public square(int x, int y, int size, int size2, Color color) {
                this.x = x;
                this.y = y;
                this.size = size;
                this.size2 = size2;
                this.color = color;
            }

            public void draw(Graphics g) {
                g.setColor(color);
                g.fillRect(x, y, size, size2);
            }

        }

        public class rectangle extends shape{
            int width, height;


            public rectangle(int x, int y, int width, int height, Color color) {
                this.x = x;
                this.y = y;
                this.width = width;
                this.height = height;
                this.color = color;
            }

            public void draw(Graphics g) {
                g.setColor(color);
                g.drawRect(x, y, width, height);
            }
        }
}
