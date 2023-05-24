import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

class BouncingBalls extends JPanel {
    private ArrayList<Ball> balls = new ArrayList<Ball>();
    public void addBall(Ball ball) {
        balls.add(ball);
    }
    @Override
    public void paintComponent(Graphics g) { 
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
        for (int i = 0; i < balls.size(); i++) {
            Ball ball1 = balls.get(i);
            int x1 = ball1.getX();
            int y1 = ball1.getY();
            int radius1 = ball1.getRadius();
            int vx1 = ball1.getVx();
            int vy1 = ball1.getVy();
            x1 += vx1;
            y1 += vy1;
            for (int j = i + 1; j < balls.size(); j++) {
                Ball ball2 = balls.get(j);
                int x2 = ball2.getX();
                int y2 = ball2.getY();
                int radius2 = ball2.getRadius();
                int vx2 = ball2.getVx();
                int vy2 = ball2.getVy();
                if (Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)) <= radius1 + radius2) {
                    ball1.setVx(vx2);
                    ball1.setVy(vy2);
                    ball2.setVx(vx1);
                    ball2.setVy(vy1);
                }
                if (x2 < radius1 || x2 > getWidth() - radius1) {
                    vx2 = -vx2;
                }
                if (y2 < radius1 || y2 > getHeight() - radius1) {
                    vy2 = -vy2;
                }
            }

            if (x1 < radius1 || x1 > getWidth() - radius1) {
                vx1 = -vx1;
            }
            if (y1 < radius1 || y1 > getHeight() - radius1) {
                vy1 = -vy1;
            }
            ball1.setX(x1);
            ball1.setY(y1);
            ball1.setVx(vx1);
            ball1.setVy(vy1);
            Color color = ball1.getColor();
            g.setColor(color);
            g.fillOval(x1 - radius1, y1 - radius1, radius1 * 2, radius1 * 2);
        }
    } 
  }