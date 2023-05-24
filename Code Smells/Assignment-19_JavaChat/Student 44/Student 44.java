// $Id: ChatDialogUI.java,v 1.3 2018/04/06 21:32:56 cheon Exp $

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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

    public ChatDialogUI(String host, int port) {
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
        //--
        try {
            String host = serverEdit.getText();
            int port = Integer.parseInt(portEdit.getText());

            ChatDialogUI socket= new ChatDialogUI("opuntia.cs.utep.edu",8000);
            if (socket == null || socket.isClosed()) {
                // Connect to the server
                new ChatDialogUI(host, port);

                // Start a new thread to handle incoming messages from the server
                Thread t = new Thread(this::receiveMessages);
                t.start();

                // Update the UI
                connectButton.setText("Disconnect");
            } else {
                // Disconnect from the server
                socket.close();
                socket = null;

                // Update the UI
                connectButton.setText("Connect");
            }
        } catch (UnknownHostException e) {
            warn("Unknown host: " + e.getMessage());
        } catch (IOException e) {
            warn("Error connecting to server: " + e.getMessage());
        }
    }

    private void receiveMessages() {

    }


    /** Callback to be called when the sendt button is clicked. */
    private void sendClicked(ActionEvent event) {
        //--
        //-- WRITE YOUR CODE HERE
        //--
        // Get the message to send from the message edit field
        String message = msgEdit.getText();

        // Send the message to the server

        Process socket = null;
        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        out.println(message);

        // Display the message in the message display area
        msgDisplay.append("Me: " + message + "\n");

        // Clear the message edit field
        msgEdit.setText("");
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
