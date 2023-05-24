// $Id: ChatDialogUI.java,v 1.3 2018/04/06 21:32:56 cheon Exp $

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;
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

    private Socket socket;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;
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
    private void connectClicked(ActionEvent event){
        connectButton.setText("Connected");
        int pe = Integer.parseInt(portEdit.getText());
        String servEd= serverEdit.getText();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            socket = new Socket(servEd, pe);
            new Thread(() -> {
                try {
                    String message;
                    while ((message = bufferedReader.readLine()) != null) {
                        msgDisplay.append(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        catch (UnknownHostException e) {
            warn("UnknownhostException: " + e.getMessage());
        }
        catch (IOException e) {
            warn("IOException: " + e.getMessage());
        }
    }

    /** Callback to be called when the sendt button is clicked. */
    private void sendClicked(ActionEvent event) {
        String msg = msgEdit.getText();
        printWriter.println(msg);
        msgEdit.setText("Enter Message");

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
