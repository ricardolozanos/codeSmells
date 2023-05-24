package noapplet.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class OmokGUITest extends JFrame {
    JRadioButton jRB1;
    JRadioButton jRB2;
    JButton jButton;
    ButtonGroup BG1;
    JLabel L1;
    //JLabel L2;
    //Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\pymal\\Desktop\\AOOP REtake\\practicing2D\\res\\ActionTaimanin.jpg");
    public OmokGUITest()
    {
        //this.setLayout(null);
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\pymal\\Desktop\\AOOP REtake\\practicing2D\\res\\ActionTaimanin.jpg")));
        //JLabel background=new JLabel(new ImageIcon("C:\\Users\\pymal\\Desktop\\AOOP REtake\\practicing2D\\res\\ActionTaimanin.jpg"));

        jRB1 = new JRadioButton();
        jRB2 = new JRadioButton();
        jButton = new JButton("Play");
        BG1 = new ButtonGroup();
        L1 = new JLabel("Game Mode:");
        jRB1.setText("Human");
        jRB2.setText("Computer");
        jRB1.setBounds(120, 30, 120, 50);
        jRB2.setBounds(250, 30, 120, 50);
        jButton.setBounds(125, 90, 80, 30);
        L1.setBounds(20, 30, 150, 50);
        //L2 = new JLabel();
        //L1.setIcon(new ImageIcon(getClass().getResource("ActionTaimanin.jpg")));

        add(jRB1);

        add(jRB2);

        add(jButton);

        add(L1);

        //this.add(L2);

        /*add(background);

        background.add(jRB1);
        background.add(jRB2);
        background.add(jButton);
        background.add(L1);*/


        BG1.add(jRB1);
        BG1.add(jRB2);


        jButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String option = " ";
                if (jRB1.isSelected()) {
                    option = "Human selected";
                }
                else if (jRB2.isSelected()) {
                    option = "Computer selected";
                }
                else {
                    option = "NO Button selected";
                }
                JOptionPane.showMessageDialog(OmokGUITest.this, option);

            }
        });

    }

}

class RadioButton {
    public static void main(String args[])
    {
        OmokGUITest frame = new OmokGUITest();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(new Color(100,10,120));
        frame.setBounds(100, 100, 600, 400);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Omok Pako");

        frame.setVisible(true);
    }
}