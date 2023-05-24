import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public interface Balloon {
    public void animate();
}

public class GrowingBalloon extends JComponent implements Balloon {
    private int diameter = 20;

    public void animate() {
        diameter++;
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(100, 100, diameter, diameter);
    }
}

public class GrowingAndShrinkingBalloon extends GrowingBalloon {
    private int direction = 1;

    public void animate() {
        if (diameter >= 300 || diameter <= 20) {
            direction *= -1;
        }
        diameter += direction;
        repaint();
    }
}



