import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Counter {
    Color color = Color.ORANGE;
    public Counter() {
        var frame = new JFrame("Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 50));
        panel.add(new JLabel("Value: "));
        var display = new JTextField(10);
        display.setEditable(false);
        var button = new JButton("Increment");

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Color temp = button.getBackground();
                button.setBackground(color);
                color = temp;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Color temp = button.getBackground();
                button.setBackground(color);
                color = temp;
            }
        });

        panel.add(display);
        panel.add(button);

        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Counter());
    }
}
