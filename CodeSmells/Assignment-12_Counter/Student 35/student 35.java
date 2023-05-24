package counter;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;
import noappletE.NoApplet;

public class Counter extends NoApplet {
    public Counter(){
        var model = new CounterModel();
        var display = new JTextField(10);
        display.setEditable(false);
        var buttonI = new JButton("Increment");
        var buttonD = new JButton("Decrement");
        var buttonR = new JButton("Reset");
        var panel = new JPanel();
        panel.setPreferredSize(new Dimension(150,150));
        
        panel.add(new JLabel("value"));
        panel.add(display);
        panel.add(buttonI);
        panel.add(buttonD);
        panel.add(buttonR);
        add(panel);
        panel.setLocation(150,150);
        panel.setBorder(BorderFactory.createEtchedBorder());
        display.setText(Integer.toString(model.value()));

        //Your code here
        
        buttonI.addActionListener(e -> {
            model.increment();
            display.setText(Integer.toString(model.value()));
        });
        buttonD.addActionListener(e -> {
            model.decrement();
            display.setText(Integer.toString(model.value()));
        });
        buttonR.addActionListener(e -> {
            model.reset();
            display.setText(Integer.toString(model.value()));
        });
    }
    public static void main(String[] args){
        new Counter().run();
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
}