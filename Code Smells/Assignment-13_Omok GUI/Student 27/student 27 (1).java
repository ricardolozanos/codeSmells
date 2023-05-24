package omokGui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class OmokGui implements ActionListener{
	private JLabel opponentSelected = new JLabel();
	private String[] options = {"Human", "Computer"};
	private JComboBox<Object> optionsList = new JComboBox<Object>(options);
	
	public OmokGui() {
		var frame = new JFrame("Omok");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 200));
        panel.add(new JLabel("Select Opponent:  "));
        
        
        panel.add(optionsList);
        JButton button1 = new JButton("Play");
        button1.addActionListener(this);
        panel.add(button1);
        panel.add(this.opponentSelected);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
    	javax.swing.SwingUtilities.invokeLater(() -> new OmokGui());
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		String opponent = (String)this.optionsList.getSelectedItem();
		if(opponent != null) {
			this.opponentSelected.setText(opponent + " selected!");
		}
		
	}

}
