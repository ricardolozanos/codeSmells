package count;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import noapplet.NoApplet;

public class Counter extends NoApplet {
    public Counter(){
        var count = new Counterm();

        var display = new JTextField(10);
        display.setHorizontalAlignment(JTextField.CENTER);
        display.setEditable(false);
        var button = new JButton("count-up");
        var button1 = new JButton("count-down");
        var button2 = new JButton("count-reset");
        add(new JLabel("Val"));
        add(display);
        add(button);
        add(button1);
        add(button2);




        display.setText(Integer.toString(count.getval()));


        button.addActionListener(e -> {count.inc();  display.setText(Integer.toString(count.getval()));});
        button1.addActionListener(e -> {count.dinc();  display.setText(Integer.toString(count.getval()));});
        button2.addActionListener(e -> {count.reset();  display.setText(Integer.toString(count.getval()));});
        
    }
    
}


class Counterm {
int val;

public int getval(){
    return val;
}
public void inc(){
    val++;
}
public void dinc(){
    val--;
}
public void reset(){
    val = 0;
}


}