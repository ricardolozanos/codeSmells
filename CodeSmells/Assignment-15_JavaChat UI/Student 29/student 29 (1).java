package counter;

import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
//$Id: ChatDialog-template.java,v 1.3 2018/03/31 18:20:36 cheon Exp $
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
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
     //--
	 this.setLayout(new BorderLayout());

	 // Top panel 
	 JPanel panel = new JPanel();
	 JButton cbutton = new JButton("connect"); panel.add(cbutton);
	 JButton dbutton = new JButton("Disconnect");panel.add(dbutton); dbutton.setVisible(false);
	 panel.add(new JTextArea("Server", 1, 15));
	 panel.add(new JTextArea("Port", 1, 5));
	 this.add(BorderLayout.PAGE_START, panel);

	 JTextArea mArea = new JTextArea();
	 mArea.setEditable(false);
	 
	 // Scroll pane
	 JScrollPane scroll = new JScrollPane(mArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	 this.add(BorderLayout.CENTER,scroll);
	 
	 // bottom panel
	 JPanel spanel = new JPanel();
	 JTextArea sArea = new JTextArea("Enter a Message",1, 25);
	 spanel.add(sArea);
	 JButton sbutton = new JButton("Send"); 
	 spanel.add(sbutton);
	 spanel.add(new JButton("Send"));
	 this.add(BorderLayout.PAGE_END,spanel);
	 

	 // Action for Connect
	 cbutton.addActionListener(e -> {
		 warn("Not connected to server!");
	 });
	 

	 // Action for disconnect
	 dbutton.addActionListener(e -> {
		 dbutton.setVisible(false);
		 cbutton.setVisible(true);
	 });
	 

	 // Action for the Send button
	 sbutton.addActionListener(e -> {
		 mArea.append(sArea.getText()+"\n");
		 sArea.setText("");
		 dbutton.setVisible(true);
		 cbutton.setVisible(false);
	 });
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
