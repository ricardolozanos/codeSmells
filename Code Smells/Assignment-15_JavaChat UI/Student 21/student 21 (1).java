package noapplet.example;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 
 * @author Dante Lopez
 * 
 *
 */

@SuppressWarnings("serial")
public class ChatDialog extends JDialog {
 
 /** Default dimension of the dialog. */
 private final static Dimension DEFAULT_DIMENSION = new Dimension(400, 600);
 protected static String ms = "";
 
 /** Create a main dialog. */
 public ChatDialog() {
     this(DEFAULT_DIMENSION);
 }
 
 /** Create a main dialog of the given dimension. */
 public ChatDialog(Dimension dim) {
     super((JFrame) null, "JavaChat");
     configureGui();
     setSize(dim);
//     setResizable(false);
     setLocationRelativeTo(null);
 }
 
 /** Configure GUI of this dialog. */
 private void configureGui() {
     var panel = new JPanel();
     var cn = new JButton("Connect");
     var tt = new JTextField("Server", 18);
     var trt = new JTextField("Port", 9);
     
     var word = new JTextArea();
     word.setEditable(false);
     var scroll = new JScrollPane(word);
     
     var bot = new JPanel();
     var bt = new JTextField("Enter a Message", 30);
     var bb = new JButton("Send");
     BorderLayout BL = new BorderLayout();
    
     panel.add(cn);
     panel.add(tt);
     panel.add(trt);
     
     bot.add(bt);
     bot.add(bb);
     
     add(panel, BL.NORTH);
     add(scroll, BL.CENTER);
     add(bot, BL.SOUTH);
     
     tt.addMouseListener(new MouseAdapter() {
 		
 		@Override
 		public void mouseClicked(MouseEvent e) {
 			super.mouseClicked(e);
 			tt.setText("");
 		}
 		
     });
     
     trt.addMouseListener(new MouseAdapter() {
 		
 		@Override
 		public void mouseClicked(MouseEvent e) {
 			super.mouseClicked(e);
 			trt.setText("");
 		}
 		
      });
     
     bt.addMouseListener(new MouseAdapter() {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			bt.setText("");
		}
		
     });
     
     cn.addActionListener(e -> {
    	 if(Objects.equals(cn.getText(), "Connect")) {
    	 	cn.setText("Disconnect");
    	 }else {
    		 cn.setText("Connect");
    	 }
     });
     
     bb.addActionListener(e -> {
    	 if(Objects.equals(cn.getText(), "Connect")) {
    		 warn("Not Connected to Server");
    	 }else {
    		 word.setText(msSend(bt.getText()));
    	 }
     });

 }

 /** Show the given warning or error message in a modal dialog. */
 private void warn(String msg) {
     JOptionPane.showMessageDialog(this, msg, "JavaChat", 
    		 JOptionPane.PLAIN_MESSAGE);        
 }
 
 private static String msSend(String w) {
	 w += "\n";
	 ms += w;
	 return ms;
 }

 public static void main(String[] args) {
     ChatDialog dialog = new ChatDialog();
     dialog.setVisible(true);
     dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
 }
}
