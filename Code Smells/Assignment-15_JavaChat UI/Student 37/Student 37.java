// $Id: ChatDialog-template.java,v 1.3 2018/03/31 18:20:36 cheon Exp $

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;


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
        //-- WRIYE YOUR CODE HERE
        //--
    	JToolBar toolBar = new JToolBar("ChatDialog");
    	JButton button=new JButton("Connect");
    	JLabel label=new JLabel("Server");
    	add(toolBar,BorderLayout.NORTH);
    	toolBar.add(button);
    	toolBar.add(label);
    	button.addActionListener(e ->{
    	button.setText("Disconnect");
    	
    	});
    	JTextField field=new JTextField();
    	JTextArea area=new JTextArea(5,30);
    	JScrollPane scroll=new JScrollPane(area);
    	add(field);
    	add(scroll,BorderLayout.SOUTH);
    	//add(new JLabel("Server"));
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
        dialog.warn("Not connected to server!");
        dialog.configureGui();
    }
}