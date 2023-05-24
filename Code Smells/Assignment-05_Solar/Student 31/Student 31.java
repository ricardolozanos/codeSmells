package noapplet.example;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class solar {

    public static void main(String[] args) {
        new solar();
    }

    public solar() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                JFrame frame = new JFrame("FRANCISCO RODRIGUEZ");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private float degrees = 0;

        public TestPane() {
            Timer timer = new Timer(10, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    degrees += 0.5;
                    repaint();
                }
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(500, 500);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g.setColor(Color.BLACK);
            g.fillRect(0, 0,500 , 500);

            int diameter = Math.min(100, 100);
            int x = 50;
            int y = 50;



            g2d.setColor(new Color(155, 0, 255));
            float innerDiameter = 20;

            Point p = getPointOnCircle(degrees, (diameter / 2f) - (innerDiameter / 2));
            g2d.fillOval(x + p.x - (int) (innerDiameter / 2), y + p.y - (int) (innerDiameter / 2), (int) innerDiameter, (int) innerDiameter);
            g2d.drawString("Francisco Rodriguez", 100, 100);

            diameter = Math.min(200, 200);
            x = 50;
            y = 50;
            innerDiameter = 10;
            p = getPointOnCircle(degrees+=1, (diameter / 2f) - (innerDiameter / 2));
            g2d.setColor(new Color(155, 0, 0) );
            g2d.fillOval(x + p.x-10 - (int) (innerDiameter /2), y + p.y-10 - (int) (innerDiameter/2), (int) innerDiameter, (int) innerDiameter);
            g2d.fillOval(x + p.x-30 - (int) (innerDiameter /-4), y + p.y-30 - (int) (innerDiameter /-4), (int) innerDiameter, (int) innerDiameter);

            diameter = Math.min(300, 300);
            x = 50;
            y = 50;
            innerDiameter = 10;
            p = getPointOnCircle(degrees+=1, (diameter / 2f) - (innerDiameter / 2));
            g2d.setColor(new Color(155, 200, 0) );
            g2d.fillOval(x + p.x - (int) (innerDiameter / 2), y + p.y - (int) (innerDiameter / 2), (int) innerDiameter, (int) innerDiameter);
            int f =x + p.x - (int) (innerDiameter / 2);
            int r=y + p.y - (int) (innerDiameter / 2);

            //p = getPointOnCircle(p.x,p.y);
            //g2d.fillOval(p.x, p.y , (int) innerDiameter, (int) innerDiameter);

            p = getPointOnCircle(x - p.x + (int) (innerDiameter), y - p.y + (int) (innerDiameter ));
            g2d.setColor(new Color(100, 90, 10) );
            g2d.fillOval(x + p.x - (int) (innerDiameter), y + p.y - (int) (innerDiameter), (int) innerDiameter, (int) innerDiameter);

            double rads = Math.toRadians(degrees - 90);
            int xPosy = Math.round((float) (x + Math.cos(rads) * (diameter / 2f) - (innerDiameter / 2)));
            int yPosy = Math.round((float) (y + Math.sin(rads) * (diameter / 2f) - (innerDiameter / 2)));
            p = getPointOnCircle(degrees+=0.5, (diameter / 2f) - (innerDiameter / 2f));
            g2d.setColor(new Color(155, 20, 90) );
            g2d.fillOval(x + p.x - (int) (innerDiameter / 2)+3, y + p.y - (int) (innerDiameter / 2)+3, (int) innerDiameter, (int) innerDiameter);
            //g2d.fillOval(x + p.x - (int) (innerDiameter / 2), y + p.y - (int) (innerDiameter / 2), (int) innerDiameter, (int) innerDiameter);

            p = getPointOnCircle(x + p.x - (int) (innerDiameter), y + p.y - (int) (innerDiameter ));
            g2d.setColor(new Color(0, 90, 90) );
            g2d.fillOval(x + p.x - (int) (innerDiameter / 2), y + p.y - (int) (innerDiameter / 2), (int) innerDiameter, (int) innerDiameter);

            p = getPointOnCircle(x + p.x - (int) (innerDiameter), y + p.y - (int) (innerDiameter ));
            g2d.setColor(new Color(90, 90, 90) );
            g2d.fillOval(x + p.x - (int) (innerDiameter / 2), y + p.y - (int) (innerDiameter / 2), (int) innerDiameter, (int) innerDiameter);

            p = getPointOnCircle(x + p.x - (int) (innerDiameter), y + p.y - (int) (innerDiameter ));
            g2d.setColor(new Color(100, 90, 10) );
            g2d.fillOval(x + p.x - (int) (innerDiameter / 2), y + p.y - (int) (innerDiameter / 2), (int) innerDiameter, (int) innerDiameter);

            g2d.dispose();
        }



        protected Point getPointOnCircle(float degress, float radius) {

            int x = 200;
            int y = 200;

            double rads = Math.toRadians(degress - 90); // 0 becomes the top

            // Calculate the outter point of the line
            int xPosy = Math.round((float) (x + Math.cos(rads) * radius));
            int yPosy = Math.round((float) (y + Math.sin(rads) * radius));

            return new Point(xPosy, yPosy);

        }

    }

}

