package counter;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SimpleCounter extends noapplet.AnimationNoApplet {
	
	public SimpleCounter() {
		var model = new CounterModel();
		var display = new JTextField(5);
		display.setEditable(false);
		var buttonAdd = new JButton("Increment");
		var buttonSub = new JButton("Decrement");
		var buttonClear = new JButton("Reset");

		add(new JLabel("Value"));
		add(display , BorderLayout.SOUTH);
		add(buttonAdd);
		add(buttonSub);
		add(buttonClear);
		
		buttonAdd.addActionListener(e -> {
			//System.out.println("Increment Button clicked"); 
			model.increment();
			display.setText(Integer.toString(model.value()));
		});
		
		buttonSub.addActionListener(e -> {
			//System.out.println("Decrement Button Clicked");
			model.decrement();
			display.setText(Integer.toString(model.value()));
		});
		
		buttonClear.addActionListener(e -> {
			//System.out.println("Reset Button Clicked");
			model.reset();
			display.setText(Integer.toString(model.value()));
		});
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SimpleCounter().run();
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
	
	public void reset() {
		value = 0;
	}
}