package noapplet.example;

//$Id: ChatDialogUI.java,v 1.3 2018/04/06 21:32:56 cheon Exp $

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

/**
 * @author Dante Lopez & Jesus Oropeza
 */

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
	 Socket s;
	 PrintWriter out;
	 BufferedReader in;
	 
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
		 try  {
			int w = Integer.parseInt(portEdit.getText());
 	 		s = new Socket(serverEdit.getText(), w);
 	 		out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
 	 		in = new BufferedReader(new InputStreamReader(s.getInputStream()));
 	 		Thread thread = new Thread(() -> {
 	 			String str = null;
 	 			try {
 	 				while ((str = in.readLine()) != null) {
 	 					msgDisplay.append(str + "\n");
 	 				}
 	 			}catch (IOException e) {}
 	 		});
 	 		thread.start();
 	 	} catch (Exception e1) { e1.printStackTrace(); }
	 }
	 
	 /** Callback to be called when the send button is clicked. */
	 private void sendClicked(ActionEvent event) {
		 out.println(msgEdit.getText());
		  out.flush();

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
