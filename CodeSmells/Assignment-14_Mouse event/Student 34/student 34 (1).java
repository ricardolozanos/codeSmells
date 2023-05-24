import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class counter {
        public counter() {
            var frame = new JFrame("Counter");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            var panel = new JPanel();
            panel.setPreferredSize(new Dimension(300, 50));
            panel.add(new JLabel("Value: "));
            var display = new JTextField(10);
            display.setEditable(false);
            var button = new JButton("Increment");
            panel.add(display);
            panel.add(button);

            Color orgCol = button.getBackground();

            button.addMouseListener(new MouseAdapter(){
                public void mouseEntered(MouseEvent e){
                    button.setBackground(Color.RED);
                }

                public void mouseExited(MouseEvent e){
                    button.setBackground(orgCol);
                }
            });

            frame.setContentPane(panel);
            frame.pack();
            frame.setVisible(true);
        }




        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> new counter());
        }
    }
