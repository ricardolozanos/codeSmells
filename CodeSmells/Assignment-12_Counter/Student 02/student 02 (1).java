package noapplet.Counter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import noapplet.NoApplet;

public class Counter extends NoApplet
{
    public int value = 0;
    public Counter(){
        var frame = new JFrame("Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var panel = new JPanel();
        panel.setLayout(new GridLayout(0,1));
        var display = new JPanel();
        var control = new JPanel();

        display.add(new JLabel("Value:"));
        JTextField text = new JTextField("  0  ");
        text.setEditable(false);
        display.add(text);


        JButton increment = new JButton("Increment");
        increment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value++;
                text.setText(String.valueOf(value));
                repaint();
            }
        });

        JButton clear = new JButton("Clear");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value = 0;
                text.setText(String.valueOf(value));
                repaint();
            }
        });

        JButton decrement = new JButton("Decrement");
        decrement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value--;
                text.setText(String.valueOf(value));
                repaint();
            }
        });

        control.add(increment);
        control.add(clear);
        control.add(decrement);


        panel.add(display);
        panel.add(control);

        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new Counter();
    }
}
