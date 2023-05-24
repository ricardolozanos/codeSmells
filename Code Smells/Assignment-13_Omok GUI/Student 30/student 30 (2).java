import javax.swing.*;
import java.awt.*;

public class OmokGui {

    public OmokGui(){
        var frame = new JFrame("Omok GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var panel = new JPanel();
        panel.setPreferredSize(new Dimension(300,300));
        panel.add(new JLabel("Choose:"));

        var selection = new ButtonOptions();

        panel.add(selection.person);
        panel.add(selection.computerAi);
        panel.add(selection.button);
        panel.add(selection.message);

        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String [] args){
        javax.swing.SwingUtilities.invokeLater(()->new OmokGui());
    }
}
