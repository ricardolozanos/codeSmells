import javax.swing.*;

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

