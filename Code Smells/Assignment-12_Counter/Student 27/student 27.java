package homework;
import javax.swing.*;

public class Counter extends noapplet.NoApplet{
	
	public Counter() {
		var model = new CounterModel();
		var display = new JTextField(10);
		display.setHorizontalAlignment(JTextField.CENTER);
		display.setEditable(false);
		var button = new JButton("Increment");
		var button2 = new JButton("Decrement");
		var button3 = new JButton("Reset");
		add(new JLabel("Value:"));
		add(display);
		add(button);
		add(button2);
		add(button3);
		display.setText(Integer.toString(model.value()));
		
		button.addActionListener(e->{
			model.increment();
			display.setText(Integer.toString(model.value()));
		});
		button2.addActionListener(e->{
			model.decrement();
			display.setText(Integer.toString(model.value()));
		});
		button3.addActionListener(e->{
			model.reset();
			display.setText(Integer.toString(model.value()));
		});
	}
	
	public static void main(String [] args) {
		new Counter().run();
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
		
		public void reset() {
			value = 0;
		}
	}
}
