package exercises.OmokUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Omok {
    public Omok() {
        var frame = new JFrame("Omok");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sample UI
        var panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 200));
        panel.add(new JLabel("Select Opponent:"));

        // Create JComboBox object and add options
        var comboBox = new JComboBox<>(new String[] { "Computer", "Human" });
        panel.add(comboBox);

        // Create JButton and add ActionListener to display current selection
        var button = new JButton("Play");
        var selectedOptionLabel = new JLabel("");

        // Create a new panel for the button and label
        var buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.add(button, BorderLayout.CENTER);
        buttonPanel.add(selectedOptionLabel, BorderLayout.SOUTH);

        panel.add(buttonPanel);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) comboBox.getSelectedItem();
                selectedOptionLabel.setText(selectedOption + " selected");
                frame.pack();
            }
        });

        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new Omok());
    }
}
