
package counter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class OmokGuiExercise extends noapplet.AnimationNoApplet {

	public OmokGuiExercise() {
		var frame = new JFrame("Omok");
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		
		var MainPanel = new JPanel(); 
		var SubPanel = new JPanel();
		var TopPanel = new JPanel();
		var ButtonPanel = new JPanel();
		var TextPanel = new JPanel();
		
		MainPanel.setLayout(new BorderLayout());
		SubPanel.setLayout(new BorderLayout());
		TopPanel.setLayout(new FlowLayout());
		ButtonPanel.setLayout(new FlowLayout());
		TextPanel.setLayout(new FlowLayout());
		
		JLabel userChoice = new JLabel();
		JButton play = new JButton("Play");
		JRadioButton HumanMode = new JRadioButton("Human");
		JRadioButton ComputerMode = new JRadioButton("Computer");
		
		// 3 different Panels consisting of following 
		TopPanel.add(new JLabel("Select Game Mode") , BorderLayout.NORTH);
		TopPanel.add(HumanMode);
		TopPanel.add(ComputerMode);
		ButtonPanel.add(play , BorderLayout.CENTER);
		TextPanel.add(userChoice);
		
		// Add Top and Button to subPanel
		SubPanel.add(TopPanel , BorderLayout.NORTH);
		SubPanel.add(ButtonPanel , BorderLayout.CENTER);
		
		// Add subPanel and TextPanel to MainPanel
		MainPanel.setPreferredSize(new Dimension(500,500));
		MainPanel.add(SubPanel , BorderLayout.NORTH);
		MainPanel.add(TextPanel , BorderLayout.CENTER);
		
		frame.setContentPane(MainPanel);
        frame.pack();
        frame.setVisible(true);
        
        // Prompt correct selection as label
        play.addActionListener(e -> {
        	if (HumanMode.isSelected()) {
        		userChoice.setText("Human Mode Selected");
        		//panelE.add(new JLabel("Human Mode Selected"));
        	}
        	else if (ComputerMode.isSelected()) {
        		userChoice.setText("Computer Mode Selected");
        		//panelE.add(new JLabel("Computer Mode Selected"));
        	}
        	else {
        		userChoice.setText("No Gamemode Selected");
        	}
        });
	}
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OmokGuiExercise());
    }

}


