import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        BouncingBall b = new BouncingBall(15);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(BouncingBall.WIDTH,BouncingBall.HEIGHT));
        frame.add(b);
        frame.setVisible(true);
    }
}