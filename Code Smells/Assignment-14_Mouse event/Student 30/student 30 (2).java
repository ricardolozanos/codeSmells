package noapplet.Files;

import noapplet.NoApplet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Counter extends NoApplet {

    public Counter(){
        var model = new CounterModel();
        var display = new JTextField(5);
        /*
        From the java docs you can set the display to be non-editable
        by calling the setEditable method and setting it to false which
        comes for the JTextComponent class
         */
        display.setEditable(false);
        var button = new JButton("Increment");
        var buttonTwo = new JButton("Decrement value");
        var buttonThree = new JButton("Reset value");
        add(new JLabel("Value:"));
        add(display);
        add(button);
        add(buttonTwo);
        add(buttonThree);

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent b){
                //Set hover color to blue for the increment button
                button.setBackground(Color.BLUE);
            }

            public void mouseExited(MouseEvent b){
                //Just set to null when the mouse if not hovered to turn back to original color
                button.setBackground(null);
            }
        });

        /**
         * Use the lambda expression to increment the value
         * and convert it to string
         */
        button.addActionListener(e -> {
            System.out.println("The value was incremented");
            model.incrementValue();
            display.setText(Integer.toString(model.getValue()));
        });
        /**
         * Use the lambda expression to decrement the value
         * and convert it to string
         */
        buttonTwo.addActionListener(e -> {
            System.out.println("The value was decremented");
            model.decrementValue();
            display.setText(Integer.toString(model.getValue()));
        });
        /**
         * Use the lmbda expression to reset the value to 0
         * and convert it to string
         */
        buttonThree.addActionListener(e -> {
            System.out.println("The value was reset");
            model.reset();
            display.setText(Integer.toString(model.getValue()));
        });

    }

    public static void main (String [] args){
        new Counter().run();
    }
}