import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.io.*;
import java.net.*;

@SuppressWarnings("serial")
public class ChatDialog extends JDialog {

    /** Default dimension of the dialog. */
    private final static Dimension DEFAULT_DIMENSION = new Dimension(400, 600);

    /** UI components */
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton connectButton;
    private JButton sendButton;

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
        
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        JScrollPane chatScrollPane = new JScrollPane(chatArea);
        chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        inputField = new JTextField();
        inputField.addActionListener(e -> send());

        connectButton = new JButton("Connect");
        connectButton.addActionListener(e -> connect());
        var port = new JTextField("Port",5);
        var server = new JTextField("Server",10);

        

        sendButton = new JButton("Send");
        sendButton.addActionListener(e -> send());
        sendButton.setEnabled(false);

        // Add the components to the dialog
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(chatScrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.add(inputField);
        inputPanel.add(Box.createHorizontalStrut(10));
        inputPanel.add(sendButton);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.add(connectButton);
        buttonPanel.add(server);
        buttonPanel.add(port);

        mainPanel.add(buttonPanel, BorderLayout.PAGE_END);
        mainPanel.add(inputPanel, BorderLayout.PAGE_START);

        setContentPane(mainPanel);

        sendButton.addActionListener(e -> {
            send();
            warn("Not connected to the server");
        });
     
    }



    /** Connect to the chat server. */
     private void connect() {

        sendButton.setEnabled(true);

        connectButton.setEnabled(false);


       
     }
    /** Send a message to the chat server. */
    private void send() {
        String message = inputField.getText();
        chatArea.append("You: " + message + "\n");
        //inputField.setText(message);
       
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
