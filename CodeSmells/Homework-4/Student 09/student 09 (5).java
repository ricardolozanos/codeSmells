package OmokBoard;
import javax.swing.*;
import java.awt.*;

public class Omok {
    public Omok() {
        var frame = new JFrame("Omok");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String playerString = ("Player vs Player Selected");
        String computerString = ("Computer vs Computer Selected");

        var text = new JTextField(20);
        text.setEditable(false);

        var panel = new JPanel();
        panel.setPreferredSize(new Dimension(600, 600));
        JRadioButton playerButton = new JRadioButton("Player");

        JRadioButton computerButton = new JRadioButton("Computer");

        JButton play = new JButton("Play!");


        ButtonGroup group = new ButtonGroup();
        group.add(playerButton);
        group.add(computerButton);

        panel.add(playerButton);
        panel.add(computerButton);
        panel.add(play);
        panel.add(text);
        play.addActionListener(e -> {
            if(playerButton.isSelected()){
                text.setText(playerString);
                panel.add(text);}
            else{
                text.setText(computerString);
                panel.add(text);
            }
        });


        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }


}


