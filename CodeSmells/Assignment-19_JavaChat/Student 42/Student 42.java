package JavaChat;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.Socket;

/** A simple chat dialog. */
@SuppressWarnings("serial")
public class ChatDialogUI extends JDialog {

    /** Default dimension of chat dialogs. */
    private final static Dimension DIMENSION = new Dimension(400, 400);
    private JButton connectButton;
    private JButton sendButton;
    private JTextField serverEdit;
    private JTextField portEdit;
    private JTextArea msgDisplay;
    private JTextField msgEdit;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    /** Create a main dialog. */
    public ChatDialogUI() {
        this(DIMENSION);
    }

    /** Create a main dialog of the given dimension. */
    public ChatDialogUI(Dimension dim) {
        super((JFrame) null, "JavaChat");
        configureGui();
        setSize(dim);
        //setResizable(false);
        connectButton.addActionListener(this::connectClicked);
        sendButton.addActionListener(this::sendClicked);
        setLocationRelativeTo(null);
    }

    /** Configure UI of this dialog. */
    private void configureGui() {
        JPanel connectPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        connectButton = new JButton("Connect");
        connectButton.setFocusPainted(false);
        serverEdit = new JTextField("localhost", 18);
        portEdit = new JTextField("8000", 4);
        connectPanel.add(connectButton);
        connectPanel.add(serverEdit);
        connectPanel.add(portEdit);

        msgDisplay = new JTextArea(10, 30);
        msgDisplay.setEditable(false);
        DefaultCaret caret = (DefaultCaret)msgDisplay.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE); // autoscroll
        JScrollPane msgScrollPane = new JScrollPane(msgDisplay);

        JPanel sendPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        msgEdit = new JTextField("Enter a message.", 27);
        sendButton = new JButton("Send");
        sendButton.setFocusPainted(false);
        sendPanel.add(msgEdit);
        sendPanel.add(sendButton);

        setLayout(new BorderLayout());
        add(connectPanel, BorderLayout.NORTH);
        add(msgScrollPane, BorderLayout.CENTER);
        add(sendPanel, BorderLayout.SOUTH);
    }

    /** Callback to be called when the connect button is clicked. */
    private void connectClicked(ActionEvent event) {
        //--
        //-- WRITE YOUR CODE HERE
        try {
            connectButton.setText("Disconnect");
            String serverName = serverEdit.getText();
            int port = Integer.parseInt(portEdit.getText());
            socket = new Socket(serverName, port);
            warn("Connected to " + serverName + ":" + port);
            msgEdit.setText("");

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = in.readLine();
            if (msg != null) {
                msgDisplay.append(msg + "\n");
            }

            ChatServer chatServer = new ChatServer();
            ChatServer.ClientHandler clientHandler = chatServer.new ClientHandler(socket);
            clientHandler.start();
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            new Thread(() -> {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println("Received: " + line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

        } catch (IOException e) {
            warn("Could not connect to server");
        }
        //--
    }

    /** Callback to be called when the sendt button is clicked. */
    private void sendClicked(ActionEvent event) {
        //--
        //-- WRITE YOUR CODE HERE
        String message = msgEdit.getText();
        out.println(message);
        msgEdit.setText("");
        msgDisplay.append(message+"\n");
        if(message.equals("BYE")){
            try {
                socket.close();
                connectButton.setText("Connect");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        //--
    }

    /** Show the given message in a dialog. */
    private void warn(String msg) {
        JOptionPane.showMessageDialog(this, msg, "JavaChat",
                JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        ChatDialogUI dialog = new ChatDialogUI();
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}