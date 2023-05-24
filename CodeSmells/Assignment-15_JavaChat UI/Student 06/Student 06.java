// $Id: ChatDialog-template.java,v 1.3 2018/03/31 18:20:36 cheon Exp $

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.*;

@SuppressWarnings("serial")
public class ChatDialog extends JDialog {

    /** Default dimension of the dialog. */
    private final static Dimension DEFAULT_DIMENSION = new Dimension(400, 600);

    /** Create a main dialog. */
    public ChatDialog() {
        this(DEFAULT_DIMENSION);
    }

    /** Create a main dialog of the given dimension. */
    public ChatDialog(Dimension dim) {
        super((JFrame) null, "JavaChat");
        configureGui();
        setSize(dim);
        //setResizable(false);
        setLocationRelativeTo(null);
    }

    /** Configure GUI of this dialog. */
    private void configureGui() {
        //--
        //-- WRITE YOUR CODE HERE
        //--
        JButton cnct = new JButton("Connected");
        add(cnct, BorderLayout.NORTH);
        cnct.addActionListener(e -> {
            if(cnct.getText() == "Connected"){
                cnct.setText("Disconnected");
            }
            else{
                cnct.setText("Connected");
            }
        });
        JPanel northPanel = new JPanel();
        northPanel.add(cnct);
        JTextField server = new JTextField("Server");
        server.setColumns(25);
        northPanel.add(server);
        northPanel.add(new JTextField("Port"));
        JPanel chat = new JPanel(new BorderLayout());

        JTextArea messageArea = new JTextArea(10, 40);
        messageArea.setEditable(false);

        JScrollPane scroll = new JScrollPane(messageArea);

        JTextField in = new JTextField();

        in.addActionListener(e ->  {
            if(Objects.equals(cnct.getText(), "Disconnected")){
                JOptionPane.showMessageDialog(null, "Chat Disconnected");
                return;
            }
            String text = in.getText();
            messageArea.append(text + "\n");
            in.setText("Enter Message and try again.");

        });

        chat.add(scroll, BorderLayout.CENTER);
        chat.add(in, BorderLayout.SOUTH);
        add(chat, BorderLayout.CENTER);
        add(northPanel, BorderLayout.NORTH);
    }

    /** Show the given warning or error message in a modal dialog. */
    private void warn(String msg) {
        JOptionPane.showMessageDialog(this, msg, "JavaChat",
                JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args) {
        ChatDialog dialog = new ChatDialog();
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}