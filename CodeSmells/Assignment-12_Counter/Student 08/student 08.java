import noapplet.NoApplet;

import javax.swing.*;

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

        button.addActionListener(e -> {
            model.increment();
            display.setText(Integer.toString(model.val()));
        });

        button2.addActionListener(e -> {
            model.decrement();
            display.setText(Integer.toString(model.val()));
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