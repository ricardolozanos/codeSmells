import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatJava extends JFrame implements ActionListener {

    // GUI elements
    private JTextField inputField;
    private JTextArea chatArea;
    private JButton Conectar;
    private JButton Enviar;
    private JLabel lblNewLabel;

    // Constructor
    public ChatJava() {
        super("ChatJava");
        setTitle("Chat");

        // Create GUI elements
        inputField = new JTextField();
        inputField.setText("80");
        chatArea = new JTextArea();
    	chatArea.setText("Conectando con el servidor....");
        
        chatArea.setText("Conectado!\nIngrese un saludo: ");
        
    
        
        Conectar = new JButton("Conectar con el servidor");
        Conectar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));
        Enviar = new JButton("Enviar");
        Enviar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 10));

        // Disable chat input until connected
        inputField.setEnabled(false);
        Enviar.setEnabled(false);

        // Add action listeners to buttons
        Conectar.addActionListener(this);
        Enviar.addActionListener(this);

        // Create panels for layout
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(Conectar);
        buttonPanel.add(Enviar);

        // Set layout and add components
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(inputField, BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        lblNewLabel = new JLabel("Puerto");
        scrollPane.setColumnHeaderView(lblNewLabel);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Conectar) {
            
            inputField.setEnabled(true);
            Enviar.setEnabled(true);
        } else if (e.getSource() == Enviar) {
          
            String message = inputField.getText();
           
            chatArea.append("Tu: " + message + "\n");
            inputField.setText("");
        }
    }

    public static void main(String[] args) {
    	try {
    		new ChatJava();
    	}catch(Exception e) {
    		
    	}
        
    }
}
