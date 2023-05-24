//import noapplet.NoApplet;

import javax.swing.*;

public class counter extends NoApplet{

    public counter() {
        var count = new counterModel();
        var display = new JTextField(5);
        var buttonIncrement  = new JButton("Increment");
        var buttonDecrement  = new JButton("Decrement");
        var buttonClear  = new JButton("Clear");
        
        display.setAlignmentX(250); // center-aligning the displayed counter value
        display.setAlignmentY(1000);
        display.setText(Integer.toString(count.getValue()));
        display.setEditable(false);
        add(new JLabel("Value:")); //creating GUI
        add(display);
        add(buttonIncrement);
        add(buttonDecrement);
        add(buttonClear);


        buttonIncrement.addActionListener(e-> {
            count.increment();
            display.setText(Integer.toString(count.getValue()));// "e -> {...}" is a JAVA Lambda short hand notation for next comments
        });

        display.setText(Integer.toString(count.getValue()));
        buttonDecrement.addActionListener(e-> {
            count.decrement();
            display.setText(Integer.toString(count.getValue()));// "e -> {...}" is a JAVA Lambda short hand notation for next comments
        });

        display.setText(Integer.toString(count.getValue()));
        buttonClear.addActionListener(e-> {
            count.clear();
            display.setText(Integer.toString(count.getValue()));// "e -> {...}" is a JAVA Lambda short hand notation for next comments
        });
        /*
        button.ActionListener(new ActionListener(){
            @Override
            public void ActionPerformed(ActionEvent e){
                System.out.println("Button clicked!");
            }
        }
         */
    }
    public static void main(String[] args){
        new counter().run();
    }
}

class counterModel{ //this has nothing to do with interface, is just the concept of increment
    private int value;
    public int getValue(){
        return this.value;
    }
    public void increment(){
        this.value++;
    }
    public void decrement(){
        this.value--;
    }
    public void clear(){
        this.value = 0;
    }
}
