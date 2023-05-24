package noapplet.example;

import noapplet.NoApplet;

import javax.swing.*;

public class Counter extends NoApplet {
    public Counter(){
        var cmod = new CounterModel();
        var display = new JTextField(10);
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.CENTER);
        var decbutton = new JButton("-");
        var addbutton = new JButton("+");
        var clr = new JButton("Reset");
        add(new JLabel("Value: "));
        add(decbutton);
        add(display);
        add(addbutton);
        add(clr);
        display.setText(Integer.toString(cmod.getVal()));
        decbutton.addActionListener(e -> {
            System.out.println("Decrease Counter");
            cmod.dec();
            display.setText(Integer.toString(cmod.getVal()));
        });
        addbutton.addActionListener(e -> {
            System.out.println("Increase Counter");
            cmod.inc();
            display.setText(Integer.toString(cmod.getVal()));
        });
        clr.addActionListener(e -> {
            System.out.println("Reset Counter");
            cmod.clear();
            display.setText(Integer.toString(cmod.getVal()));
        });
    }
    public static void main(String[] args){
        new Counter().run();
    }
}
class CounterModel{
    private int val;
    public int getVal(){
        return val;
    }
    public void inc(){
        val++;
    }
    public void dec(){
        val--;
    }
    public void clear(){
        val = 0;
    }
}