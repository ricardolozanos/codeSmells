package noapplet.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class MouseMotionEvent extends JFrame implements MouseListener {
    JButton button;
    JPanel panel;
    JTextField display;
    private int hunk;
    public MouseMotionEvent() {
        var frame = new JFrame("Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 100));
        panel.setBackground(Color.BLACK);
        panel.add(new JLabel("Value: "));
        display = new JTextField("0",10);
        display.setEditable(false);
        button = new JButton("Increment");
        button.setBackground(Color.CYAN);
        button.addMouseListener(this);
        panel.add(display);
        panel.add(button);

        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MouseMotionEvent());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("the mouse clicked the area");
        display.setBackground(Color.BLUE);
        if (e.getSource() == button) {
            hunk++;
            display.setText(String.valueOf(hunk));
            repaint();
        }else{return;}

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("the mouse exit the area");
        button.setBackground(Color.CYAN);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("the mouse exit the area");
        button.setBackground(Color.CYAN);

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("the mouse enter the area");
        button.setBackground(new Color(100,10,130));

    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("the mouse exit the area");
        button.setBackground(Color.CYAN);
    }
}
