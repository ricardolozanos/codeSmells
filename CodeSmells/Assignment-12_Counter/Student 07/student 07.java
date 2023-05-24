package noapplet.example;

import noapplet.NoApplet;

import javax.swing.*;

public class Counter extends NoApplet {

    public Counter(){
        var model = new CounterModel();
        var display = new JTextField(10);
        display.setEditable(false);
        var button = new JButton("Increment");
        var minusButton = new JButton("Decrease");
        var resetButton = new JButton("Reset");
        add(button);
        add(new JLabel("Value:"));
        add(display);
        add(minusButton);
        add(resetButton);

        display.setText(Integer.toString(model.value()));
        //check button event / action llistener interface/
        button.addActionListener(e -> {
            model.increment();
            display.setText(Integer.toString(model.value()));
            //System.out.println("button clicked");
        });
        minusButton.addActionListener(e -> {
            model.decrease();
            display.setText(Integer.toString(model.value()));
        });
        resetButton.addActionListener(e -> {
            model.reset();
            display.setText(Integer.toString(model.value()));
        });

    }
    public static void main(String[] args){
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
    public void decrease(){
        value--;
    }
    public void reset(){
        value =0;
    }
}
