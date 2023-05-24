package noapplet.counter;

import noapplet.NoApplet;

import javax.swing.*;

public class Counter extends NoApplet {
    public Counter(){
        var model = new CounterModel();
        var display = new JTextField(10);

        display.setHorizontalAlignment(JTextField.CENTER);
        display.setEditable(false);

        var inc_button = new JButton("Increment");
        var dec_button = new JButton("Decrement");
        var res_button = new JButton("Reset");

        add(new JLabel("value"));
        add(display);
        add(inc_button);
        add(dec_button);
        add(res_button);

        display.setText(Integer.toString(model.value()));

        inc_button.addActionListener(e -> {
            model.increment();
            display.setText(Integer.toString(model.value()));
        });
        dec_button.addActionListener(e -> {
            model.decrement();
            display.setText(Integer.toString(model.value()));
        });
        res_button.addActionListener(e -> {
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
    public void decrement(){
        value--;
    }
    public void reset(){
        value = 0;
    }
}