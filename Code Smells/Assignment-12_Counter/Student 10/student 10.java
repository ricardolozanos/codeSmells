package noapplet.example.Counter;

import javax.swing.*;

import noapplet.NoApplet;

public class Counter extends NoApplet {

	public Counter() {
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
			//System.out.println("Button click");
			model.increment();
			display.setText(Integer.toString(model.value()));
			});
		button2.addActionListener(e -> {
			//System.out.println("Button click");
			model.decrement();
			display.setText(Integer.toString(model.value()));
			});
		button3.addActionListener(e -> {
			//System.out.println("Button click");
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
