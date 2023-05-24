package noapplet.example;

import noapplet.NoApplet;
import javax.swing.*;
import java.awt.*;


public class OmokGUI extends NoApplet{
    public OmokGUI(){
        var panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 100));
        var display = new JPanel();
        var control = new JPanel();


        display.add(new JLabel("Select opponent: "));
        var human = new JRadioButton("Human");
        var computer = new JRadioButton("Computer");
        display.add(human);
        display.add(computer);

        var playButton = new JButton("Play");
        control.add(playButton);

        panel.add(display);
        panel.add(control);
        var output = new JLabel("");
        panel.add(output);
        add(panel);

        playButton.addActionListener(e -> {
            if(human.isSelected() && computer.isSelected()){
                output.setText("Not valid! Select only one!");
            } else if(computer.isSelected()){
                output.setText(computer());
            }else if(human.isSelected()){
                output.setText(human());
            }else{
                output.setText("No selection.");
            }
        });

    }
    public String human(){return "Human selected!";}
    public String computer(){return "Computer selected!";}

    public static void main(String[] args) {
        new OmokGUI().run();
    }
}
