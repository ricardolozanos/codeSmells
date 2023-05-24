package omokGui;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class ChatDialog extends JDialog {
    
    /** Default dimension of the dialog. */
    private final static Dimension DEFAULT_DIMENSION = new Dimension(400, 400);
    private boolean isConnected = false;
    
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
        JPanel messagePanel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new BorderLayout());
        JPanel serverPanel = new JPanel(new BorderLayout());
        JTextArea messageArea = new JTextArea();
        messageArea.setEditable(false);
        JButton sendButton = new JButton("Send");
        JButton serverButton = new JButton("Connect");
        JScrollPane scrollPane = new JScrollPane(messageArea);
        messagePanel.add(scrollPane, BorderLayout.CENTER);
        JTextField inputField = new JTextField();

        //Action listener for when send button is clicked
        sendButton.addActionListener(e -> {
            String message = inputField.getText();
            if (this.isConnected) {
            	if(!message.isEmpty()) {
	                // Handle sending the message
	                String formattedMessage = String.format("You: %s", message);
	
	                // Append the message to the message area
	                messageArea.append(formattedMessage + "\n");
	                // ...
	                inputField.setText("");
            	}
            }
            else {
            	warn("Not connected to a server");
            }
            
        });
        
        serverButton.addActionListener(e -> {
        	if(!this.isConnected) {
        		this.isConnected = true;
        		serverButton.setText("Disconnect");
        	}
        	else {
        		this.isConnected = false;
        		serverButton.setText("Connect");
        	}
        });
        
        add(messagePanel, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
        add(serverPanel,BorderLayout.NORTH);
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        serverPanel.add(serverButton, BorderLayout.WEST);
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
