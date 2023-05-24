package noapplet.example;
// $Id: ChatDialog-template.java,v 1.3 2018/03/31 18:20:36 cheon Exp $

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

@SuppressWarnings("serial")
/**
 * Author: Jesus Oropeza
 */
public class ChatDialog extends JDialog {

    protected static int wide = 400;
    protected static int tall = 600;
    protected static String msgString = "";
    /** Default dimension of the dialog. */
    private final static Dimension DEFAULT_DIMENSION = new Dimension(wide, tall);

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
        var panel = new JPanel();
        var bottomPanel = new JPanel();
        var con_dis = new JButton("Connect");
        var server = new JTextField("Server",15);
        var port = new JTextField("Port",5);
        var words = new JTextArea();
//        words.setEditable(false);
        var scroll = new JScrollPane(words);
        int boxWidth = (int) (wide*0.3);
        int boxHeight = tall/2;
        scroll.setSize(boxWidth, boxHeight);
        scroll.setBackground(Color.WHITE);
        var msg = new JTextField("Enter a message",25);
        var send = new JButton("Send");

        BorderLayout bl = new BorderLayout();
        panel.add(con_dis);
        panel.add(server);
        panel.add(port);
        bottomPanel.add(msg, BorderLayout.NORTH);
        bottomPanel.add(send);
        add(panel, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // changes
        con_dis.addActionListener(e -> {
            if(Objects.equals(con_dis.getText(), "Connect")){
                con_dis.setText("Disconnect");
            }
            else{
                con_dis.setText("Connect");
            }
        });
        send.addActionListener(e -> {
            if(Objects.equals(con_dis.getText(), "Connect")){
                //display error window
                JOptionPane.showConfirmDialog(scroll,"Not connected to server","ChatDialog",JOptionPane.OK_CANCEL_OPTION);
            }
            else{
                words.setText(msgBoard(msg.getText()));
            }
        });
        msg.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                msg.setText("");
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

    public static String msgBoard(String S){
        S = S + "\n";
        msgString += S;

        return msgString;
    }
}