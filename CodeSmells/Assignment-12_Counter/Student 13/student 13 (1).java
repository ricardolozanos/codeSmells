package noapplet.example;

import noapplet.NoApplet;

import javax.swing.*;
import java.awt.*;

public class Counter extends NoApplet {
    public Counter(){
        var panel = new JPanel(new BorderLayout());
        var botPanel = new JPanel();
        var midPanel = new JPanel();
        var model = new CounterModel();
        var display = new JTextField(5);
        var incButton = new JButton("Increment");
        var clearButton = new JButton("Clear");
        var decButton = new JButton("Decrement");
        display.setEditable(false);
        midPanel.add(new JLabel("value"));
        midPanel.add(display);
        midPanel.add(new JLabel("By Tadeo"));
        panel.add(midPanel, BorderLayout.CENTER);
        botPanel.add(incButton);
        botPanel.add(decButton);
        botPanel.add(clearButton);
        panel.add(botPanel, BorderLayout.PAGE_END);
        add(panel, BorderLayout.CENTER);
        display.setText(Integer.toString(model.value()));

        incButton.addActionListener(e -> {
            model.increment();
            display.setText(Integer.toString(model.value()));
        });
        clearButton.addActionListener(e -> {
            model.clear();
            display.setText(Integer.toString(model.value()));
        });
        decButton.addActionListener(e -> {
            model.decrement();
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
        public void clear(){
            value = 0;
        }
        public void decrement(){
            value--;
        }
    }
}