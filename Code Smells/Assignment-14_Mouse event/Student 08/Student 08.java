import noapplet.NoApplet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Counter extends NoApplet {
    public Counter() {
        var model = new CounterModel();
        var display = new JTextField(5);
        display.setHorizontalAlignment(JTextField.CENTER);
        display.setEditable(false);
        var button = new JButton("Increment");
        var button2 = new JButton("Decrement");
        var button3 = new JButton("Reset");
        add(new JLabel("Value:"));
        add(display);
        add(button);
        add(button2);
        add(button3);
        display.setText(Integer.toString(model.val()));

        button.addMouseListener(new MouseAdapter() {
            Color original = button.getBackground();
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.GREEN);
            }
            public void mouseExited(MouseEvent e) {
                button.setBackground(original);
            }
        });

        button.addActionListener(e -> {
            model.increment();
            display.setText(Integer.toString(model.val()));
        });

        button2.addMouseListener(new MouseAdapter() {
            Color original = button2.getBackground();
            public void mouseEntered(MouseEvent e) {
                button2.setBackground(Color.GREEN);
            }
            public void mouseExited(MouseEvent e) {
                button2.setBackground(original);
            }
        });

        button2.addActionListener(e -> {
            model.decrement();
            display.setText(Integer.toString(model.val()));
        });

        button3.addMouseListener(new MouseAdapter() {
            Color original = button3.getBackground();
            public void mouseEntered(MouseEvent e) {
                button3.setBackground(Color.GREEN);
            }
            public void mouseExited(MouseEvent e) {
                button3.setBackground(original);
            }
        });
        button3.addActionListener(e -> {
            model.reset();
            display.setText(Integer.toString(model.val()));
        });
    }
    public static void main(String[] args) {
        new Counter().run();
    }

}

class CounterModel {
    private int val;

    public int val() {
        return val;
    }
    public void increment() {
        val++;
    }

    public void decrement() {
        val--;
    }

    public void reset() {
        val = 0;
    }
}