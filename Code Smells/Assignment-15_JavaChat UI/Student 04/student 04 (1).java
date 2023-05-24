package exercises.JavaChat;
// $Id: ChatDialog-template.java,v 1.3 2018/03/31 18:20:36 cheon Exp $

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;

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
        //-- WRIYE YOUR CODE HERE
        //--
        // Create a panel to hold the connection components
        JPanel connectionPanel = new JPanel(new BorderLayout());
        
        // Create a button to connect to the server
        JButton connectButton = new JButton("Connect");
        connectionPanel.add(connectButton, BorderLayout.WEST);
        connectButton.addActionListener(e -> {
            if (connectButton.getText() == "Connect") {
                // The user has clicked the connect button
                connectButton.setText("Disconnect");
            } else {
                // The user has clicked the disconnect button
                connectButton.setText("Connect");
            }
        });
        
        // Create a text field to enter the server address
        JTextField serverField = new JTextField();
        serverField.setForeground(Color.GRAY);
        serverField.setText("Server");
        connectionPanel.add(serverField, BorderLayout.CENTER);
        
        // Create a text field to enter the port number
        JTextField portField = new JTextField(5);
        portField.setForeground(Color.GRAY);
        portField.setText("Port");
        connectionPanel.add(portField, BorderLayout.EAST);
        
        // Add the connection panel to the top of the dialog
        getContentPane().add(connectionPanel, BorderLayout.NORTH);
        
        // Create the chat area
        JTextArea chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane chatScrollPane = new JScrollPane(chatArea);
        getContentPane().add(chatScrollPane, BorderLayout.CENTER);

        
        // Create the message input panel
        JPanel messagePanel = new JPanel(new BorderLayout());
        
        // Create a text field to enter the message
        JTextField messageField = new JTextField();
        messageField.setForeground(Color.GRAY);
        messageField.setText("Enter a message");
        messagePanel.add(messageField, BorderLayout.CENTER);

        
        // Create a button to send the message
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(e -> {
            if (connectButton.getText() == "Connect") {
                // The user has not clicked the connect button yet
                warn("Please connect to the server first!");
            } else {
                // The user has clicked the connect button
                String message = messageField.getText();
                if (message.length() == 0) {
                    // The user has not entered a message
                    warn("Please enter a message!");
                } else {
                    // The user has entered a message
                    chatArea.append(message + "\n");
                }
            }
        });
        messagePanel.add(sendButton, BorderLayout.EAST);
            
        // Add the message input panel to the bottom of the dialog
        getContentPane().add(messagePanel, BorderLayout.SOUTH);
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