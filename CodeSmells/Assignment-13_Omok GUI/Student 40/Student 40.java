package src.noapplet.example;

import javax.swing.*;
import java.awt.*;

public class Omok {
    public Omok() {
        var frame = new JFrame("Omok");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // sample UI
        var panel = new JPanel();
        var display = new JLabel("");
        panel.setPreferredSize(new Dimension(300, 200));
        var playButton = new JButton("Play");
        var humanButton = new JRadioButton("Human");
        var compButton = new JRadioButton("Computer");
        ButtonGroup group = new ButtonGroup();
        group.add(humanButton);
        group.add(compButton);
        panel.add(new JLabel("Select opponent:"));
        panel.add(humanButton);
        panel.add(compButton);
        panel.add(playButton);
        panel.add(display);
        playButton.addActionListener(e -> {
            if(humanButton.isSelected()){
                display.setText("Human was selected!");
            }
            else if (compButton.isSelected()) {
                display.setText("Computer was selected!");
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
