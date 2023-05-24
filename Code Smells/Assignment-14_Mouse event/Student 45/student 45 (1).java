package proj.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Counter2 {
    public Counter2(){
        var model = new CounterModel2();
        var frame = new JFrame("Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var panel = new JPanel();
        panel.setPreferredSize(new Dimension(300,50));
        panel.add(new JLabel("Value: "));
        var display = new JTextField(10);
        display.setEditable(false);
        var button = new JButton("Increment");
        button.addActionListener(e -> {//lambda notation
            //System.out.println("button clicked");
            model.increment();// value++
            display.setText(Integer.toString(model.value()));
        });
        button.addMouseListener(new ColorChange());
        panel.add(display);
        panel.add(button);

        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Counter2());

    }
}
class ColorChange extends MouseAdapter{
    public ColorChange(){
    }
    @Override
    public void mouseEntered(MouseEvent e){
        JButton button = (JButton) e.getSource();
        button.setBackground(Color.GREEN);
    }
    @Override
    public void mouseExited(MouseEvent e){
        JButton button = (JButton) e.getSource();
        button.setBackground(null);
    }

}

class CounterModel2{
    private int value;
    public int value(){
        return value;
    }
    public void increment(){value++;}
}
