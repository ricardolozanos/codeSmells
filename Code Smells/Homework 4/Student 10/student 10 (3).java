package omokGUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.List;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class Game{
	public Game() {
		Game2();
	}
	
	public void Game2() {
		var frame = new JFrame("Omok");
		
		//panel that will organize all the components needed
		var panel = new JPanel();
		panel.setPreferredSize(new Dimension(400,460));
		
		
		//components needed for the mode selection
		var mode = new JPanel();
		mode.add(new JLabel("Mode: "));
		JRadioButton human = new JRadioButton( "Human");
		JRadioButton computer = new JRadioButton( "Computer");
		ButtonGroup group = new ButtonGroup();
		group.add(human);
		group.add(computer);
		mode.add(human); 
		mode.add(computer);
		
		//menu bar
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Game");
		menu.setMnemonic(KeyEvent.VK_G);
		menu.getAccessibleContext().setAccessibleDescription("Game menu");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("Play", KeyEvent.VK_P);
		menuItem.setIcon(null);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		   KeyEvent.VK_P, InputEvent.ALT_DOWN_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
		   "Play a new game");
		menuItem.addActionListener(e -> {
			//creates a new game 
			frame.dispose();
			int input = JOptionPane.showConfirmDialog(null,"Are you sure wou want to create new game?");
			if(input == 0) {
				newGame();
			}
			
	
			 });
		menu.add(menuItem);
		
		//tool bar
		JToolBar toolBar = new JToolBar("Omok");
		JButton button3 = new JButton("t");
		//JButton button3 = new JButton(createImageIcon("lol.png"));
		button3.setToolTipText("Play a new game");
		JButton button2 = new JButton("um");
		button3.setFocusPainted(false);
		toolBar.add(button3);
		toolBar.add(button2);
		
		var turn = new JPanel();
		var label = new JLabel("Player 1 turn ");
		turn.add(label);
		
		//control buttons
		//var controls = new JPanel();
		
		//creates the widget for the board
		BoardPanel board = new BoardPanel();
		board.addMouseListener(new MouseAdapter() {
			
            @Override
            public void mouseClicked(MouseEvent e) {
            	if(human.isSelected()) {
            	 Mode human = new Human();
            	 int xC = e.getX();
            	 int yC = e.getY();
            	 human.start(board, label, xC, yC);
            	 if(board.getBoard().isWin()==true) {
            		 List<int[]> win = board.getBoard().getWinningRow();
            		 board.winningRow(win);
            		 //frame.dispose(); 
            	 }
            	
            	}
            	if(computer.isSelected()) {
            	 int xC = e.getX();
               	 int yC = e.getY();
               	 Mode comp = new Computer();
                 comp.start(board, label, xC, yC);
               	
            	}
            }
        });
		
		

		
		panel.add(menuBar);
		panel.add(toolBar);
		//panel.add(controls);
		panel.add(mode);
		panel.add(board);
		panel.add(turn);
		
		
		

		
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void newGame() {
		Game2();
		
	}

	/** Create an image icon from the given image file. */
	//the method didnt want to work when i used it 
	 private ImageIcon createImageIcon(String filename) {
	     URL imageUrl = getClass().getResource(filename);
	     if (imageUrl != null) {
	         return new ImageIcon(imageUrl);
	     }
	     System.out.print("no image");
	     return null;
	 }

}
