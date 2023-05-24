package noapplet.Counter;
import noapplet.NoApplet;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Counter extends NoApplet {
    public Counter(){
        var model = new CounterModel();
        var display = new JTextField(10);
        var button1 = new JButton("Increment");
        var button2 = new JButton("Decrement");
        var button3 = new JButton("Clear");
        var panel = new JPanel();

        button1.addMouseListener(new MouseAction(button1));
        button2.addMouseListener(new MouseAction(button2));
        button3.addMouseListener(new MouseAction(button3));

        add(button1);
        add(button2);
        add(button3);

        panel.setLayout(new BorderLayout());
        panel.add(new JLabel("Value:"), BorderLayout.WEST);
        panel.add(display, BorderLayout.CENTER);
        panel.add(new JLabel("Adrian Urquizo"), BorderLayout.SOUTH);
        add(panel);

        display.setText(Integer.toString(model.getValue()));
        display.setEditable(false);

        button1.addActionListener(e -> {
            model.Increment();
            display.setText(Integer.toString(model.getValue()));
        });
        button2.addActionListener(e -> {
            model.Decrement();
            display.setText(Integer.toString(model.getValue()));
        });
        button3.addActionListener(e -> {
            model.Clear();
            display.setText(Integer.toString(model.getValue()));
        });
    }
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        new Counter().run();
    }
}
class CounterModel {
    private int value;
    public int getValue(){return value;}
    public void Increment(){value++;}
    public void Decrement(){
        value--;
    }
    public void Clear(){value = 0;}
}
class MouseAction extends MouseAdapter{
    private JButton button;
    public MouseAction(JButton button) {
        this.button = button;
    }
    @Override
    public void mouseEntered(MouseEvent e){
        button.setBackground(Color.GREEN);
    }
    @Override
    public void mouseExited(MouseEvent e){
        button.setBackground(null);
    }
}