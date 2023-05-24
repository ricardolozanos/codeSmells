// $Id: ChatDialogUI.java,v 1.3 2018/04/06 21:32:56 cheon Exp $

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultCaret;

/** A simple chat dialog. */
@SuppressWarnings("serial")
public class ChatDialogUI extends JDialog {
    
    /** Default dimension of chat dialogs. */
    private final static Dimension DIMENSION = new Dimension(400, 400);
    
    private boolean changed = true;
    private boolean connected;
    private Socket s;
    private String str;
    private JButton connectButton;
    private JButton sendButton;
    private JTextField serverEdit;
    private JTextField portEdit;
    private JTextArea msgDisplay;
    private JTextField msgEdit;
    private PrintWriter out;
    private BufferedReader in;
    
    
    /** Create a main dialog. */
    public ChatDialogUI() {
        this(DIMENSION);
    }
    
    /** Create a main dialog of the given dimension. */
    public ChatDialogUI(Dimension dim) {
        super((JFrame) null, "JavaChat");
        configureGui();
        setSize(dim);
        //setResizable(false);
        connectButton.addActionListener(this::connectClicked);
        sendButton.addActionListener(this::sendClicked);
        setLocationRelativeTo(null);
    }
    
    /** Configure UI of this dialog. */
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
        DefaultCaret caret = (DefaultCaret)msgDisplay.getCaret();
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
        msgEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if(changed){
                    msgEdit.setText(null);
                    changed = false;
                }
            }
        });
    }
    
    /** Callback to be called when the connect button is clicked. */
    private void connectClicked(ActionEvent event) {
        try {
            connected = false;
            s = new Socket();
            s.connect(new InetSocketAddress(serverEdit.getText(), Integer.parseInt(portEdit.getText())), 4000 );
            connected = true;
        } catch(IOException e){
            warn("Could not connect");
        }
         catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
        if(connected){
        try {
            out = 
            new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            in = 
            new BufferedReader(new InputStreamReader(s.getInputStream()));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        warn("connected");
        str = null;
        msgDisplay.setText(null);
        new Thread(() ->{
            try {
                while ((str = in.readLine()) != null) { 
                    SwingUtilities.invokeLater(()->{msgDisplay.append(str+"\n");});
                    
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }}).start();

        }
        
    }
    
    /** Callback to be called when the sendt button is clicked. */
    private void sendClicked(ActionEvent event) {
        String msg = msgEdit.getText();
        if(msg.equals("BYE")&&connected){        
            msgDisplay.append(("Disconnecting"));
            connected = false;
        }
        out.println(msg);
        out.flush();
        msgEdit.setText(null);
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
