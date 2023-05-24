import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Counter {
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
			private Color pastColor = button.getBackground();
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				button.setBackground(Color.GREEN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				button.setBackground(pastColor);
			}
        });
        panel.add(display);
        panel.add(button);

        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private MouseListener mouseEntered() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Counter());
    }
}
