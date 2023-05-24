package javachat;// $Id: javachat.ChatDialog-template.java,v 1.3 2018/03/31 18:20:36 cheon Exp $

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;
import javax.swing.text.DefaultCaret;

@SuppressWarnings("serial")
public class ChatDialog extends JDialog {

    /** Default dimension of the dialog. */
    private final static Dimension DEFAULT_DIMENSION = new Dimension(400, 400);
    private final static String nextLine = "\n";
    private JButton connectButton;
    private JButton sendButton;
    private JTextField serverEdit;
    private JTextField portEdit;
    private JTextArea msgDisplay;
    private JTextField msgEdit;
    private Socket socket;

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
        connectButton.addActionListener(this::connectClicked);
        sendButton.addActionListener(this::sendClicked);
        setLocationRelativeTo(null);
    }

    /** Configure GUI of this dialog. */
    private void configureGui() {
    var panel = new JPanel(new BorderLayout());
    var top = new JPanel();
    var bottom = new JPanel();
    connectButton = new JButton("Connect");
    connectButton.setFocusPainted(false);
    connectButton.addActionListener(e -> {
        if(connectButton.getText().equals("Connect")){
            connectButton.setText("Disconnect");
        }
        else{
            connectButton.setText("Connect");
        }
    });
    sendButton = new JButton("Send");
    sendButton.setFocusPainted(false);
    msgEdit = new JTextField("Enter a message",30);
    msgDisplay = new JTextArea();
    msgDisplay.setEditable(false);
    DefaultCaret caret = (DefaultCaret)msgDisplay.getCaret();
    caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE); // autoscroll
    var scroll = new JScrollPane(msgDisplay);
    scroll.createVerticalScrollBar();
    serverEdit = new JTextField("localhost",20);
    portEdit = new JTextField("8000",4);
    top.add(connectButton);
    top.add(serverEdit);
    top.add(portEdit);
    bottom.add(msgEdit);
    bottom.add(sendButton);


    panel.add(top, BorderLayout.PAGE_START);
    panel.add(scroll,BorderLayout.CENTER);
    panel.add(bottom, BorderLayout.PAGE_END);
    setContentPane(panel);
    pack();

    }

    /** Show the given warning or error message in a modal dialog. */
    private void warn(String msg) {
        JOptionPane.showMessageDialog(this, msg, "JavaChat",
                JOptionPane.PLAIN_MESSAGE);
    }

    /** Callback to be called when the connect button is clicked. */
    private void connectClicked(ActionEvent event) {

        try{
            socket = new Socket();
            socket.connect(new InetSocketAddress(serverEdit.getText(), Integer.parseInt(portEdit.getText())));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    /** Callback to be called when the sendt button is clicked. */
    private void sendClicked(ActionEvent event) {
        if(connectButton.getText().equals("Connect")){
            warn("Not connected to a server!");
        }
        else{
            try (
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            ){
                msgDisplay.append(in.readLine());
                msgDisplay.append(msgEdit.getText());

            }
            catch(IOException e){
                e.printStackTrace();
            }
        }

        }

    public static void main(String[] args) {
        ChatDialog dialog = new ChatDialog();
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
