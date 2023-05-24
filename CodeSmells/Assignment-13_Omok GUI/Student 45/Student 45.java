package omok;
import javax.swing.*;
import java.awt.*;

public class OmokGui {

    public OmokGui(){
        var frame = new JFrame("Omok");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        var panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(300,200));
        var opponent = new JPanel();
        var select = new JLabel("Select opponent:");
        var human = new JRadioButton("Human");
        var computer = new JRadioButton("Computer");

        var display = new JPanel();
        var play = new JButton("Play");
        var chosen = new JLabel();
        chosen.setVisible(false);
        display.add(play);
        display.add(chosen);

        play.addActionListener(e -> {
            if(human.isSelected()){
                chosen.setText("Human selected!");
            }
            else if(computer.isSelected()){
                chosen.setText("Computer selected!");
            }
            else{
                chosen.setText("None selected.");
            }
            chosen.setVisible(true);
        });

        opponent.add(select);
        opponent.add(human);
        opponent.add(computer);
        panel.add(opponent, BorderLayout.PAGE_START);
        panel.add(display, BorderLayout.CENTER);


        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(() -> new OmokGui());
    }
}
