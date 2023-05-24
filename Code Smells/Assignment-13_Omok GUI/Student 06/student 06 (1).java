import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Omok {
    public Omok() {
        var frame = new JFrame("Omok");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // sample UI
        var panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 200));
        panel.add(new JLabel("Select Opponent:"));
        String[] optns = {"Human", "Computer"};
        JComboBox<String> opps = new JComboBox<String>(optns);
        JButton play = new JButton("Play");
        JLabel selected = new JLabel();
        play.addActionListener(e -> {
            String oppType = (String) opps.getSelectedItem();
            if (Objects.equals(oppType, "Human")) {
                selected.setText("Human Selected!");
            } else if (Objects.equals(oppType, "Computer")) {
                selected.setText("Computer Selected!");
            }
        });
        panel.add(opps);
        panel.add(play);
        panel.add(selected);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new Omok());
    }
}
