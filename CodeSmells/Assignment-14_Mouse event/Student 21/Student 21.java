package noapplet.example;

import noapplet.NoApplet;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

/**
 * 
 * @author Dante Lopez
 * To make a counter that increments, decrements, clears, and displays the value.
 */
public class Counter extends NoApplet {
    public Counter() {
    	JFrame Frame = new JFrame("Counter");
    	Frame.setSize(600, 100);
    	Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    	var c = new CounterModel();
        var display = new JTextField(10);
        var in = new JButton("Increment");
        var de = new JButton("Decrement");
        var clr = new JButton("Clear");
        var col = new ButtonGroup();
        
        Color defCol = in.getBackground();
        
 		in.addMouseListener(new MouseAdapter() {
 			
 			@Override
 			public void mouseEntered(MouseEvent e) {
 				in.setBackground(Color.GREEN);
 			}
 			
 			@Override
 			public void mouseExited(MouseEvent e) {
 				in.setBackground(defCol);
 			}
 		
 		});
        
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
