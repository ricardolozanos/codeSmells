package noapplet.example;

import javax.swing.*;
import java.awt.*;

public class Omok1 extends JFrame {

    JRadioButton jrb1, jrb2;
    ButtonGroup group;
    JLabel display = new JLabel();

    public Omok1(){
        super("Omok");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        var panel = new JPanel();
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxlayout);
        setPreferredSize(new Dimension(300,300));
        var control = new JPanel();
        var prompt = new JLabel("Select opponent: ");
        var button = new JPanel();
        var result = new JPanel();
        var play = new JButton("Play");
        jrb1 = new JRadioButton("Human");
        jrb2 = new JRadioButton("Computer");
        group = new ButtonGroup();
        control.add(prompt);
        control.add(jrb1);
        control.add(jrb2);
        button.add(play);
        result.add(display);
        group.add(jrb1);
        group.add(jrb2);
        panel.add(control);
        panel.add(button);
        panel.add(result);
        setContentPane(panel);
        pack();
        setVisible(true);

        play.addActionListener(e-> {
            if(jrb1.isSelected()){
                display.setText("Human Selected!");
            }
            else if(jrb2.isSelected()){
                display.setText("Computer Selected!");
            }
        });

    }

    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(()->new Omok1());
    }

}
