import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ChatDialog extends JDialog {
    
    /** Default dimension of the dialog. */
    private final static Dimension DEFAULT_DIMENSION = new Dimension(400, 500);
    
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
    	this.setLayout(new BorderLayout());
    	
    	//this is northern part of border Layout
    	JPanel north = new JPanel();
    	JButton connectButton = new JButton("Disconnect");
    	north.add(connectButton);
    	JTextField serverName = new JTextField("Server");
    	serverName.setColumns(20);
    	north.add(serverName);
    	JTextField port = new JTextField("Port");
    	north.add(port);
    	this.add(north,BorderLayout.NORTH);
    	
    	//center
    	JPanel center = new JPanel();
    	center.setLayout(new BorderLayout());
    	JTextArea TextDisplay = new JTextArea();
    	TextDisplay.setEditable(false);
    	TextDisplay.setLineWrap(true);
    	JScrollPane jp = new JScrollPane(TextDisplay);
    	jp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    	center.add(jp,BorderLayout.CENTER);
    	this.add(center,BorderLayout.CENTER);
    	//center.setSize(WIDTH, HEIGHT);
    	
    	//bottom
    	JPanel south = new JPanel();
    	JTextField TextInput = new JTextField();
    	TextInput.setColumns(25);
    	JButton sendButton = new JButton("Send");
    	//action for send button
    	sendButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(connectButton.getText() == "Disconnect") {
					String currentTextDisplay = TextDisplay.getText();
					String Input = TextInput.getText();
					TextInput.setText("");
					TextDisplay.append("\n"+Input);
				}else {
					JFrame f=new JFrame();  
				    JOptionPane.showMessageDialog(f,"Please Connect To A Server!");  
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
    	});
    	south.add(TextInput);
    	south.add(sendButton);
    	this.add(south,BorderLayout.SOUTH);
    	
    	
    	//code for connect/disconnect button
    	connectButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(connectButton.getText() == "Disconnect") {
					connectButton.setText("Connect");
				}else {
					connectButton.setText("Disconnect");
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
    	});
    	
    	
    	
    	
        //--
        //-- WRIYE YOUR CODE HERE
        //--
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