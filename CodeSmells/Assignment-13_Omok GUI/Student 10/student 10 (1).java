package omok;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Omok {
    public Omok() {
        var frame = new JFrame("Omok");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        var panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 200));
        
        var selection = new JPanel();
        var control = new JPanel();
        var display = new JPanel();
        
        selection.add(new JLabel("Select opponent: "));
        
        JRadioButton human = new JRadioButton( "Human");
        JRadioButton computer = new JRadioButton( "Computer");
        ButtonGroup group = new ButtonGroup();
        group.add(human);
        group.add(computer);
        selection.add(human);
        selection.add(computer);
        
        
        JLabel selected = new JLabel();
        display.add(selected);
        
        
        var button = new JButton("Play");
        control.add(button);
        button.addActionListener(e -> {
        	String mode="";
			//System.out.println("Button click");
        	if(human.isSelected()) {
        		mode = "Human selected!";
        	}
        	if(computer.isSelected()) {
        		mode = "Computer selected!";
        	}
        	selected.setText(mode);
        	 
        	});
        
        panel.add(selection);
        panel.add(control);
        panel.add(display);
        
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new Omok());
    }
}
