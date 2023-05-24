package count;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.*;

import java.awt.Color;
import java.awt.event.*;


import noapplet.NoApplet;

public class Counter extends NoApplet {
    Color org = null;
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
        button.addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(MouseEvent e){
                if(org == null){ org = button.getBackground();}
                button.setBackground(Color.GREEN);
                
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(org);
            }
            
        });
        button1.addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(MouseEvent e){
                if(org == null){ org = button.getBackground();}
                button1.setBackground(Color.GREEN);
                
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button1.setBackground(org);
            }
            
        });
        button2.addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(MouseEvent e){
                if(org == null){ org = button.getBackground();}
                button2.setBackground(Color.GREEN);
                
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button2.setBackground(org);
            }
            
        });
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