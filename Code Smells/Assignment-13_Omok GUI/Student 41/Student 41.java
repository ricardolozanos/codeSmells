package noapplet;

import javax.swing.*;
import java.awt.*;

public class OmokGUI {
    public OmokGUI() {
        var frame = new JFrame("Omok");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // sample UI

        var panel = new JPanel();
        var panelTop = new JPanel();
        var panelMiddle = new JPanel();
        var panelBottom = new JPanel();

        var Human = new JRadioButton("Human",false);
        var Computer = new JRadioButton("Computer",false);
        var Selection = new JLabel("");

        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(300, 200));

        panelTop.add(new JLabel("Select Opponent"));
        panelTop.add(Human);
        panelTop.add(Computer);

        Human.addActionListener(e -> {
            Computer.setSelected(false);
            Human.setSelected(true);
        });
        Computer.addActionListener(e -> {
            Human.setSelected(false);
            Computer.setSelected(true);
        });

        var Play = new JButton("Play");
        panelMiddle.add(Play);
        panelBottom.add(Selection);


        Play.addActionListener(e -> {
            if (Human.isSelected()) {
                Selection.setText("Human Selected");
            }
            if (Computer.isSelected()) {
                Selection.setText("Computer Selected");
            }
        });
        panel.add(panelTop,BorderLayout.NORTH);
        panel.add(panelMiddle,BorderLayout.CENTER);
        panel.add(panelBottom,BorderLayout.SOUTH);
        frame.setContentPane(panel);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new OmokGUI());
    }
}
