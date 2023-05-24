package noapplet.example;

import javax.swing.*;
import java.awt.*;

/**
 * 
 * @author Dante Lopez
 *	
 */

public class OmokGUI {
    public OmokGUI() {
        var frame = new JFrame("Omok");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var panel = new JPanel();
        var control = new JPanel();
        var con = new ButtonGroup();
        var res = new JPanel();
        JLabel display = new JLabel();
        BoxLayout BL = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(BL);
        var play = new JButton("Play");
        JRadioButton a = new JRadioButton("Human");
        JRadioButton b = new JRadioButton("Computer");
        panel.setPreferredSize(new Dimension(300, 200));
        panel.add(new JLabel("Select Opponent:"));
        panel.add(a);
        panel.add(b);
        con.add(a);
        con.add(b);
        control.add(play);
        res.add(display);
        panel.add(control);
        panel.add(res);
       
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
        
        play.addActionListener(e -> {
        	if(a.isSelected()) {
        		display.setText("Human Selected!");
        	}else if(b.isSelected()) {
        		display.setText("Computer Selected!");
        	}       
        });
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new OmokGUI());
    }
}