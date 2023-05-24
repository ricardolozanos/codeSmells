package omok;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;


@SuppressWarnings("serial")
public class GUI extends JFrame{
		
		private BoardPanel board;

		public GUI() {
				setResizable(false);
				
				//menu code
				JMenuBar menuBar = new JMenuBar();
				
				JMenu menu = new JMenu("Menu");
				menu.setMnemonic(KeyEvent.VK_G);
				menu.getAccessibleContext().setAccessibleDescription("Game menu");
				menuBar.add(menu);
				
				JMenuItem menuItem = new JMenuItem("Play", KeyEvent.VK_P);
				menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.ALT_MASK));
				menuItem.getAccessibleContext().setAccessibleDescription("Play a New Game");
				menuItem.addActionListener(new playButton());
				menu.add(menuItem);
				
				
				//Tool Bar Code
				JToolBar toolBar = new JToolBar("Omok");
				
				JButton play = new JButton("Play");
				play.addActionListener(new playButton());
				
				play.setToolTipText("Play a New Game");
				play.setFocusPainted(false);
				toolBar.add(play);
				
				//Board Display
				board = new BoardPanel();
			
				// add them to the window
				setJMenuBar(menuBar);
				add(toolBar, BorderLayout.NORTH);
				add(board, BorderLayout.CENTER);
		}
		
		public int newGame() {
			return JOptionPane.showConfirmDialog(this, "Play New Game?", "Omok", JOptionPane.YES_NO_OPTION);
		}
		
		public void gameOver(String message) {
			JOptionPane.showMessageDialog(this, message);
		}
		
		public int mode() {
			Object[] modes = {"Computer" , "Player"};
			return JOptionPane.showOptionDialog(this, "Who Are You Playing Against?", "Omok", 2, EXIT_ON_CLOSE, null, modes, modes);
		}
		
		public BoardPanel board() {
			return board;
		}
}
