package noapplet;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Timer;

import java.util.*;
import java.io.*;

public class Counter extends NoApplet {
	
	public Counter() {
		var model = new CounterModel();
		
		var display = new JTextField(10);
		var button = new JButton("Increment");
		add(new JLabel( "Value:"));
		add(display);
		add(button);
		
		display.setText(Integer.toString(model.value()));
		
		button.addActionListener(e -> {
			System.out.println("Button clicked");
			model.increment();
			display.setText(Integer.toString(model.value()));
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
		
	}
}
