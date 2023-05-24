package noapplet.example;
// $Id: ChatDialog-template.java,v 1.3 2018/03/31 18:20:36 cheon Exp $

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;

@SuppressWarnings("serial")
public class ChatDialog extends JDialog {
    JButton button;
    JButton button2;
    JPanel panel;
    JTextField display;
    JTextField display2;
    JTextArea textArea;
    JScrollPane scrollPane;
    JTextArea scrollArea = new JTextArea(20, 30);
    JLabel temp;
    String con ="connected";
    String con2 ="disconnected";
    int desc = 1;
    Container cont = getContentPane();
    //JTextArea scrollArea2 = new JTextArea(20, 5);

    /** Default dimension of the dialog. */

    private final static Dimension DEFAULT_DIMENSION = new Dimension(400, 600);

    /** Create a main dialog. */
    public ChatDialog() {
        this(DEFAULT_DIMENSION);
    }

    /** Create a main dialog of the given dimension. */
    public ChatDialog(Dimension dim) {
        super((JFrame) null, "JavaChat Pako");





        configureGui();
        setSize(dim);
        //setResizable(false);
        setLocationRelativeTo(null);
    }

    /** Configure GUI of this dialog. */
    private void configureGui() {
        //--
        //-- WRIYE YOUR CODE HERE
        //--

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 100));
        panel.setBackground(Color.BLACK);
        button = new JButton(con);
        button.setBackground(Color.GREEN);
        button.addActionListener(new ButtonActionListener());

        button2 = new JButton("send");
        button2.setBackground(Color.BLUE);
        button2.addActionListener(new ButtonActionListener());
        display = new JTextField("Server",15);
        display.setBackground(Color.magenta);
        display.setEditable(false);
        display2 = new JTextField("Port",10);
        display2.setBackground(Color.magenta);
        display2.setEditable(false);
        textArea = new JTextArea("please write something ",1, 20);
        textArea.setBackground(Color.LIGHT_GRAY);
        cont.add(textArea);
        scrollPane = new JScrollPane(scrollArea);
        scrollPane.setBackground(new Color(100,10,125));
        textArea.setEditable(true);
        scrollPane.setEnabled(false);
        //temp = new JLabel(String.valueOf(textArea));
        panel.add(button);
        panel.add(display);
        panel.add(display2);
        panel.add(scrollPane);
        panel.add(textArea);
        panel.add(button2);

        setContentPane(panel);
        pack();
        setVisible(true);
        //button.addMouseListener(this);
        button2.addActionListener(e ->{
            scrollArea.setText("User: " + textArea.getText() );
            textArea.setText("");

        } );
    }

    /** Show the given warning or error message in a modal dialog. */
    private void warn(String msg) {
        JOptionPane.showMessageDialog(this, msg, "JavaChatPAKO",
                JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args) {
        ChatDialog dialog = new ChatDialog();
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private class ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == button && desc == 1) {
                scrollArea.setText("");
                button.setText(String.valueOf(con2));
                button.setBackground(Color.RED);
                warn("you are disconnected");
                desc--;
                repaint();}
            else if (e.getSource() == button && desc == 0) {
                scrollArea.setText("");
                button.setText(String.valueOf(con));
                button.setBackground(Color.GREEN);
                warn("you are connected");
                desc++;
                repaint();
            }
            /*else if (e.getSource() == button2) {
                //temp = textArea.getText();
                scrollArea.setText("User: " + textArea.getText() );
                //textArea.setText("");
                //repaint();
            }*/
        }

    }
}