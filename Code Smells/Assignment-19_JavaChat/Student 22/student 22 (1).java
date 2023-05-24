import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ChatDialog extends JDialog {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
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

    // set display name for chat dialog
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    private void configureGui() {
        setLayout(new BorderLayout());

        // add connect button north of the chat area
        JPanel topPanel = new JPanel(new BorderLayout());
        JButton connectButton = new JButton("Connect");
        topPanel.add(connectButton, BorderLayout.WEST);

        // add server JTextField to top panel
        JTextField serverField = new JTextField();
        serverField.setToolTipText("Enter Server");
        topPanel.add(serverField, BorderLayout.CENTER);

        // add port JTextField to top panel
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

        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isConnected) {
                    // Connect to the server or create a new session
                    try {
                        String server = serverField.getText().trim();
                        int port = Integer.parseInt(portField.getText().trim());
                        socket = new Socket(server, port);
                        out = new PrintWriter(socket.getOutputStream(), true);
                        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        isConnected = true;
                        chatArea.append("Connected to " + server + ":" + port + "\n");
                        messageField.setEnabled(true);
                        sendButton.setEnabled(true);
                        connectButton.setText("Disconnect");

                        // Start a new thread to receive messages asynchronously
                        new Thread(() -> {
                            try {
                                String receivedMessage;
                                while ((receivedMessage = in.readLine()) != null) {
                                    chatArea.append(receivedMessage + "\n");
                                }
                            } catch (IOException ex) {
                            }
                        }).start();
                    } catch (NumberFormatException | IOException ex) {
                        isConnected = false;
                        System.err.println("Error: " + ex.getMessage());
                        warn("Could not connect");
                    }
                } else {
                    if (isConnected){
                    // Disconnect from the server
                    try {
                        socket.close();
                        out.close();
                        in.close();
                        isConnected = false;
                        chatArea.append("Disconnected\n");
                        messageField.setEnabled(false);
                        sendButton.setEnabled(false);
                        connectButton.setText("Connect");
                    } catch (IOException ex) {
                        warn("Could not disconnect");
                    }
                }
            }
        }});

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
        String message = messageField.getText().trim();
        if (!message.isEmpty()) {
            try {
                out.println(message);
            } catch (Exception ex) {
                warn("Error sending message");
            }
            messageField.setText("");
        }
    }

    private void handleWindowClosing() {
        // Disconnect from the server
        try {
            if (socket != null) {
                socket.close();
            }
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
        } catch (IOException ex) {
            warn("Could not disconnect");
        }

        System.exit(0);
    }

    private void warn(String msg) {
        JOptionPane.showMessageDialog(this, msg, "JavaChat", JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args) {
        ChatDialog dialog = new ChatDialog();
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
