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
                setResizable(false);
                setLocationRelativeTo(null);
            }

            /** Configure GUI of this dialog. */
            private void configureGui() {

                // adds toolbar to the top
                var toolBar = new JToolBar();
                var connect = new JButton("Connect");
                var port = new JButton("Port");
                var server = new JTextField("Server");
                server.setEditable(false);
                toolBar.add(connect);
                toolBar.add(server);
                toolBar.add(port);
                add(toolBar,BorderLayout.NORTH);


                //adds scrollable pane with text area
                var messageArea = new JTextArea();
                var panel = new JScrollPane(messageArea);
                add(panel,BorderLayout.CENTER);
                int verticalPolicy = JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED;
                panel.setVerticalScrollBarPolicy(verticalPolicy);

                //adds field so user can send message
                var messageBar = new JToolBar();
                var message = new JTextField();
                var send = new JButton("Send");
                messageBar.add(message);
                messageBar.add(send);
                add(messageBar,BorderLayout.SOUTH);



                send.addActionListener(e -> {
                    messageArea.append(message.getText());
                    messageArea.append("\n");
                    message.setText("");

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

