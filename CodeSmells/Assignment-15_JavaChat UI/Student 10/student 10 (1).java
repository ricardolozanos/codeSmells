package chatDialog;

import java.awt.BorderLayout;

//$Id: ChatDialog-template.java,v 1.3 2018/03/31 18:20:36 cheon Exp $

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
     setResizable(false);
     setLocationRelativeTo(null);
 }
 
 /** Configure GUI of this dialog. */
 private void configureGui() {
     //--
     //-- WRIYE YOUR CODE HERE
     //--
	 var panel = new JPanel(new BorderLayout());
	 var server = new JPanel();
	 var text = new JPanel();
	 var message = new JPanel();
	 
	 var connectButton = new JButton("Connect");
	 var serverText = new JTextField(20);
	 serverText.setText("Server");
	 server.add(connectButton);
	 server.add(serverText);
	 
	 JTextArea area = new JTextArea(30,30);
	 area.setEditable(false);
	 text.add(area);
	 
	 var messageField = new JTextField(20);
	 var sendButton = new JButton("Send");
	 message.add(messageField);
	 message.add(sendButton);
	 
	 sendButton.addActionListener(e -> {
		 String mess = messageField.getText();
		 connectButton.setText("Disconnect");
		 area.append(mess+"\n");
			});
	 
	 connectButton.addActionListener(e -> {
		 warn("not connected to server");
			});
	 
	 panel.add(server,BorderLayout.NORTH);
	 panel.add(text,BorderLayout.CENTER);
	 panel.add(message,BorderLayout.SOUTH);
	 add(panel);
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
