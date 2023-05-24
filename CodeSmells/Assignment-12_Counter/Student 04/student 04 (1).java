package noapplet.assignments;

import noapplet.NoApplet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Counter extends NoApplet implements ActionListener {
    private int counterValue = 0;
    private JLabel valueLabel;
    private JTextField data;

    public Counter(){

        data = new JTextField(5);
        JButton incrementButton = new JButton("Increment");
        incrementButton.addActionListener(this);
        add(incrementButton);

        valueLabel = new JLabel("Value: ");
        add(valueLabel);

        data.setText(Integer.toString(counterValue));
        data.setEditable(false);
        data.setHorizontalAlignment(JTextField.CENTER);
        add(data);

        JButton decrementButton = new JButton("Decrement");
        decrementButton.addActionListener(this);
        add(decrementButton);

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        add(clearButton);
        
        
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Increment")) {
            counterValue++;
            data.setText(Integer.toString(counterValue));
        }
        if(e.getActionCommand().equals("Decrement")){
            counterValue--;
            data.setText(Integer.toString(counterValue));
        }
        if(e.getActionCommand().equals("Clear")){
            counterValue = 0;
            data.setText(Integer.toString(counterValue));
        }
    }

    public static void main(String[] args) {
        new Counter().run();
    }
}
