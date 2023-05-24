package noapplet.example;

// $Id: ChatDialog-template.java,v 1.3 2018/03/31 18:20:36 cheon Exp $

import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
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
        //jframe with border layout
        var panel = new JFrame();
        panel.setLayout(new BorderLayout());

        //top portion of chat that handles connection
        var top = new JPanel();
        var connection = new JButton("Connect");
        var server = new JTextField("Server", 15);
        var port = new JTextField("Port", 5);
        top.add(connection);
        top.add(server);
        top.add(port);
        add(top, BorderLayout.NORTH);

        //bottom portion of chat that handles messages
        var bottom = new JPanel();
        var message = new JTextField("Enter a message.", 25);
        var send = new JButton("Send");
        bottom.add(message);
        bottom.add(send);
        add(bottom, BorderLayout.SOUTH);

        //text area that displays messages
        JTextArea text = new JTextArea();
        add(text, BorderLayout.CENTER);

        //text area scroll pane
        JScrollPane scroll = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scroll);

        //connection button actions
        connection.addActionListener(e -> {
            if(server.getText().equals("Server")){
                warn("No connection to a server!"); //warning dialog
            }
            if(connection.getText() == "Connect"){
                connection.setText("Disconnect");
                text.append("Hello\n");
            }else{
                connection.setText("Connect");
            }
        });
        
        //send button actions - add message to text area
        send.addActionListener(e -> {
            String userMessage = message.getText();
            String outMessage = userMessage + "\n";
            text.append(outMessage);
        });

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
