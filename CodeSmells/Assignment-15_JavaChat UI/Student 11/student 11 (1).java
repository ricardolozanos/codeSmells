// $Id: ChatDialog-template.java,v 1.3 2018/03/31 18:20:36 cheon Exp $

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class ChatDialog extends JDialog {

    /** Default dimension of the dialog. */
    private final static Dimension DEFAULT_DIMENSION = new Dimension(400, 600);
    private boolean connected;
    private JButton connectionButton, sendButton;
    private JTextField ip, port, message;
    private JTextArea chatText;
    private JScrollPane chatScroll;

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
        // INIT Components
        connectionButton = new JButton("Connect");
        sendButton = new JButton("Send");
        ip = new JTextField();
        ip.setText("Server");
        ip.setPreferredSize(new Dimension(200,25));
        port = new JTextField();
        port.setText("Port");
        port.setPreferredSize(new Dimension(50,25));
        message = new JTextField("Enter a message");
        message.setPreferredSize(new Dimension(300,25));
        chatText = new JTextArea();
        chatText.setEditable(false);
        chatScroll = new JScrollPane(chatText);
        // set frame layout
        setLayout(new BorderLayout());
        JPanel topPanel = new JPanel(), bottomPanel = new JPanel();
        // add components to panels
        GroupLayout topGrouplayout = new GroupLayout(topPanel);
        topGrouplayout.setAutoCreateGaps(true);
        topGrouplayout.setHorizontalGroup(topGrouplayout.createSequentialGroup()
                .addComponent(connectionButton)
                .addComponent(ip)
                .addComponent(port));
        GroupLayout bottomGrouplayout = new GroupLayout(bottomPanel);
        bottomGrouplayout.setHorizontalGroup(bottomGrouplayout.createSequentialGroup()
                .addComponent(message)
                .addComponent(sendButton));
        // add panels to frames
        add(topPanel,BorderLayout.NORTH);
        add(bottomPanel,BorderLayout.SOUTH);
        add(chatScroll,BorderLayout.CENTER);
        // add event handlers
        connectionButton.addActionListener(e ->{
                connected = !connected;
                connectionButton.setText(!connected?"Connect":"Disconnect");
        });
        sendButton.addActionListener(e -> {
            if(!connected){warn("Not Connected to Server!"); return;}
            chatText.setText(chatText.getText() + message.getText() + "\n");
            message.setText("");
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
