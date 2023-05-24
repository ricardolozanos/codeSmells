package examples;
import javax.swing.*;
import java.awt.*;

public class LayoutApp {
    public LayoutApp(){
        var frame = new JFrame("Omok");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var panel = new JPanel();
        var panel2 = new JPanel();
        var panel3 = new JPanel();
        var panel4 = new JPanel();
        var panel5 = new JPanel();

        panel.setLayout(new BorderLayout());
        panel2.setLayout(new BorderLayout());
        panel3.setLayout(new FlowLayout());
        panel4.setLayout(new FlowLayout());
        panel5.setLayout(new FlowLayout());

        JButton playButton = new JButton("Play");
        JRadioButton human = new JRadioButton("Human");
        JRadioButton computer = new JRadioButton("Computer");
        JLabel decidingTXT = new JLabel("");


        playButton.addActionListener(e ->{
            if (human.isSelected()){
                decidingTXT.setText("Human Selected");
            }
            if (computer.isSelected()){
                decidingTXT.setText("Computer Selected");            }
        });

        panel.setPreferredSize(new Dimension(300,300));
        panel.add(panel2, BorderLayout.NORTH);
        panel.add(panel5, BorderLayout.CENTER);
        
        panel5.add(decidingTXT);

        panel2.add(panel3, BorderLayout.NORTH);

        panel3.add(new JLabel("Select Opponent"), BorderLayout.NORTH);
        panel3.add(human);
        panel3.add(computer);

        panel2.add(panel4, BorderLayout.CENTER);
        panel4.add(playButton,BorderLayout.CENTER);




        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> new LayoutApp());
    }


}
