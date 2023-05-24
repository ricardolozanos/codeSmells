import java.awt.*;
import javax.swing.*;
class OmokGUI {
	public static void main(String[] args){
		JFrame frame = new JFrame("Opponent Selection");
        JPanel selectPanel = new JPanel();
        JPanel playPanel = new JPanel();
        JPanel centerPlay = new JPanel();
		JPanel panel = new JPanel();
        JPanel centerLabel = new JPanel();
        JButton playButn = new JButton("Play");// reset button
        JLabel label =  new JLabel();
        JLabel selectionLabel = new JLabel(" Select Opponent: ");
        JComboBox dropDownBox = new JComboBox();
        Human humanPlayer = new Human(1, "Human");
        Computer computerPlayer = new Computer(2, "Computer");

        dropDownBox.addItem(humanPlayer);
        dropDownBox.addItem(computerPlayer);
       

        selectPanel.setLayout(new BorderLayout());
        selectPanel.add(selectionLabel,BorderLayout.WEST);
        selectPanel.add(dropDownBox,BorderLayout.CENTER);

        centerPlay.setLayout(new FlowLayout());
        centerPlay.add(playButn);

        playPanel.setLayout(new BorderLayout());
        playPanel.add(selectPanel,BorderLayout.NORTH);
        playPanel.add(centerPlay,BorderLayout.CENTER);

        centerLabel.setLayout(new FlowLayout());
        centerLabel.add(label);

		panel.setLayout(new BorderLayout());
        panel.add(playPanel, BorderLayout.NORTH);
		panel.add(centerLabel,BorderLayout.SOUTH);
     
        frame.add(panel);
		frame.setSize(500, 400);
		frame.show();

        playButn.addActionListener(e -> {
            var txt = dropDownBox.getSelectedItem();
            label.setText(txt.toString()+" Player Selected!");

        });
	}
}

/*
Study the APIs of JComboBox or JRadioButton and design a UI that prompts the user for the opponent player.
Additionally, include a play button that, when clicked, displays the current selection.
Draw a UML object diagram for your UI design.
 */