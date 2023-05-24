import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class counter extends NoApplet {
    private final CounterModel counterModel;

    public counter() {
        counterModel = new CounterModel();
        JTextField display = new JTextField(10);
        JButton incrementButton = new JButton("Increment");
        JButton decrementButton = new JButton("Decrement");
        JButton clearButton = new JButton("Clear");
        add(new JLabel("Value:"));
        add(display);
        add(incrementButton);
        add(decrementButton);
        add(clearButton);

        display.setHorizontalAlignment(JTextField.CENTER); // center-aligning the displayed counter value
        display.setText(Integer.toString(counterModel.getValue()));
        display.setEditable(false); // making the displayed counter value non-editable

        incrementButton.addActionListener(e -> {
            counterModel.increment();
            display.setText(Integer.toString(counterModel.getValue()));
        });
        decrementButton.addActionListener(e -> {
            counterModel.decrement();
            display.setText(Integer.toString(counterModel.getValue()));
        });
        clearButton.addActionListener(e -> {
            counterModel.clear();
            display.setText(Integer.toString(counterModel.getValue()));
        });
        incrementButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // set background color to green when mouse enters button
                JButton button = (JButton) e.getSource();
                button.setBackground(Color.GREEN);
                button.setOpaque(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // set background color to default when mouse exits button
                JButton button = (JButton) e.getSource();
                button.setBackground(UIManager.getColor("Button.background"));
                button.setOpaque(false);
            }
        });
    }



    public static void main(String[] args) {
        new counter().run();
    }
}

class CounterModel {
    private int value;

    public int getValue() {
        return value;
    }

    public void increment() {
        value++;
    }

    public void decrement() {
        value--;
    }

    public void clear() {
        value = 0;
    }
}

