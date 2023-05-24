package noapplet.example.Counter;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

import noapplet.NoApplet;

public class Counter extends NoApplet {

	public Counter() {
		try {
			UIManager.setLookAndFeel(
			        UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		var model = new CounterModel();
		
		var display = new JTextField(10);
		var button = new JButton("Increment");
		var button2 = new JButton("Decrement");
		var button3 = new JButton("Reset");
		display.setEditable(false);
		//display.setLocation(300, 180);
		//display.setAlignmentX(CENTER_ALIGNMENT);
		add(new JLabel ("Value"));
		add(display);
		add(button);
		add(button2);
		add(button3);
		display.setText(Integer.toString(model.value()));
		
		button.addActionListener(e -> {
			model.increment();
			display.setText(Integer.toString(model.value()));
			});
		
		Color originColor = button.getBackground();
		button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent e) {
		        button.setBackground(Color.GREEN);
		    }

		    public void mouseExited(java.awt.event.MouseEvent e) {
		        button.setBackground(originColor);
		    }
		});
		
		button2.addActionListener(e -> {
			model.decrement();
			display.setText(Integer.toString(model.value()));
			});
		button3.addActionListener(e -> {
			model.reset();
			display.setText(Integer.toString(model.value()));
			});
		
	}
	
	
	public static void main(String[] args) {
		new Counter().run();
	}
}

class CounterModel{
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
	
	public int reset() {
		return value=0;
	}
}
