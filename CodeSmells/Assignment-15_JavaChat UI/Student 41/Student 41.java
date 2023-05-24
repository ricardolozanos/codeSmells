package noapplet;// $Id: ChatDialog-template.java,v 1.3 2018/03/31 18:20:36 cheon Exp $

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


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
        //-- WRITE YOUR CODE HERE
        this.setMinimumSize(new Dimension(400,300));

        var panel = new JPanel();
        var connectPanel = new JPanel();
        var textPanel = new JPanel();
        var messagePanel = new JPanel();

        panel.setLayout(new BorderLayout());
        connectPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        messagePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JTextArea area = new JTextArea();
        JScrollPane scroll = new JScrollPane(area);
        area.setEditable(false);
        scroll.setPreferredSize(new Dimension(DEFAULT_DIMENSION.width-25,DEFAULT_DIMENSION.height-120));
        textPanel.add(scroll);

        JButton connectButton = new JButton("Connect");
        JTextField serverField = new JTextField();
        JTextField portField = new JTextField();
        connectButton.setPreferredSize(new Dimension(100,27));
        portField.setPreferredSize(new Dimension(50,20));
        serverField.setPreferredSize(new Dimension(DEFAULT_DIMENSION.width-260,20));

        JTextField text = new JTextField("Enter Message Here");
        JButton sendButton = new JButton("Send");
        text.setPreferredSize(new Dimension(DEFAULT_DIMENSION.width-100,20));

        sendButton.addActionListener(e -> {
            area.append(text.getText() + "\n");
        });

        connectButton.addActionListener(e -> {
            if(connectButton.getText() != "Disconnect"){
                //Send server info somewhere + send message
                connectButton.setText("Disconnect");
                serverField.getText();
                portField.getText();
                confirmation("Connected to Server");
                area.append("Server:"+serverField.getText() + " Port:"+portField.getText()+"\n");
            }
            else{
                connectButton.setText("Connect");
                //Disconnect from server code + message
                confirmation("Disconnected from server");
                area.append("Disconnected from server" + "\n");
            }
        });

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                var source = (ChatDialog) e.getSource();
                var window = source.getSize();
                scroll.setPreferredSize(new Dimension(window.width-25, window.height-120));
                text.setPreferredSize(new Dimension(window.width-100,20));
                serverField.setPreferredSize(new Dimension(window.width-260,20));
            }
        });

        connectPanel.add(new JLabel("Server"));
        connectPanel.add(serverField);
        connectPanel.add(new JLabel("Port"));
        connectPanel.add(portField);
        connectPanel.add(connectButton);

        messagePanel.add(text);
        messagePanel.add(sendButton);

        panel.add(connectPanel, BorderLayout.NORTH);
        panel.add(textPanel, BorderLayout.WEST);
        panel.add(messagePanel, BorderLayout.SOUTH);
        super.setContentPane(panel);
        //--
    }

    /** Show the given warning or error message in a modal dialog. */
    private void warn(String msg) {
        JOptionPane.showMessageDialog(this, msg, "JavaChat",
                JOptionPane.PLAIN_MESSAGE);
    }
    private void confirmation(String message){
        JFrame popup = new JFrame();
        JPanel popupPanel = new JPanel();
        JPanel textPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JButton okButton = new JButton("OK");
        JLabel text = new JLabel(message);
        popup.setResizable(false);

        popupPanel.setLayout(new BorderLayout());
        textPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        popup.setPreferredSize(new Dimension(250,100));

        okButton.addActionListener(e -> {
            popup.setVisible(false);

        });

        textPanel.add(text);
        buttonPanel.add(okButton);

        popupPanel.add(textPanel, BorderLayout.NORTH);
        popupPanel.add(buttonPanel, BorderLayout.SOUTH);

        popup.setContentPane(popupPanel);
        popup.pack();
        popup.setLocationRelativeTo(this);
        popup.setVisible(true);
        popup.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        ChatDialog dialog = new ChatDialog();
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}