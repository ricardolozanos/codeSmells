import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ChatDialog extends JDialog {

    private final static Dimension DEFAULT_DIMENSION = new Dimension(400, 600);

    private JTextField messageField;
    private JButton sendButton;
    private JTextArea chatArea;
    private JScrollPane chatAreaScrollPane;
    private boolean isConnected = false;
    private String displayName;

    public ChatDialog() {
        this(DEFAULT_DIMENSION);
    }

    public ChatDialog(Dimension dim) {
        super((JFrame) null, "JavaChat");
        configureGui();
        setSize(dim);
        setLocationRelativeTo(null);
    }

    //set display name for chat dialog
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    private void configureGui() {
        setLayout(new BorderLayout());

        //add connect button north of the chat area
        JPanel topPanel = new JPanel(new BorderLayout());
        JButton connectButton = new JButton("Connect");
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isConnected) {
                    // Connect to the server or create a new session
                    try {
                        // Add code to connect to the server using serverField and portField values
                        isConnected = true;
                        chatArea.append("Connected\n");
                        messageField.setEnabled(true);
                        sendButton.setEnabled(true);
                        connectButton.setText("Disconnect");
                    } catch (Exception ex) {
                        isConnected = false;
                        warn("Could not connect");
                    }
                } else {
                    // Add code to disconnect from the server
                    isConnected = false;
                    chatArea.append("Disconnected\n");
                    messageField.setEnabled(false);
                    sendButton.setEnabled(false);
                    connectButton.setText("Connect");
                }
            }
        });
        topPanel.add(connectButton, BorderLayout.WEST);

        //add server JTextField to top panel
        JTextField serverField = new JTextField();
        serverField.setToolTipText("Enter Server"); 
        topPanel.add(serverField, BorderLayout.CENTER);
        //add port JTextField to top panel
        JTextField portField = new JTextField();
        portField.setToolTipText("Enter Port");
        portField.setPreferredSize(new Dimension(50, portField.getPreferredSize().height));
        topPanel.add(portField, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatAreaScrollPane = new JScrollPane(chatArea);
        add(chatAreaScrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        messageField = new JTextField();
        messageField.setEnabled(false);
        bottomPanel.add(messageField, BorderLayout.CENTER);
        sendButton = new JButton("Send");
        sendButton.setEnabled(false);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        add(bottomPanel, BorderLayout.SOUTH);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        messageField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });

        isConnected = false; // Set the initial state as not connected

        // Add a listener to handle window closing
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                handleWindowClosing();
            }
        });
    }

    private void sendMessage() {
        if (!isConnected) {
            isConnected = true;
            chatArea.append("Connected\n");
            messageField.setText("");
            messageField.setEnabled(true);
            sendButton.setEnabled(true);
        } else {
            String message = messageField.getText().trim();
            if (!message.isEmpty()) {
                chatArea.append("You: " + message + "\n");
                messageField.setText("");
                // Add code to send the message to the server and display the response
            }
        }
    }

    private void handleWindowClosing() {
        // Add code to handle disconnection from the server
        System.exit(0);
    }

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


