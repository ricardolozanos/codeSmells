package mouseExcercise;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;

public class MouseExercise {

	    public MouseExercise() {
	        var frame = new JFrame("Counter");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        var panel = new JPanel();
	        panel.setPreferredSize(new Dimension(300, 50));
	        panel.add(new JLabel("Value: "));
	        var display = new JTextField(10);
	        display.setEditable(false);
	        var button = new JButton("Increment");
	        var currentColor = button.getBackground();
	        button.addMouseListener(new MouseAdapter() {
	        	
	        	@Override
				public void mouseEntered(MouseEvent e) {
					
					button.setBackground(Color.RED);
	        		
	        	}
	        	
	        	@Override
				public void mouseExited(MouseEvent e) {
					button.setBackground(currentColor);
				}
	        	
	        });
	        panel.add(display);
	        panel.add(button);

	        frame.setContentPane(panel);
	        frame.pack();
	        frame.setVisible(true);
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> new MouseExercise());
	    }


}
