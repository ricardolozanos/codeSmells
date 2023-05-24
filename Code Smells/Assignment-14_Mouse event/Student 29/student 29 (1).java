package counter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
		
		Color org = buttonAdd.getBackground();

		add(new JLabel("Value"));
		add(display , BorderLayout.SOUTH);
		add(buttonAdd);
		add(buttonSub);
		add(buttonClear);
		
		buttonAdd.addActionListener(e -> {
			model.increment();
			display.setText(Integer.toString(model.value()));
		});
		
		buttonSub.addActionListener(e -> {
			model.decrement();
			display.setText(Integer.toString(model.value()));
		});
		
		buttonClear.addActionListener(e -> {
			model.reset();
			display.setText(Integer.toString(model.value()));
		});
		
		// Mouse Listener to change increment button to green
		buttonAdd.addMouseListener(new MouseAdapter(){
        	
        	@Override 
        	public void mouseEntered(MouseEvent e) {
        		buttonAdd.setBackground(Color.GREEN);
        	}
        	
        	@Override
        	public void mouseExited(MouseEvent e) {
        		buttonAdd.setBackground(org);
        	}
        });

		// Mouse Listener to change Decrement button to red 
		buttonSub.addMouseListener(new MouseAdapter(){
        	
        	@Override 
        	public void mouseEntered(MouseEvent e) {
        		buttonSub.setBackground(Color.RED);
        	}
        	
        	@Override
        	public void mouseExited(MouseEvent e) {
        		buttonSub.setBackground(org);
        	}
        });
		
		// Mouse Listener to change clear button to yellow 
		buttonClear.addMouseListener(new MouseAdapter(){
        	
        	@Override 
        	public void mouseEntered(MouseEvent e) {
        		buttonClear.setBackground(Color.YELLOW);
        	}
        	
        	@Override
        	public void mouseExited(MouseEvent e) {
        		buttonClear.setBackground(org);
        	}
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