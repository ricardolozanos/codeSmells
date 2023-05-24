package noapplet.example;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultCaret;

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

    private BufferedReader in;
    private PrintWriter out;
    private boolean connected = false;

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
        new Thread(this::connect).start();
    }

    /** Callback to be called when the connect button is clicked. */
    private void connect() {
        String host = serverEdit.getText();
        int port = Integer.parseInt( portEdit.getText() );
        try {
            Socket socket = new Socket(host, port);
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            // Receive a response from the server and display it
            msgDisplay.append( in.readLine()+"\n" );

            connected = true;

            new Thread(this::receiveMessages).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Receive messages from the server in a loop
    private void receiveMessages() {
        try {
            while (connected) {
                String message = in.readLine();
                if (message == null) {
                    break;
                }
                SwingUtilities.invokeLater(() -> msgDisplay.append(message + "\n"));
            }
            // The connection has been closed, clean up
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** Callback to be called when the send button is clicked. */
    private void sendClicked(ActionEvent event) {
        if(!connected){
            warn("Not connected to server");
        }else{
            try{
                // Send the message to the server
                out.println(msgEdit.getText());
                out.flush();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /** Show the given message in a dialog. */
    private void warn(String msg) {
        JOptionPane.showMessageDialog(this, msg, "JavaChat",
                JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args) {
        ChatDialogUI dialog = new ChatDialogUI();
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
