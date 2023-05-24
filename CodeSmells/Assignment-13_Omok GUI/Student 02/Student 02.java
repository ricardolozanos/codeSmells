package noapplet.OmokGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import noapplet.NoApplet;

public class OmokGUI extends JPanel{
    static String human = "Human";
    static String computer = "Computer";
    static String current = "None";
    public OmokGUI() {
        var frame = new JFrame("Omok");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        var panel = new JPanel();
        panel.setLayout(new BorderLayout());
        var display = new JPanel();
        display.setLayout(new GridLayout(0, 1));

        JRadioButton humanButton = new JRadioButton("Human");
        humanButton.setMnemonic(KeyEvent.VK_B);
        humanButton.setActionCommand("Human");
        humanButton.setSelected(true);

        JRadioButton computerButton = new JRadioButton("Computer");
        computerButton.setMnemonic(KeyEvent.VK_C);
        computerButton.setActionCommand("Computer");

        JButton play = new JButton("Play");

        JLabel text = new JLabel();

        display.add(play);
        display.add(text);

        ButtonGroup group = new ButtonGroup();
        group.add(humanButton);
        group.add(computerButton);

        humanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                current = e.getActionCommand();
            }
        });
        computerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                current = e.getActionCommand();
            }
        });

        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("           " + current + " Selected");
                repaint();
            }
        });

        JPanel radioPanel = new JPanel(new GridLayout(1, 0));
        radioPanel.add(humanButton);
        radioPanel.add(computerButton);

        panel.add(radioPanel, BorderLayout.NORTH);
        panel.add(display, BorderLayout.SOUTH);

        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);




    }

    public static void main(String[] args) {
        new OmokGUI();
    }
}
