package noapplet.example;

import noapplet.NoApplet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Counter extends NoApplet {

    public Counter(){
        var model = new CounterModel();
        var display = new JTextField(10);
        display.setEditable(false);
        var button = new JButton("Increment");
        var buttonOriginalColor = button.getBackground();        //gets the OG color of the button
        var minusButton = new JButton("Decrease");
        var minusOriginalColor = minusButton.getBackground();        //gets the OG color of the button
        var resetButton = new JButton("Reset");
        var resetOriginalColor = resetButton.getBackground();        //gets the OG color of the button
        button.addMouseListener(new java.awt.event.MouseAdapter() { //changes color of the increment button
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(Color.GREEN);
            }

            public void mouseExited(MouseEvent evt) {
                button.setBackground(buttonOriginalColor);
            }
        });
        minusButton.addMouseListener(new java.awt.event.MouseAdapter() { //changes color of the decrease button
            public void mouseEntered(MouseEvent evt) {
                minusButton.setBackground(Color.MAGENTA);
            }

            public void mouseExited(MouseEvent evt) {
                minusButton.setBackground(minusOriginalColor);
            }
        });
        resetButton.addMouseListener(new java.awt.event.MouseAdapter() { //changes color of the reset button
            public void mouseEntered(MouseEvent evt) {
                resetButton.setBackground(Color.RED);
            }

            public void mouseExited(MouseEvent evt) {
                resetButton.setBackground(resetOriginalColor);
            }
        });
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

    @Override
    protected void painComponent(Graphics g) {

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
