// $Id: ChatDialogUI.java,v 1.3 2018/04/06 21:32:56 cheon Exp $

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

/** A simple chat dialog. */
@SuppressWarnings("serial")
public class ChatDialogUI extends JDialog {
    
    /** Default dimension of chat dialogs. */
    private final static Dimension DIMENSION = new Dimension(400, 400);
    
    private JButton connectButton;
    private JButton sendButton;
    private JTextField serverEdit;
    private JTextField portEdit;
    private JTextArea msgDisplay;
    private JTextField msgEdit;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private threadin thread;
    
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
    }
    
    /** Callback to be called when the connect button is clicked. */
    private void connectClicked(ActionEvent event) {
        //--
        //-- WRITE YOUR CODE HERE
        //--
    	try {
    		this.socket = new Socket(this.serverEdit.getText(), Integer.parseInt(this.portEdit.getText()));
    		this.out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
    		this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    		this.thread = new threadin(this.in, this.msgDisplay);
    		thread.start();
    	}catch (Exception e){
    		e.printStackTrace();
    		System.out.println("server Unexisting");
    	}
    }
    
    /** Callback to be called when the send button is clicked. */
    private void sendClicked(ActionEvent event) {
        //--
        //-- WRITE YOUR CODE HERE
        //--
    	try {
    		System.out.println("Sending line: " + this.msgEdit.getText());
    		out.println(this.msgEdit.getText());
    		out.flush();
    	}catch (Exception e){
    		e.printStackTrace();
    	}
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
    
    class threadin extends Thread{
    	private BufferedReader in;
    	private JTextArea msgDisplay;
    	
    	public threadin(BufferedReader br, JTextArea msgDisplay) {
    		super();
    		this.in = br;
    		this.msgDisplay = msgDisplay;
    	}
    	public void run() {
    		String str = "Start Of Server";
    		while(str != null) {
    			try {
    				str = in.readLine();
    				msgDisplay.append("\n >"+ str);
    			}catch(Exception e) {
    				e.printStackTrace();
    			}
    		}
    	}
    }
}