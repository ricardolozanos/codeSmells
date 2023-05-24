import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Objects;

public class OmokGUI extends JFrame implements ActionListener {
    JButton play;
    JLabel modeMsg;
    ButtonGroup mode;
    JPanel myPanel = new JPanel();
    public OmokGUI() {
        super("Omok");
        //Here we set the dimensions of the panel and its default close operations
        setPreferredSize(new Dimension(304, 200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Create a JLabel to ask the user to select an opponent
        myPanel.add(new JLabel("Select opponent: "));

        //Group JRadioButtons in mode so that only one is selected
        mode = new ButtonGroup();
        JRadioButton human = new JRadioButton("Human");
        human.setActionCommand("Human opponent");
        JRadioButton computer = new JRadioButton("Computer");
        computer.setActionCommand("Computer opponent");
        mode.add(human);
        mode.add(computer);
        myPanel.add(human);
        myPanel.add(computer);

        //Button to start game, it will display the opponent that was selected if clicked
        play  = new JButton("Play");
        play.addActionListener(this);
        myPanel.add(play);

        //Make the Panel visible
        setContentPane(myPanel);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==play){
            //If no opponent selected, it will ask the user to choose one
            if(mode.getSelection()==null){
                modeMsg = new JLabel("No opponent selected");
            }
            //If there is an opponent selected, it will display it
            else {
                modeMsg = new JLabel(mode.getSelection().getActionCommand());
            }
            //Add label to panel and make it visible
            myPanel.add(modeMsg);
            setContentPane(myPanel);
            pack();
            setVisible(true);
        }
    }
}
