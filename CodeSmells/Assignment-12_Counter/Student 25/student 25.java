import javax.swing.*;

public class counter extends NoApplet{
    public counter() {
        var model = new counterModel();
        var display = new JTextField(10);
        var button = new JButton("Increment");
        add(new JLabel("Value:"));
        add(display);
        add(button);

        display.setText(Integer.toString(model.value()));

        button.addActionListener(e ->){
            System.out.println("Button clicked");
        });
    }
    public static void main(String[] args){
        new.counter().run();
    }
}
class counterModel {
    private int value;
    public int value() {
        return value;

    }
    public void increment(){
        value++;
    }
}
