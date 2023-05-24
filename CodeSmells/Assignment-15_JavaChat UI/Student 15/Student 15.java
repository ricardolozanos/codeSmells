// $Id: ChatDialog-template.java,v 1.3 2018/03/31 18:20:36 cheon Exp $

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class ChatDialog extends JDialog {
    private boolean connected = false;
    private JTextArea textArea;
    private JTextField input;
    private JMenuItem menuItem;
    private JButton connect;


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
        JMenuBar menuBar = new JMenuBar();
        JMenu connectionMenu = new JMenu("Connection");
        JToolBar toolBar = new JToolBar();

        menuItem = new JMenuItem("Connect");
        connect = new JButton("Connect");
        connect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connect();
            }
        });
        connectionMenu.add(connect);
        menuBar.add(connectionMenu);
        setJMenuBar(menuBar);

        // Create chat area and make it read-only
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane chatScroll = new JScrollPane(textArea);
        add(chatScroll, BorderLayout.CENTER);

        // Create input field and send button
        input = new JTextField();
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = input.getText().trim();
                if (connected) {
                    if (!text.isEmpty()) {
                        message(text);
                        input.setText("");
                    }
                } else {
                    warn("Not Connected to a Server!.");
                }
            }
        });

        JPanel inputPanel = new JPanel(new BorderLayout());

        inputPanel.add(sendButton, BorderLayout.EAST);
        inputPanel.add(input, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
    }

    /** Show the given warning or error message in a modal dialog. */
    private void warn(String msg) {
        JOptionPane.showMessageDialog(this, msg, "JavaChat",
                JOptionPane.PLAIN_MESSAGE);
    }
    /** Connect user to chat*/
    private void connect(){
        if (!connected) {
            connected = true;
            menuItem.setText("Disconnect");
            input.setEditable(true);
        } else {
            connected = false;
            menuItem.setText("Connect");
            input.setEditable(false);
            input.setText("");
        }
    }
    /** Display Text to the textArea*/
    private void message(String message){
        textArea.append(message);
    }


    public static void main(String[] args) {
        Dimension dim = new Dimension(400,600);
        ChatDialog dialog = new ChatDialog(dim);
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}