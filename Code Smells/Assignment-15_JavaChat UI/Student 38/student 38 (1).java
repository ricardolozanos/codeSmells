import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        // Create a JPanel to hold the chat messages
        JPanel messagePanel = new JPanel(new BorderLayout());
        //Create panel for user input
        JPanel inputPanel = new JPanel(new BorderLayout());
        //Create panel for input related to server
        JPanel serverPanel = new JPanel(new BorderLayout());
        //Create messageArea where messages are shown
        JTextArea messageArea = new JTextArea();
        messageArea.setEditable(false);
        //Add scroller to messageBox
        JScrollPane scrollPane = new JScrollPane(messageArea);
        messagePanel.add(scrollPane, BorderLayout.CENTER);
        //Create textFields
        JTextField inputField = new JTextField("Enter a message");
        JTextField portField = new JTextField("Server");
        //Create buttons
        JButton sendButton = new JButton("Send");
        JButton serverButton = new JButton("Connect");


        //Action listener for when send button is clicked
        sendButton.addActionListener(e -> {
            String message = inputField.getText();
            if (!message.isEmpty()) {
                // Handle sending the message
                String formattedMessage = String.format("You: %s", message);

                // Append the message to the message area
                messageArea.append(formattedMessage + "\n");
                // ...
                inputField.setText("");
            }
        });
        //Code to change connection when clicked
        serverButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (serverButton.getText().equals("Connect")) {
                    serverButton.setText("Disconnect");
                } else {
                    serverButton.setText("Connect");
                }
            }
        });
        //Add field and button
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        //Add field and button
        serverPanel.add(serverButton, BorderLayout.WEST);
        serverPanel.add(portField, BorderLayout.CENTER);
        //Add panels to frame
        add(messagePanel, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
        add(serverPanel,BorderLayout.NORTH);
        
    }

    /** Show the given warning or error message in a modal dialog. */
    private void warn(String msg) {
        JOptionPane optionPane = new JOptionPane(msg, JOptionPane.WARNING_MESSAGE);
        JDialog dialog = optionPane.createDialog("Warning");
        dialog.setModal(false);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        ChatDialog dialog = new ChatDialog();
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.warn("Not connected to server");
    }
}