import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class omokGUI{
    public omokGUI(){
        var frame = new JFrame("Omok");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // sample UI
        var panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 200));
        panel.add(new JLabel("Select Opponent:"));

        // Create radio buttons
        JRadioButton humanButton = new JRadioButton("Human");
        JRadioButton computerButton = new JRadioButton("Computer");

        // Use button group
        ButtonGroup selection = new ButtonGroup();
        selection.add(humanButton);
        selection.add(computerButton);

        // Add radio buttons to the panel
        panel.add(humanButton);
        panel.add(computerButton);

        // Create a play button
        JButton playButton = new JButton("Play");
        
        // Create a JLabel for displaying the selected option
        JLabel selectedOptionLabel = new JLabel("");
        panel.add(selectedOptionLabel);

        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = humanButton.isSelected() ? "Human" : "Computer";
                selectedOptionLabel.setText("You selected: " + selectedOption);
            }
        });

        // Add play button to the panel
        panel.add(playButton);

        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new omokGUI());
    }
}
