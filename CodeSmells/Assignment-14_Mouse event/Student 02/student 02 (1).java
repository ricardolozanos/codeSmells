package noapplet.Counter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import noapplet.NoApplet;

public class Counter extends NoApplet
{
    public int value = 0;
    public Counter(){
        var frame = new JFrame("Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var panel = new JPanel();
        panel.setLayout(new GridLayout(0,1));
        var display = new JPanel();
        var control = new JPanel();

        display.add(new JLabel("Value:"));
        JTextField text = new JTextField("  0  ");
        text.setEditable(false);
        display.add(text);


        JButton increment = new JButton("Increment");
        var buttonColor = increment.getBackground();
        increment.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                increment.setBackground(Color.GREEN);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                increment.setBackground(buttonColor);
                repaint();
            }
        });
        increment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value++;
                text.setText(String.valueOf(value));
                repaint();
            }
        });

        JButton clear = new JButton("Clear");
        clear.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                clear.setBackground(Color.GREEN);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                clear.setBackground(buttonColor);
                repaint();
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value = 0;
                text.setText(String.valueOf(value));
                repaint();
            }
        });

        JButton decrement = new JButton("Decrement");
        decrement.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                decrement.setBackground(Color.GREEN);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                decrement.setBackground(buttonColor);
                repaint();
            }
        });
        decrement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value--;
                text.setText(String.valueOf(value));
                repaint();
            }
        });

        control.add(increment);
        control.add(clear);
        control.add(decrement);


        panel.add(display);
        panel.add(control);

        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new Counter();
    }
}
