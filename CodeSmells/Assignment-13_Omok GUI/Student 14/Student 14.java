package count;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.*;

import noapplet.NoApplet;

public class Bungo{
    public Bungo(){
    var panel = new JFrame("monkey");
    panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    var panell = new JPanel();
    var panel2 = new JPanel();
    var panel3 = new JPanel();
    var panel4 = new JPanel();
    var panel5 = new JPanel();
    var butg = new ButtonGroup();
    var b1 = new JRadioButton("Human");
    var b2 = new JRadioButton("Machine");
    var b3 = new JButton("Start");
    var l3 = new JLabel();

    panell.setLayout(new BorderLayout());
    panel2.setLayout(new BorderLayout());
    panel5.setLayout(new FlowLayout());
    panel3.setLayout(new FlowLayout());
    butg.add(b1);
    butg.add(b2);
    panel3.add(new JLabel("select mode: "));
    panel3.add(b1);
    panel3.add(b2);
    panel4.add(b3);
    panel5.add(l3);
    panel2.add(panel3, BorderLayout.NORTH);
    panel2.add(panel4);
    panell.add(panel2, BorderLayout.NORTH);
    panell.add(panel5);
    panel.setContentPane(panell);
    panel.pack();
    panel.setVisible(true);


    b3.addActionListener(e -> {if (b1.isSelected()){l3.setText("Vs. Human selected");}else if (b2.isSelected()){l3.setText("Vs. Machine selected");} else{l3.setText("No mode selected");}});

        
    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new Bungo());

    }
}


class Counterm {
int val;

public int getval(){
    return val;
}
public void inc(){
    val++;
}
public void dinc(){
    val--;
}
public void reset(){
    val = 0;
}


}