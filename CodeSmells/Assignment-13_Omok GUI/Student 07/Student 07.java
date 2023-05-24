package noapplet.example;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

public class omokGui extends JFrame {
    String[] gameType = {"Human Game","Computer Game"};//this carries the possible game types.


    public omokGui(){
        super("omokGui");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this is the window panel where everything will be displayed.
        var panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(450, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this contains the comboBox with the options available
        var prompt = new JPanel();
        prompt.add(new JLabel("Select Opponent: "));
        JComboBox comboBox = new JComboBox(gameType);
        prompt.add(comboBox);
        panel.add((prompt),BorderLayout.NORTH);
        //this panel contains the let's play button only
        var play = new JPanel();
        var playButton = new JButton("Let's Play");
        play.add(playButton);
        panel.add((play),BorderLayout.CENTER);
        //this label will take care of printing the selected game type
        var empty = new JLabel();
        panel.add((empty), BorderLayout.SOUTH);

        setContentPane(panel);
        pack();
        setVisible(true);

        playButton.addActionListener(e -> {
           String asnwer = comboBox.getSelectedItem().toString();
           if(asnwer.equalsIgnoreCase(gameType[0])){
               empty.setText(" Human Game");
           }else{
               empty.setText(" Computer Game");
           }
           panel.add((empty),BorderLayout.SOUTH);
        });
    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new omokGui());
    }

}
