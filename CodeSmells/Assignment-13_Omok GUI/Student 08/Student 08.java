import javax.swing.*;
import java.awt.*;

public class OmokGUI extends noapplet.NoApplet {
    public OmokGUI() {
        var frame = new JFrame("Omok");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        var panel = new JPanel();
        panel.setPreferredSize(new Dimension(300,200));
        var panelSelect = new JPanel();
        var panelStart = new JPanel();
        var selected = new JPanel();
        var display = new JLabel();
        var butG = new ButtonGroup();
        var human = new JRadioButton("Human");
        var cpu = new JRadioButton("Computer");
        var play = new JButton("Play");


        panelSelect.add(new JLabel("Select Opponent: "));
        butG.add(human);
        butG.add(cpu);
        panelSelect.add(human);
        panelSelect.add(cpu);
        panelStart.add(play);
        selected.add(display);

        panel.add(panelSelect);
        panel.add(panelStart);
        panel.add(selected);

        play.addActionListener(e -> {
            if(human.isSelected()) {
                display.setText("Human Selected");
            }
            if(cpu.isSelected()) {
                display.setText("Computer Selected");

            }
        });

        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new OmokGUI());
    }
}


