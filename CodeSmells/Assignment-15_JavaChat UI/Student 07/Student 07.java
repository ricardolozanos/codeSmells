package noapplet.example;
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
    public class chat extends JDialog {

        /** Default dimension of the dialog. */
        private final static Dimension DEFAULT_DIMENSION = new Dimension(400, 600);

        /** Create a main dialog. */
        public chat() {
            this(DEFAULT_DIMENSION);
        }

        /** Create a main dialog of the given dimension. */
        public chat(Dimension dim) {
            super((JFrame) null, "JavaChat");
            this.setLayout(new BorderLayout());
            configureGui();
            setSize(dim);
            //setResizable(false);
            setLocationRelativeTo(null);
        }

        /** Configure GUI of this dialog. */
        private void configureGui() {
            //string used throug out the GUI
            String on= "Connect";
            String off = "Disconnect";
            String portText = "Port";
            String serverText = "Server";
            String sendText = "Send";
            String textToDisplay ="";
            String empty ="";

            //this covers all edges of the frame to separate all the inner panels from the edges
            JPanel north = new JPanel();
            north.setBackground(Color.GREEN);
            JPanel west = new JPanel();
            west.setBackground(Color.GREEN);
            JPanel south = new JPanel();
            south.setBackground(Color.GREEN);
            JPanel east = new JPanel();
            east.setBackground(Color.GREEN);
            JPanel center = new JPanel();
            center.setLayout(new BorderLayout());
            this.add(center,BorderLayout.CENTER);
            this.add(north,BorderLayout.NORTH);
            this.add(west,BorderLayout.WEST);
            this.add(south,BorderLayout.SOUTH);
            this.add(east,BorderLayout.EAST);

            //this covers the north part of the panel
            JPanel top = new JPanel();
            top.setLayout(new BorderLayout());
            JPanel serverBlock = new JPanel();
            serverBlock.setLayout(new BorderLayout());
            JButton connection = new JButton(on);
            JTextField server = new JTextField(serverText);
            serverBlock.add(server,BorderLayout.WEST);
            JTextField port = new JTextField(portText);
            port.setEditable(false);
            serverBlock.add(port,BorderLayout.EAST);
            top.add(connection,BorderLayout.WEST);
            top.add(serverBlock);
            center.add(top,BorderLayout.NORTH);

            //TextArea and scrollBar (section in the middle of the center panel)
            JPanel middleArea = new JPanel();
            middleArea.setLayout(new BorderLayout());
            var textArea = new JTextArea();
            textArea.setFont(new Font("Helvetica Neue", Font.PLAIN, 35));
            textArea.setEditable(false);
            textArea.setMargin(new Insets(12, 12, 12, 12));
            textArea.setText(textToDisplay);
            //scrollpane
            var scrollPane = new JScrollPane(textArea);
            scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            //adding components to the panels
            middleArea.add(scrollPane,BorderLayout.CENTER);// check how to do the scroll panel
            center.add(middleArea,BorderLayout.CENTER);

            //enter message and send button section at the bottom( in the south of the center panel)
            JPanel messageSection = new JPanel();
            messageSection.setLayout(new BorderLayout());
            JTextField message = new JTextField();
            JButton send = new JButton(sendText);
            //adding components to the panels
            messageSection.add(message,BorderLayout.CENTER);
            messageSection.add(send,BorderLayout.EAST);
            center.add(messageSection,BorderLayout.SOUTH);

            //all button action will be below
            send.addActionListener(e -> {// action listener for the send button
                if(connection.getText()== on){
                    this.warn("Not connected to server.");//if message wants to be sent when not connected to sever warning will pop up
                }else {//if the server is connected the message wil be able to display
                    String response = message.getText();//gets string from the JText field
                    textArea.append(response + "\n");// adds the string to the text area
                    message.setText(empty);// resets the message entry textfield
                }
            });
            connection.addActionListener(e -> {// action listener for the connection button
                if(on == connection.getText()){ // if the text in button says connect will switch to disconnect
                    connection.setText(off);//assuming you are connected
                }else if( connection.getText()== off){//if the text in button says disconnect button will switch to connect
                    connection.setText(on);//assuem you are not connected
                }
            });
        }
        /** Show the given warning or error message in a modal dialog. */
        private void warn(String msg) {
            JOptionPane.showMessageDialog(this, msg, "JavaChat",
                    JOptionPane.PLAIN_MESSAGE);
        }

        public static void main(String[] args) {
            chat dialog = new chat();
            dialog.setVisible(true);
            dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    }
