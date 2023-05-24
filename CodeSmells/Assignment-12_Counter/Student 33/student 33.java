package noapplet.example;

import noapplet.NoApplet;
import javax.swing.*;
public class Counter extends NoApplet {
    public Counter(){
        var model = new CounterModel();

        var display = new JTextField(10); // get from user //layoutmanagement? buttons on screen (flowlayoutmanager)
        var button = new JButton("Increment");
        var button2 = new JButton("Decrement");
        var button3 = new JButton("Zero");
        add(new JLabel("Value:"));
        add(display);
        add(button);
        add(button2);
        add(button3);

        display.setText(Integer.toString(model.getValue()));
        button.addActionListener(e -> {
            System.out.println("Button clicked!");
            model.increment();
            display.setText(Integer.toString(model.getValue()));
        });

        button2.addActionListener(e -> {
            System.out.println("Button clicked!");
            model.decrement();
            display.setText(Integer.toString(model.getValue()));
        });

        button3.addActionListener(e -> {
            System.out.println("Button clicked!");
            model.zero();
            display.setText(Integer.toString(model.getValue()));
        });
    }
    public static void main(String[] args) {
        new Counter().run();
    }
}

class CounterModel {
    private int value;

    public int getValue() {
        return value;
    }

    public void increment() {
        value++;
    }

    public void decrement() { value--;}

    public void zero() {value = 0;}
}