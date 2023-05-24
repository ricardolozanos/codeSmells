package Misc;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class OmokGUI extends JFrame{
    JButton b1;
    JRadioButton human;
    JRadioButton comp;
    JLabel label;

    public OmokGUI(){
        // initialize Frame
        super("Omok");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(300,200));

        // sample UI
        var panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        JPanel headerPanel = new JPanel();
        panel.add(headerPanel);
        headerPanel.add(new JLabel("Select Opponent: "));

        // Radio Buttons for Human and Opponent
        human = new JRadioButton("Human");
        comp = new JRadioButton("Computer");

        // Create Button Group to select only 1
        ButtonGroup group = new ButtonGroup();
        group.add(human);
        group.add(comp);
        human.setSelected(true);
        comp.setSelected(false);

        // add to panel
        headerPanel.add(human);
        headerPanel.add(comp);

        // Middle play button
        JPanel buttonPanel = new JPanel();
        panel.add(buttonPanel);
        b1 = new JButton("Play");
        headerPanel.setMaximumSize(headerPanel.getPreferredSize());
        buttonPanel.add(b1);

        // Text option 1
        JPanel textPanel = new JPanel();
        panel.add(textPanel);
        JLabel screenText = new JLabel("Human Selected!");
        buttonPanel.setMaximumSize(buttonPanel.getPreferredSize());
        textPanel.add(screenText);
        textPanel.setVisible(false);

        b1.addActionListener(e -> {
            textPanel.setVisible(true);
            if(human.isSelected())
                screenText.setText("Human Selected!");
            else
                screenText.setText("Computer Selected!");
        });

        // Sets up Frame
        setContentPane(panel);
        pack(); // size frame
        setVisible(true); // show it
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new OmokGUI());
    }
}
