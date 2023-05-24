package noapplet.example;

import noapplet.NoApplet;
import javax.swing.*;

/**
 * 
 * @author Dante Lopez
 * To make a counter that increments, decrements, clears, and displays the value.
 */
public class Counter extends NoApplet {
    public Counter() {
         var c = new CounterModel();
         var display = new JTextField(10);
         var in = new JButton("Increment");
         var de = new JButton("Decrement");
         var clr = new JButton("Clear");
         
         // not allow changes to be made to the display box
         display.setEditable(false);
         add(new JLabel("Value:"));
         // add new display, in, de, and clr in this specific order
         add(display);
         add(in);
         add(de);
         add(clr);
         // Make the value a string due to display only taking in a string
         display.setText(Integer.toString(c.value()));
         // Center the displayed String(Number)
         display.setHorizontalAlignment(JTextField.CENTER);
         
         // Increments if that button is clicked
         in.addActionListener(e -> {
        	c.increment();
            display.setText(Integer.toString(c.value()));
         });
         
         // Decrements if that button is clicked
         de.addActionListener(e -> {
        	 c.decrement();
             display.setText(Integer.toString(c.value()));
         });
         
         // Clears the displayed value if that button is clicked
         clr.addActionListener(e -> {
        	 c.clear();
             display.setText(Integer.toString(c.value()));
         });
    }

    public static void main(String[] args) {
         new Counter().run();
    }
}

class CounterModel {
	private int value;
	
	public int value() {
		return value;
	}
	public void increment() {
		value++;
	}
	public void decrement() {
		value--;
	}
	public void clear() {
		value = 0;
	}
}