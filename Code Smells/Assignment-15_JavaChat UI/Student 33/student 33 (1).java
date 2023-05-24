package Misc;// $Id: ChatDialog-template.java,v 1.3 2018/03/31 18:20:36 cheon Exp $

import java.awt.Dimension;

import javax.swing.*;

@SuppressWarnings("serial")
public class ChatDialog extends JDialog {
    
    /** Default dimension of the dialog. */
    private final static Dimension DEFAULT_DIMENSION = new Dimension(450, 500);
    
    /** Create a main dialog. */
    public ChatDialog() {
        this(DEFAULT_DIMENSION);
    }
    
    /** Create a main dialog of the given dimension. */

    static boolean notConnected = true;
    public ChatDialog(Dimension dim) {
        super((JFrame) null, "JavaChat");
        configureGui();
        setSize(dim);
        setResizable(false);
        setLocationRelativeTo(null);

    }
    
    /** Configure GUI of this dialog. */
    private void configureGui() {
        var menuBar = new JMenuBar(); // Top menu Bar
        var menuPan = new JPanel(); // Menu Panel within Menu bar
        var panel = new JPanel(); // pan for TextArea
        var botBar = new JPanel(); // Bottom Bar

        // edit Menu Panel
        var funkyButton = new JButton("Connect: ");
        menuPan.add(funkyButton);

        // Add Server Text
        var menuText = new JTextField("Server", 15);
        menuText.setEditable(false);
        menuPan.add(menuText);

        // Add port text
        var menuPort = new JTextField("Port", 5);
        menuPort.setEditable(false);
        menuPan.add(menuPort);

        // Implement Text Area
        var textuAreau = new JTextArea(23,40);
        textuAreau.setEditable(false);
        var scrollBoi = new JScrollPane(textuAreau);
        scrollBoi.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //textuAreau.setText("Does this work" );
        panel.add(scrollBoi);

        // Add Bottom Bar
        var messText = new JTextField("Enter a message", 30);
        botBar.add(messText);
        var sendButton = new JButton("Send");
        botBar.add(sendButton);

        // add everything from Panel onto Menu Bar
        menuBar.add(menuPan);
        super.setJMenuBar(menuBar);
        super.setContentPane(panel);
        super.add(botBar);

        funkyButton.addActionListener( e -> {
            if(funkyButton.getText() == "Connect: "){
                funkyButton.setText("Disconnect");
                notConnected = false;
            }
            else {
                funkyButton.setText("Connect: ");
                notConnected = true;
            }
        });

        sendButton.addActionListener( e -> {
            if(funkyButton.getText() == "Disconnect" && messText.getText().length() > 0){
                String funky = textuAreau.getText();
                textuAreau.setText(funky += messText.getText() + "\n");
                messText.setText("");
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
        if(notConnected){
            JOptionPane.showMessageDialog(null, "Not connected to a server!", "JavaChat", JOptionPane.YES_NO_OPTION);
        }
    }
}
