import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.event.MouseInputAdapter;

import org.w3c.dom.events.MouseEvent;

import AnimationNoApplet.NoApplet;

public class Counter extends NoApplet{

    //Create counter class
    public Counter(){
        var counter = new CounterModel();
        var display = new JTextField(10);
        //get current color of background
        var color = getBackground();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.CENTER);
        var incrementB = new JButton("Increment");
        //change color of whole app background when mouse is over a button
        incrementB.addMouseListener(new MouseInputAdapter(){
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e){
                setBackground(Color.GREEN);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent e){
                setBackground(color);
            }
        });
        var decrementB = new JButton("Decrement");
        var resetB = new JButton("Reset");
        add(new JLabel("Value:"));
        add(display);
        add(incrementB);
        
        incrementB.addActionListener(e -> {
            counter.increment();
            display.setText(Integer.toString(counter.getValue()));
        });
        add(decrementB);
        decrementB.addActionListener(e -> {
            counter.decrement();
            display.setText(Integer.toString(counter.getValue()));
        });
        add(resetB);
        resetB.addActionListener(e -> {
            counter.reset();
            display.setText(Integer.toString(counter.getValue()));
        });
    }


    public static void main(String[] args){
        //run the counter
        new Counter().run();
    }
}


class CounterModel{
    //Create counter model
    private int value = 0;

    public int getValue(){
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
