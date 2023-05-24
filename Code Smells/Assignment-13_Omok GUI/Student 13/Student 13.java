package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUserInterface extends JFrame {
    public GUserInterface() {
        super("Omok");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(300, 200));

        // sample UI
        var panel = new JPanel(new BorderLayout());
        var selectPanel = new JPanel();
        var bottomPanel = new JPanel(new BorderLayout());
        var playPanel = new JPanel();
        var contentPanel = new JPanel();

        var humanRadio = new JRadioButton("Human");
        var computerRadio = new JRadioButton("Computer");

        var radioGroup = new ButtonGroup();
        radioGroup.add(humanRadio);
        radioGroup.add(computerRadio);

        var modeLabel = new JLabel("Welcome to Omok!");

        var playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (humanRadio.isSelected()){
                    modeLabel.setText("Human selected!");
                }
                else if (computerRadio.isSelected()){
                    modeLabel.setText("Computer selected!");
                }
            }
        });

        panel.add(selectPanel, BorderLayout.NORTH);
        panel.add(bottomPanel, BorderLayout.CENTER);

        selectPanel.add(new JLabel("Select opponent:"));
        selectPanel.add(humanRadio);
        selectPanel.add(computerRadio);

        bottomPanel.add(playPanel, BorderLayout.NORTH);
        bottomPanel.add(contentPanel);

        playPanel.add(playButton);

        contentPanel.add(modeLabel);

        setContentPane(panel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new GUserInterface());
    }
}
