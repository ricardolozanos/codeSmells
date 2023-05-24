package noapplet.example;

import noapplet.NoApplet;
import javax.swing.*;

public class Counter extends NoApplet {
    public Counter(){
        var counter = new CounterModel();
        var display = new JTextField(10);
        display.setHorizontalAlignment(JTextField.CENTER); //centers text in widget
        display.setEditable(false); //text is uneditable
        var button = new JButton("Increment");
        var buttonDecrease = new JButton("Decrement");//button to decrement
        var buttonReset = new JButton("Clear");//button to increment
        add(new JLabel("Value:"));
        add(display);
        add(button);
        display.setText(Integer.toString(counter.value()));
        //e -> is shorthand for new ActionListener(){public void action....
        button.addActionListener(e -> {
            counter.increment();
            display.setText(Integer.toString(counter.value()));
        });
        add(buttonDecrease); //action to decrement value
        buttonDecrease.addActionListener(e -> {
            counter.decrement();
            display.setText(Integer.toString(counter.value()));
        });
        add(buttonReset); //action to clear value to 0
        buttonReset.addActionListener(e -> {
            counter.reset();
            display.setText(Integer.toString(counter.value()));
        });


    }

    public static void main(String[] args) {
        new Counter().run();
    }
}
class CounterModel{
    private int value;
    public int value(){
        return value;
    }
    public void increment(){
        value++;
    }
    public void decrement(){ //method to decrement value
        value--;
    }
    public void reset(){ //method to clear value to 0
        value = 0;
    }
}