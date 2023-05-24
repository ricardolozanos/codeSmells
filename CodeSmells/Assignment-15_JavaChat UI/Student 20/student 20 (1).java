import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class ChatDialog extends JDialog {


    /** Default dimension of the dialog. */
    private final static Dimension DEFAULT_DIMENSION = new Dimension(400, 420);

    /** Create a main dialog. */
    public ChatDialog() {
        this(DEFAULT_DIMENSION);
    }
    JButton connect;

    /** Create a main dialog of the given dimension. */
    public ChatDialog(Dimension dim) {
        super((JFrame) null, "JavaChat");
        setLayout(new FlowLayout());
        configureGui();
        setSize(dim);
        //setResizable(false);
        setLocationRelativeTo(null);
    }

    /** Configure GUI of this dialog. */
    private void configureGui() {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        connect = new JButton("Connect");
        connect.addActionListener(e -> {
            if(connect.getText().equals("Disconnect")){
                connect.setText("Connect");
            }
            else{
                connect.setText("Disconnect");
            }
        });
        add(connect);
        JTextField server = new JTextField("Server",20);
        add(server);
        JTextField port = new JTextField("Port",5);
        add(port);
        JTextArea chat = new JTextArea(18,37);
        add(chat);
        JScrollPane msgs = new JScrollPane(chat,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        add(msgs);
        JTextField msg = new JTextField("Enter a message",25);
        add(msg);
        JButton send = new JButton("Send");
        add(send);
        send.addActionListener(e -> {
            if(connect.getText().equals("Disconnect")){
                warn("Not connected to a server");
            }
            else{
                chat.append(msg.getText()+"\n");
            }
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
