// $Id: ChatDialog-template.java,v 1.3 2018/03/31 18:20:36 cheon Exp $

import java.awt.*;

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
        //--
        //-- WRIYE YOUR CODE HERE
        //--
        setLayout(new BorderLayout());
        var top = new JPanel();
        var connectButton = new JButton("connect");
        top.add(connectButton);
        var text = new JTextField("server", 10);
        var port = new JTextField("port",5);
        top.add(text);
        top.add(port);
        add(top, BorderLayout.NORTH);
        var bottom = new JTextField("Enter a message", 20);
        var sendButton = new JButton("send");
        var south = new JPanel();
        south.add(bottom);
        south.add(sendButton);
        add(south, BorderLayout.SOUTH);
        var center = new JTextArea();
        center.setEditable(false);
        add(center, BorderLayout.CENTER);

        sendButton.addActionListener(e-> {
            center.setText(bottom.getText());// "e -> {...}" is a JAVA Lambda short hand notation for next comments
            warn("Not connected to the server");
        });
    }

    /** Show the given warning or error message in a modal dialog. */
    private void warn(String msg) {
        JOptionPane.showMessageDialog(this, msg, "JavaChat",
                JOptionPane.PLAIN_MESSAGE);
    }
//    private void playButtonClicked(ActionEvent event) {
//        if (isGameOver()) {
//            startNewGame();
//        } else {
//            if (JOptionPane.showConfirmDialog(Main.this,
//                    "Play a new game?", "Omok", JOptionPane.YES_NO_OPTION)
//                    == JOptionPane.YES_OPTION) {
//                startNewGame();
//            }
//        }
//    }


    public static void main(String[] args) {
        ChatDialog dialog = new ChatDialog();
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
