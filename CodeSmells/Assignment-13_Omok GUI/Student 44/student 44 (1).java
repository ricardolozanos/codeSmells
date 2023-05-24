import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Omoks extends JFrame {
    public Omoks() {
        super("Omoks");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(300, 200));

        // sample UI
        var panel = new JPanel();
        panel.add(new JLabel("Select opponent:"));
        JRadioButton humanButton = new JRadioButton("Human");
        JRadioButton computerButton = new JRadioButton("Computer");
        JButton playButton= new JButton("Play");
        panel.add(humanButton);
        panel.add(computerButton);
        panel.add(playButton);
     
        JLabel messageLabel = new JLabel();
        panel.add(messageLabel);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (computerButton.isSelected()) {
                    messageLabel.setText("Computer Selected");
                } 
                else if(humanButton.isSelected()){
                    messageLabel.setText("Human Selected");
                }
                else {
                    messageLabel.setText("Game started!");
                }
            }
        });

        setContentPane(panel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new Omoks());
    }
}
