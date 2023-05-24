package noapplet.counter;

import noapplet.NoApplet;

import javax.swing.*;

public class Counter extends NoApplet{

    public Counter() {
        var model = new CounterModel();

        var display = new JTextField(10);
        display.setHorizontalAlignment(JTextField.CENTER);
        display.setEditable(false);
        var incrementButton = new JButton("Increment");
        var decrementButton = new JButton("Decrement");
        var clearButton = new JButton("Clear");
        add(new JLabel("Value:"));
        add(display);
        add(incrementButton);
        add(decrementButton);
        add(clearButton);

        display.setText(Integer.toString(model.value()));

        incrementButton.addActionListener(e -> {
            model.increment();
            display.setText(Integer.toString(model.value()));
        });

        decrementButton.addActionListener(e -> {
            model.decrement();
            display.setText(Integer.toString(model.value()));
        });

        clearButton.addActionListener(e -> {
            model.clear();
            display.setText(Integer.toString(model.value()));
        });

    }

    public static void main(String[] args) {
        new Counter().run();
    }

}

class CounterModel {
    private int value;

    public int value() {
        return value;
    }

    public void increment() {
        value++;
    }

    public void decrement() {
        value--;
    }

    public void clear() {
        value = 0;
    }
}