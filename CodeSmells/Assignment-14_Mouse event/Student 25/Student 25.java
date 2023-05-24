import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mouse extends JFrame {
    private int count = 0;
    private JLabel countLabel;

    public mouse() {
        setTitle("Counter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        countLabel = new JLabel("Value: " + count);
        panel.add(countLabel, BorderLayout.CENTER);


        JButton incrementButton = new JButton("Increment");
        incrementButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                count++;
                countLabel.setText("Value: " + count);
            }
        });

        incrementButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                incrementButton.setBackground(Color.GREEN);
            }

            public void mouseExited(MouseEvent e) {
                incrementButton.setBackground(UIManager.getColor("control"));
            }
        });
        panel.add(incrementButton, BorderLayout.SOUTH);


        add(panel);


        setVisible(true);
    }

    public static void main(String[] args) {
        new mouse();
    }
}
