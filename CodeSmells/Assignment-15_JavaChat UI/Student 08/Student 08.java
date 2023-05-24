import noapplet.NoApplet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JavaChat extends NoApplet{
    public JavaChat() {
        var frame = new JFrame("JavaChat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        var panel = new JPanel();
        panel.setPreferredSize(new Dimension(400,500));
        panel.setLayout(new BorderLayout());
        var top = new JPanel();
        var textbox = new JPanel();
        var message = new JPanel();

        // Adds the top panel
        var connect = new JButton("Connect");
        var server = new JTextField("Server",20);
        var port = new JTextField("Port",5);
        top.add(connect);
        top.add(server);
        top.add(port);
        panel.add(top, BorderLayout.NORTH);

        // Adds the textbox
        var box = new JTextArea();
        box.setPreferredSize(new Dimension(300,400));
        box.setEditable(false);
        var scroll = new JScrollPane(box);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textbox.add(scroll);
        panel.add(textbox);


        //Adds the message panel
        var type = new JTextField("Enter A Message",30 );
        var send = new JButton("Send");
        message.add(type);
        message.add(send);
        panel.add(message,BorderLayout.SOUTH);

        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);

        connect.addActionListener(e -> {
            if(connect.getText() == "Connect") {
                connect.setText("Disconnect");
            }
            else if(connect.getText() == "Disconnect") {
                connect.setText("Connect");
            }

        });


        send.addActionListener(e -> {
            if(connect.getText() == "Disconnect") {
                box.append(type.getText() + "\n");
            }
        });
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> new JavaChat());
    }
}
