import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class GUI {

    public GUI() {

        JFrame frame = new JFrame();
        JLabel label = new JLabel("Select Opponent:");
        JButton button = new JButton("Start");

        JPanel radioPanel = new JPanel(new GridLayout(0, 1));


        JRadioButton personButton = new JRadioButton("Person");
        JRadioButton computerButton = new JRadioButton("Computer");

        ButtonGroup group = new ButtonGroup();
        group.add(personButton);
        group.add(computerButton);

        radioPanel.add(personButton);
        radioPanel.add(computerButton);

        JPanel mainPanel = new JPanel(new GridLayout(0, 1));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 50, 100));
        mainPanel.add(label);
        mainPanel.add(radioPanel);
        mainPanel.add(button);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Omok");
        frame.pack();
        frame.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (personButton.isSelected()) {
                    JOptionPane.showMessageDialog(null, "You selected Person.");
                } else if (computerButton.isSelected()) {
                    JOptionPane.showMessageDialog(null, "You selected Computer.");
                } else {
                    JOptionPane.showMessageDialog(null, "Please select an option.");
                }
            }
        });
    }

    public static void main(String[] args) {
        new GUI();
    }
}
