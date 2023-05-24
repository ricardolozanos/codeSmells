import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
