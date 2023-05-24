import javax.swing.*;

public class ButtonOptions  {
    public JRadioButton person;
    public JRadioButton computerAi;
    public JButton button;
    public JLabel message;

    /**
     * Constructor that creates 2 Jradiobuttons in a button group to make sure
     * only one choice is selected then a Jbutton to play based on the choice that was selected
     * using lambda expression from last exercise we did to show the message.
     */
    public ButtonOptions(){

        ButtonGroup group = new ButtonGroup();
        person = new JRadioButton("Person");
        computerAi = new JRadioButton("Computer AI");
        button = new JButton("Play the game");
        group.add(person);
        group.add(computerAi);
        message = new JLabel();

        button.addActionListener(e -> {
            if(person.isSelected()){
                message.setText("Person was selected");
            }
            else if(computerAi.isSelected()){
                message.setText("Computer was selected");
            }
        });
    }
}
