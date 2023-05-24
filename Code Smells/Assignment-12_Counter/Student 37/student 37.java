package noapplet;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Counter extends NoApplet {
public Counter() {
	var model=new CounterModel();
	var display=new JTextField(10);
	var button=new JButton("Increment");
	var decrement=new JButton("Decrement");
	var toZero=new JButton("Reset");
	add(new JLabel("Value:"));
	add(display);
	add(button);
	add(decrement);
	add(toZero);
	display.setHorizontalAlignment(JTextField.CENTER);
	display.setText(Integer.toString(model.value()));
	display.setEditable(false);
	button.addActionListener(e ->{
		//System.out.println("Button clicked!");
		model.increment();
		display.setText(Integer.toString(model.value()));

	});
	decrement.addActionListener(e ->{
		model.decrement();
		display.setText(Integer.toString(model.value()));
	});
	toZero.addActionListener(e ->{
		model.toZero();
		display.setText(Integer.toString(model.value()));
	});
	
	
}
public static void main(String [] args) {
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
	public void toZero() {
		value=0;
	}
}