import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;


import java.awt.Color;


public class Counter extends NoApplet {
    public Counter(){

        var model = new CounterModel();
        var display = new JTextField(10);
        display.setHorizontalAlignment(JTextField.CENTER); // Center display
        display.setEditable(false);  // make display non-editable
        JButton butnIncr = new JButton("Increment");//increment button
        JButton butnDecr = new JButton("Decrement");//decement button
        JButton butnRest = new JButton("Reset");// reset button
        add(new JLabel("Value:"));
        add(display);
        add(butnIncr);
        add(butnDecr);
        add(butnRest);
        display.setText(""+ model.getValue() );
        butnIncr.addActionListener(e -> {
            model.increment();
            display.setText(""+ model.getValue() );

        });
        butnDecr.addActionListener(e -> {
            model.decrement();
            display.setText(""+ model.getValue() );

        });
        butnRest.addActionListener(e -> {
            model.clear();
            display.setText(""+ model.getValue() );

        });


        butnIncr.addMouseListener(new MouseInputAdapter() {
            Color mousColor;
            public void mouseEntered(MouseEvent e){
                mousColor = butnIncr.getBackground();
                butnIncr.setBackground(Color.GREEN);
            }
            public void mouseExited(MouseEvent e){
                butnIncr.setBackground(mousColor);

            }
        });
        

    }
    public static void main(String[] args){
        new Counter().run();
    }
    
}
class CounterModel{
    private int value;
    public int getValue(){
        return value;
    }
    public void increment(){
        value++;
    }
    public void decrement(){
        value--;
    }
    public void clear(){
        value = 0;
    }

}
