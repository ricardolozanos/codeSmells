import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;

public class Omok_GUI implements ActionListener{
    private final JLabel opponent_selected;
    private final JComboBox<Object> options_list;

    public Omok_GUI() {
        String[] options = new String[]{"Human", "Computer"};

        opponent_selected = new JLabel();
        options_list = new JComboBox<>(options);

        var frame = new JFrame("Omok");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 200));
        panel.add(new JLabel("Select Opponent:  "));
        panel.add(options_list);

        JButton play_button = new JButton("Play");
        play_button.addActionListener(this);
        panel.add(play_button);

        panel.add(this.opponent_selected);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(Omok_GUI::new);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String opponent = (String) options_list.getSelectedItem();
        if(opponent != null) {
            opponent_selected.setText("You Selected " + opponent + " As Your Opponent!");
        }

    }

}
