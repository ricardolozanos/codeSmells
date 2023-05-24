import javax.swing.*;
import java.awt.*;

public class Omok extends JFrame {
    public Omok() {
        super("Omok");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(300, 200));

        // sample UI
        var panel = new JPanel();
        var display = new JPanel();
        var buttonPanel = new JPanel();
        var ans = new JPanel();
        var human = new JRadioButton("Human");
        var computer = new JRadioButton("Computer");
        display.add(new JLabel("Select opponent:"));
        display.add(human);
        display.add(computer);
        var playButton = new JButton("Play");
        buttonPanel.add(playButton);
        var ansTxt = new JLabel();
        panel.add(display);
        panel.add(buttonPanel);
        panel.add(ans);
        ans.add(ansTxt);

        setContentPane(panel);
        pack();
        setVisible(true);

        playButton.addActionListener(e-> {
            if(human.isSelected())
                ansTxt.setText("You selected Human mode");
            else if(computer.isSelected())
                ansTxt.setText("You selected Computer mode");
        });
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new Omok());
    }

}
