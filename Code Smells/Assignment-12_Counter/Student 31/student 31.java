package noapplet.example;

import java.awt.*;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.*;

public class Counter extends JFrame implements ActionListener {
    private JLabel label;
    private JTextField text;
    private JButton hunkIncrease, hunkDecrease, hunkClean;
    private int hunk;
    public Counter() {
        setBackground(Color.BLACK);
        setTitle("Francisco Rodriguez");

        setLayout(new FlowLayout());
        hunk = 0;
        label = new JLabel("Value:");
        text = new JTextField("0", 4);

        hunkIncrease = new JButton("Increase");
        hunkIncrease.setBackground(new Color(120,0,150));

        hunkDecrease = new JButton("Decrease");
        hunkDecrease.setBackground(new Color(120,0,150));

        hunkClean = new JButton("Clear");
        hunkClean.setBackground(new Color(120,0,150));

        hunkIncrease.addActionListener(this);
        hunkDecrease.addActionListener(this);
        hunkClean.addActionListener(this);
        add(label);
        add(text);
        add(hunkIncrease);
        add(hunkDecrease);
        add(hunkClean);

        setBackground(Color.BLACK);
        setSize(400, 200);
        setBackground(Color.BLACK);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == hunkIncrease) {
            hunk++;
            text.setText(String.valueOf(hunk));
            repaint();
        } else if (a.getSource() == hunkDecrease) {
            hunk--;
            text.setText(String.valueOf(hunk));
            repaint();
        } else if (a.getSource() == hunkClean) {
            hunk = 0;
            text.setText(String.valueOf(hunk));
            repaint();
        }
    }

    public static void main(String[] args) {
        new Counter();
    }
}

/*
public class Counter extends JPanel {


    final int hunk = 0;
    int hunk2 = 0;
    public Counter() {
        var frame = new JFrame("Rodriguez Francisco");
        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        var panel = new JPanel();
        var display = new JPanel();
        var control = new JPanel();
        display.add(new JLabel("Value: "));
        display.add(new JTextField(" "+hunk2+" "));
        control.setBackground(new Color(122,0,150));
        control.add(new JButton("Increment"));
        control.setBackground(new Color(122,0,150));
        control.add(new JButton("Clear"));
        control.setBackground(new Color(122,0,150));
        control.add(new JButton("Decrement"));

        panel.setBackground(Color.BLACK);
        panel.add(display);
        panel.add(control);
        frame.add(panel);

        frame.setSize(400,200);
        //f.setLayout(null);
        frame.setVisible(true);


    }
    public int increaseHunk(){
        //getHunk();
        hunk2 = hunk+1;
        return hunk2;
    }
    public int decreaseHunk(){
        //getHunk();
        hunk2 = hunk-1;
        return hunk2;
    }

    public int setZeroHunk(){
        //getHunk();
        hunk2 = hunk;
        return hunk2;
    }

    public static void main(String[] args) {
        new Counter();
    }
}*/




/*
public class Counter {
    public Counter()
    {
        JFrame f= new JFrame("Francisco Rodriguez");
        JPanel panel=new JPanel();
        panel.setBounds(0,0,400,400);
        panel.setBackground(Color.BLACK);
        JButton button1=new JButton("Button 1");
        button1.setBounds(50,100,80,30);
        button1.setBackground(new Color(122,0,150));
        JButton button2=new JButton("Button 2");
        button2.setBounds(100,100,80,30);
        button2.setBackground(new Color(110,0,150));
        panel.add(button1);
        panel.add(button2);
        f.add(panel);
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static void main(String args[])
    {
        new Counter();
    }
}*/