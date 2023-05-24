import javax.swing.*;
import java.awt.*;

public class Counter extends noapplet.NoApplet {
    public Counter(){
        var model = new CounterModel();
        var display = new JTextField(10);
        setLayout(new BorderLayout());
        display.setEditable(false);
        var buttonInc = new JButton("Increment");
        var buttonDec = new JButton("Decrement");
        var buttonCln = new JButton("Clean");
        add(new JPanel().add(new JLabel("value: ")));
        add(buttonInc,BorderLayout.EAST);
        add(display,BorderLayout.CENTER);
        add(buttonDec,BorderLayout.WEST);
        add(buttonCln,BorderLayout.NORTH);
        display.setText(Integer.toString(model.value()));
        buttonInc.addActionListener(e -> {
            model.increment();
            display.setText(Integer.toString(model.value()));
        });
        buttonDec.addActionListener(e -> {
            model.decrement();
            display.setText(Integer.toString(model.value()));
        });
        buttonCln.addActionListener(e -> {
            model.clean();
            display.setText(Integer.toString(model.value()));
        });
    }
    public static void main(String[]args){
        new Counter().run();
    }
}
class CounterModel{
    private int value;
    public int value(){
        return  value;
    }
    public void increment(){
        value++;
    }
    public void decrement(){ value--;}
    public void clean(){ value=0;}
}
