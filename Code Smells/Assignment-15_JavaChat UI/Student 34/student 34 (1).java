package excs;

import java.awt.*;

import javax.swing.*;

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
        int i = 0;

        this.setLayout(new BorderLayout());
        var panel1 = new JPanel();
        var panel2 = new JPanel();
        var panel3 = new JPanel();
        panel1.setLayout(new FlowLayout());
        panel2.setLayout(new FlowLayout());
        panel3.setLayout(new BorderLayout());

        var server = new JTextField("Server");
        var Port = new JTextField("Port");
        server.setColumns(20);
        Port.setColumns(4);
        server.setEditable(false);
        Port.setEditable(false);
        var button1 = new JButton("Connect");
        var button2 = new JButton("Send");
        var bottomText = new JTextArea("Enter a message",1, 30);
        var forScroll = new JTextArea();
        var textArea = new JScrollPane(forScroll, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);




        panel1.add(button1);
        panel1.add(server);
        panel1.add(Port);
        this.add(panel1, BorderLayout.NORTH);
        this.add(textArea, BorderLayout.CENTER);
        this.add(panel3, BorderLayout.SOUTH);
        panel3.add(panel2,BorderLayout.SOUTH);
        panel2.add(bottomText);
        panel2.add(button2);

        button1.addActionListener( e ->{
            if(button1.getText() == "Connect") {
                button1.setText("Disconnect");
                return;
            }
            if(button1.getText() == "Disconnect"){
                button1.setText("Connect");
                warn("Not connected to a server");
                return;
            }
        });
        button2.addActionListener(e ->{
            if (button1.getText() == "Disconnect") {
                forScroll.append(bottomText.getText() + "\n");
                bottomText.setText("Enter a message");
            }
        });




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