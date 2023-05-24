package omok;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class playButton implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		new GUI().newGame();
	}

}
