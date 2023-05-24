package src.noapplet.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Counter extends NoApplet{

    public Counter(){
        var model = new CounterModel();

        var display = new JTextField(10);
        var buttonInc = new JButton("Increment");
        Color currColor = getBackground();
        buttonInc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setBackground(Color.GREEN);
                //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setBackground(currColor);


            }
        });
        var buttonDec = new JButton("Decrement");
        var buttonClear = new JButton("Clear");
        add(new JLabel("Value:"));
        add(display);
        add(buttonInc);
        add(buttonDec);
        add(buttonClear);
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.CENTER);
        display.setText(Integer.toString(model.getValue()));
        buttonInc.addActionListener(e -> {
            model.increment();
            display.setText(Integer.toString(model.getValue()));

        });
        buttonDec.addActionListener(e -> {
            model.decrement();
            display.setText(Integer.toString(model.getValue()));

        });
        buttonClear.addActionListener(e -> {
            model.clear();
            display.setText(Integer.toString(model.getValue()));

        });



    }
    public static void main(String[] args){
        new Counter().run();
    }

}
class CounterModel{
    private int value;

    public int getValue(){
        return value;
    }
    public void increment(){
        value++;
    }
    public void decrement(){value--;}
    public void clear(){value = 0;}
}
