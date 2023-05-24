// $Id: ChatDialogUI.java,v 1.3 2018/04/06 21:32:56 cheon Exp $

import sun.net.www.protocol.file.FileURLConnection;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;
import javax.swing.text.DefaultCaret;

import static java.lang.System.out;

/** A simple chat dialog. */
@SuppressWarnings("serial")
public class ChatDialogUI extends JDialog {

    /**
     * Default dimension of chat dialogs.
     */
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

    /**
     * Create a main dialog.
     */
    public ChatDialogUI() {
        this(DIMENSION);
    }

    /**
     * Create a main dialog of the given dimension.
     */
    public ChatDialogUI(Dimension dim) {
        super((JFrame) null, "JavaChat");
        configureGui();
        setSize(dim);
        setResizable(false);
        connectButton.addActionListener(this::connectClicked);
        sendButton.addActionListener(this::sendClicked);
        setLocationRelativeTo(null);
    }

    /**
     * Configure UI of this dialog.
     */
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
        DefaultCaret caret = (DefaultCaret) msgDisplay.getCaret();
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

    /**
     * Callback to be called when the connect button is clicked.
     */
    private void connectClicked(ActionEvent event) {
        if (connectButton.getText() == "Connect") {
            connectButton.setText("Disconnect");
            try {
                socket = new Socket(serverEdit.getText(), Integer.parseInt(portEdit.getText()));
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                Thread thread = new Thread(() ->{
                   String str = null;
                   try {
                       while ((str = in.readLine()) != null) {
                           msgDisplay.append(str + "\n");
                       }
                   } catch (IOException e) {}
                 }); thread.start();
            }
            catch(Exception e){ e.printStackTrace();}
        }

        else if (connectButton.getText() == "Disconnect") {
            connectButton.setText("Connect");
        }
    }


    /** Callback to be called when the sendt button is clicked. */
    private void sendClicked(ActionEvent event) {
        if(connectButton.getText() == "Disconnect") {
            out.println(msgEdit.getText());
            out.flush();
        }
        else {
            warn("You are not connected!");
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