// $Id: ChatDialog-template.java,v 1.3 2018/03/31 18:20:36 cheon Exp $

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;

import javax.swing.border.Border;
import javax.swing.BorderFactory;



@SuppressWarnings("serial")
public class ChatDialog extends JDialog {
    private boolean serverConnection = false;
    /** Default dimension of the dialog. */
    private final static Dimension DEFAULT_DIMENSION = new Dimension(500, 500);


    /** Create a main dialog. */
    public ChatDialog() {
        this(DEFAULT_DIMENSION);

    }
    
    /** Create a main dialog of the given dimension. */
    public ChatDialog(Dimension dim) {
        super((JFrame) null, "JavaChat");
        configureGui();
        setSize(dim);
        setLocationRelativeTo(null);
    }
    
    /** Configure GUI of this dialog. */
    private void configureGui() {
        //-- WRIYE YOUR CODE HERE
        Border emptyBorder = BorderFactory.createEmptyBorder(8, 15, 8, 15);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel connectioPanel = new JPanel();
        connectioPanel.setLayout(new BorderLayout());
        connectioPanel.setBorder(emptyBorder);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        textPanel.setBorder(emptyBorder);
        
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BorderLayout());
        messagePanel.setBorder(emptyBorder);

        JButton connectionButton = new JButton("Connect");
        JButton sendButton = new JButton("Send");
        JTextField writeMessage = new JTextField("Enter a message");
        JTextField writeServer = new JTextField("Server");
        JTextField writePort = new JTextField("Port");
        JTextArea textHistory = new JTextArea();
        textHistory.setEditable(false);
        JScrollPane scrollText = new JScrollPane(textHistory);

        sendButton.addActionListener(e -> {
            if(!serverConnection){
                warn("Server not connected!");
            }else{
                textHistory.append(writeMessage.getText()+"\n");   
            }
        });

        connectionButton.addActionListener(e -> {
            serverConnection = true;
        });
        //detects if user clicks on writemessage and erases the text temporarily to allow for new text

        addPlaceholderText(writeMessage, "Enter a message");
        addPlaceholderText(writeServer, "Server");
        addPlaceholderText(writePort, "Port");


        connectioPanel.add(connectionButton, BorderLayout.WEST);
        connectioPanel.add(writeServer, BorderLayout.CENTER);
        connectioPanel.add(writePort, BorderLayout.EAST);

        textPanel.add(scrollText,BorderLayout.CENTER);

        messagePanel.add(writeMessage,BorderLayout.CENTER);
        messagePanel.add(sendButton,BorderLayout.EAST);
       /// writeMessage.setHorizontalAlignment(JTextField.CENTER);

        mainPanel.add(connectioPanel, BorderLayout.NORTH);
        mainPanel.add(textPanel, BorderLayout.CENTER);
        mainPanel.add(messagePanel, BorderLayout.SOUTH);

        add(mainPanel);


        
    }

    private void addPlaceholderText(JTextField textField, String placeholder) {
    textField.addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent e) {
            if (textField.getText().equals(placeholder)) {
                textField.setText("");
                textField.setForeground(Color.BLACK);
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (textField.getText().isEmpty()) {
                textField.setText(placeholder);
                textField.setForeground(Color.GRAY);
                textField.setCaretPosition(0);
            }
        }
    });
}

    /** Show the given warning or error message in a modal dialog. */
    private void warn(String msg) {
        JOptionPane.showMessageDialog(this, msg, "JavaChat",JOptionPane.PLAIN_MESSAGE);        
    }

    public static void main(String[] args) {
        ChatDialog dialog = new ChatDialog();
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
