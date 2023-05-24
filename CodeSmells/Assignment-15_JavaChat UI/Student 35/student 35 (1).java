package javaChat;

import java.awt.BorderLayout;

//$Id: ChatDialog-template.java,v 1.3 2018/03/31 18:20:36 cheon Exp $

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class JavaChat extends JDialog {
 
 /** Default dimension of the dialog. */
 private final static Dimension DEFAULT_DIMENSION = new Dimension(400, 600);
 
 /** Create a main dialog. */
 public JavaChat() {
     this(DEFAULT_DIMENSION);
 }
 
 /** Create a main dialog of the given dimension. */
 public JavaChat(Dimension dim) {
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

	 var panel = new JPanel();
	 var footer = new JPanel();
	 var header = new JPanel();
	 var scrollText = new JTextArea();
	 var scroll = new JScrollPane(scrollText);

	 header.setLayout(new FlowLayout());
	 panel.setLayout(new BorderLayout());
	 var headerButton = new JButton("connect");
	 headerButton.addActionListener(e -> {
		 JOptionPane.showMessageDialog(this, "Cannot connect to Server");
	 });
	 header.add(headerButton);
	 header.add(new JTextField(20));
	 var port = new JTextArea("port");
	 header.add(port);
	 port.setEditable(false);


	 
	 scroll.setColumnHeaderView(header);
	 panel.add(scroll, BorderLayout.CENTER);
	 var sendText = new JTextField(25);
	 var send = new JButton("send");
	 send.addActionListener(e -> { 
	 String text = sendText.getText();
	 scrollText.append("\n" + text);
	 });
	 footer.add(sendText);
	 footer.add(send);
	 panel.add(footer, BorderLayout.SOUTH);

	 add(panel);
     //--
 }

 /** Show the given warning or error message in a modal dialog. */
 private void warn(String msg) {
     JOptionPane.showMessageDialog(this, msg, "JavaChat", 
             JOptionPane.PLAIN_MESSAGE);        
 }

 public static void main(String[] args) {
     JavaChat dialog = new JavaChat();
     dialog.setVisible(true);
     dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
 }
}