package omokGUI;

import javax.swing.JLabel;

//modes
public interface Mode{



	void start(BoardPanel board, JLabel label, int x, int y);
}