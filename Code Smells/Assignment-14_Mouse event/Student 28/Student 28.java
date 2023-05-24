package noapplet.example;
import noapplet.NoApplet;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.Color;

public class MouseEvent extends NoApplet {
    public MouseEvent(){
        var counter = new Model();
        var display = new JTextField(10);
        display.setHorizontalAlignment(JTextField.CENTER); //centers text in widget
        display.setEditable(false); //text is uneditable
        var button = new JButton("Increment");
        Color original = button.getBackground();
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent me) {
                button.setBackground(Color.MAGENTA);
                button.setOpaque(true);
                button.setBorderPainted(false);
            }
            public void mouseExited(java.awt.event.MouseEvent me) {
                button.setBackground(original);
                button.setOpaque(true);
                button.setBorderPainted(true);
            }
        });
        var buttonDecrease = new JButton("Decrement");//button to decrement
        var buttonReset = new JButton("Clear");//button to increment
        add(new JLabel("Value:"));
        add(display);
        add(button);
        display.setText(Integer.toString(counter.value()));
        //e -> is shorthand for new ActionListener(){public void action....
        button.addActionListener(e -> {
            counter.increment();
            display.setText(Integer.toString(counter.value()));
        });
        add(buttonDecrease); //action to decrement value
        buttonDecrease.addActionListener(e -> {
            counter.decrement();
            display.setText(Integer.toString(counter.value()));
        });
        add(buttonReset); //action to clear value to 0
        buttonReset.addActionListener(e -> {
            counter.reset();
            display.setText(Integer.toString(counter.value()));
        });
    }

    public static void main(String[] args) {
        new MouseEvent().run();
    }
}
class Model{
    private int value;
    public int value(){return value;}
    public void increment(){value++;}
    public void decrement(){value--;}
    public void reset(){value = 0;}
}