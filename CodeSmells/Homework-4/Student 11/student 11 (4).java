import javax.swing.*;
import java.awt.*;

public class Main{
    public static void main(String ... args){
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(300,400));
//        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        BoardPanel p = new BoardPanel();
        frame.add(new JPanel(),BorderLayout.NORTH);
        frame.add(new JPanel(),BorderLayout.EAST);
        frame.add(new JPanel(),BorderLayout.WEST);
        frame.add(new JPanel(),BorderLayout.SOUTH);
        frame.add(p,BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
