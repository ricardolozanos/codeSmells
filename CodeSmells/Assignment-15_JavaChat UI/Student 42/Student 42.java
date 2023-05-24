package noapplet.JavaChat;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;
@SuppressWarnings("serial")
public class JavaChat extends JDialog {
    /** Default dimension of the dialog. */
    private final static Dimension DEFAULT_DIMENSION = new Dimension(400, 600);
    private final static JButton connect = new JButton();
    private static JButton send = new JButton();

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
        //-- WRITE YOUR CODE HERE
        warn("Not Connected To a Server");
        connect.setText("Connect");
        connect.addActionListener(e -> {
            if (connect.getText().equals("Connect")) {
                connect.setText("Disconnect");
                send.setEnabled(true);
            } else {
                connect.setText("Connect");
                warn("Adrian Urquizo" + "\nNot Connected To a Server");
                send.setEnabled(false);
            }
        });

        JTextField server = new JTextField("Server", 20);
        server.setEditable(false);
        JTextField port = new JTextField("Port", 5);
        port.setEditable(false);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(connect);
        topPanel.add(server);
        topPanel.add(port);

        JTextArea messageDisplay = new JTextArea();
        messageDisplay.setEditable(false);
        JScrollPane messages = new JScrollPane(messageDisplay);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        JTextField messageInput = new JTextField();
        send = new JButton("Send");
        send.setEnabled(false);
        bottomPanel.add(messageInput, BorderLayout.CENTER);
        bottomPanel.add(send, BorderLayout.EAST);

        send.addActionListener(e -> {
            String message = messageInput.getText();
            if (!message.isEmpty()) {
                messageDisplay.append(message + "\n");
                messageInput.setText("");
            }
        });

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(messages, BorderLayout.CENTER);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        //--
    }

    /** Show the given warning or error message in a modal dialog. */
    private void warn(String msg) {
        JOptionPane.showMessageDialog(this, msg, "JavaChat",
                JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        JavaChat dialog = new JavaChat();
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
