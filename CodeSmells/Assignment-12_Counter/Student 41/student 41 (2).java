package noapplet.Counter;

import noapplet.NoApplet;

import javax.swing.*;
import java.awt.*;
public class Counter extends NoApplet {
    int count = 0;
    public Counter() {
        var frame = new JFrame("Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // sample UI
        var panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 100));

        var display = new JPanel();
        var control = new JPanel();


        JLabel value = new JLabel("Value: ");
        JLabel number = new JLabel(""+count);
        JButton Increment = new JButton("Increment");
        JButton Clear = new JButton("Clear");
        JButton Decrement = new JButton("Decrement");

        Increment.addActionListener(e -> {
            count++;
            number.setText(""+count);
        });
        Clear.addActionListener(e -> {
            count = 0;
            number.setText(""+count);
        });
        Decrement.addActionListener(e -> {
            count--;
            number.setText(""+count);
        });

        display.add(value);
        display.add(number);
        control.add(Increment);
        control.add(Clear);
        control.add(Decrement);

        panel.add(display);
        panel.add(control);

        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void run(){

    }

    public static void main(String[] args) {
        new Counter().run();
    }
}

