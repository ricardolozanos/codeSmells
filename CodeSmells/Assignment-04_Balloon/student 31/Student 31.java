package noapplet.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class animation {

    public static void main(String[] args) {
        new animation();
    }

    public animation() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {


                JFrame frame = new JFrame("Francisco Rodriguez");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new circleanimation());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class circleanimation extends JPanel {

        private int x = 0;
        private int y = 100;
        private int radius = 10;
        private int xDelta = 10;

        public circleanimation() {
            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    x += xDelta;
                    radius += 2;
                    if (x + (radius * 2) > getWidth()) {
                        x = getWidth() - (radius * 2);
                        //radius +=2;
                        xDelta *= -1;
                        radius =0;
                        radius -= 2;
                    } else if (x < 0) {
                        x = 0;
                        //radius += 2;
                        xDelta *= -1;
                        radius =0;
                        radius -= 2;
                    }
                    repaint();
                }
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0,400 , 400);
            g.setColor(new Color(155, 0, 255));
            g.fillOval(x, y - radius, radius * 2, radius * 2);
            g.setFont(new Font("San-serif", Font.BOLD, 24));
            g.setColor(new Color(155, 0,255));
            g.drawString("Francisco Rodriguez", 100, 300);

        }
    }

}


