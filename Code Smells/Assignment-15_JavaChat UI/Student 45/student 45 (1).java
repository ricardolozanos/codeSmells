// $Id: ChatDialog-template.java,v 1.3 2018/03/31 18:20:36 cheon Exp $

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class ChatDialog extends JDialog {

    /** Default dimension of the dialog. */
    private final static Dimension DEFAULT_DIMENSION = new Dimension(400, 400);
    private final static String nextLine = "\n";

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
    var panel = new JPanel(new BorderLayout());
    var top = new JPanel();
    var bottom = new JPanel();
    var connect = new JButton("Connect");
    connect.addActionListener(e -> {
        if(connect.getText().equals("Connect")){
            connect.setText("Disconnect");
        }
        else{
            connect.setText("Connect");
        }
    });
    var send = new JButton("Send");
    var input = new JTextField("Enter a message",30);
    var output = new JTextArea();
    var scroll = new JScrollPane(output);
    scroll.createVerticalScrollBar();
    send.addActionListener(e ->{
        if(connect.getText().equals("Connect")){
            warn("Not connected to a server!");
        }
        else{
            output.append(input.getText() + nextLine);
        }
    });
    var serve = new JTextField("Server",20);
    var port = new JTextField("Port");
    top.add(connect);
    top.add(serve);
    top.add(port);
    bottom.add(input);
    bottom.add(send);


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

    public static void main(String[] args) {
        ChatDialog dialog = new ChatDialog();
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
