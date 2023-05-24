package proj.gui;

import noapplet.NoApplet;

import javax.swing.*;
import java.awt.*;

public class Counter extends NoApplet {
    public Counter(){
        var model = new CounterModel();
        var panel = new JPanel(new BorderLayout());
        var display = new JPanel();
        var button = new JPanel();
        var dis = new JTextField(10);
        //dis(int) becomes non-editable
        dis.setEditable(false);
        //increment, decrement, and clear buttons
        var inc = new JButton("Increment");
        var dec = new JButton("Decrement");
        var clr = new JButton("Clear");
        //value display
        display.add(new JLabel("Value:"));
        display.add(dis);
        //three buttons
        button.add(inc);
        button.add(dec);
        button.add(clr);
        //separate layout for display and button
        panel.add(display, BorderLayout.CENTER);
        panel.add(button, BorderLayout.PAGE_END);
        //puts everything together
        add(panel);
        dis.setText(Integer.toString(model.value()));
        inc.addActionListener(e -> {//lambda notation
            //System.out.println("button clicked");
            model.increment();// value++
            dis.setText(Integer.toString(model.value()));
        });
        dec.addActionListener(e -> {
            model.decrement(); // value--
            dis.setText(Integer.toString(model.value()));
        });
        clr.addActionListener(e -> {
            model.clear_value(); // value = 0
            dis.setText(Integer.toString(model.value()));
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
    public void increment(){value++;}
    public void decrement(){value--;}
    public void clear_value(){value = 0;}
}

