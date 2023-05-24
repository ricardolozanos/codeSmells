/**
 * 
 */
package omokGui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Counter {
    public Counter() {
        var frame = new JFrame("Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 300));
        panel.add(new JLabel("Value: "));
        var display = new JTextField(10);
        display.setEditable(false);
        var button = new JButton("Increment");
		var button2 = new JButton("Decrement");
		var button3 = new JButton("Reset");
		var model = new CounterModel();
		display.setText(Integer.toString(model.value()));
		
        panel.add(display);
        panel.add(button);
        panel.add(button2);
        panel.add(button3);
        
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
		
		button.addMouseListener(new MouseListener(button));
		button2.addMouseListener(new MouseListener(button2));
		button3.addMouseListener(new MouseListener(button3));

        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Counter());
    }
    
    
}

class MouseListener extends MouseAdapter{
	JButton button;
	
	public MouseListener(JButton button) {
		this.button = button;
	}
	
	public void mouseEntered(MouseEvent e) {
		this.button.setBackground(Color.GREEN);
	}
	
	public void mouseExited(MouseEvent e) {
		this.button.setBackground(UIManager.getColor("button.background"));
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
	
	public void reset() {
		value = 0;
	}
}
