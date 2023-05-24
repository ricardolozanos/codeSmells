package omok.gui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
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
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/** Omok playable game that runs and display game thru Java Gui */
public class OmokGuiRun extends OmokGame {

	private int playerTurn = OmokGame.FREE;
	private static Dimension dim;
	private JMenuItem menuNewGame, menuResetGame, menuEndGame, menuQuitApp, menuHint; //m16
	private JButton toolBarNewGame, toolBarResetGame, toolBarEndGame, toolBarHint, toolBarQuitApp, playGameButton; //to, 
	private JTextField p1name, p2name;
	private JTextArea textArea;
	private JRadioButton radioButtonHuman, radioButtonAI, radioButtonAIvsAI;
	private JSlider boardSlider;
	private JFrame frame;
	ImageIcon newGameIcon = new ImageIcon("./image/1.gif");
	ImageIcon resetGameIcon = new ImageIcon("./image/20.gif");
	ImageIcon endGameIcon = new ImageIcon("./image/9.gif");
	ImageIcon configIcon = new ImageIcon("./image/114.gif");
	ImageIcon hintIcon = new ImageIcon("./image/68.gif");
	ImageIcon quitIcon = new ImageIcon("./image/89.gif");
	
	public OmokGuiRun() {
		super();
	}
	
	public OmokGuiRun(int size, boolean gameType) {
		super(size, gameType);
		initGUI();
	}
	
	private void setPlayerTurn () { 
		this.playerTurn = (playerTurn == OmokGame.PLAYER_ONE ) ? OmokGame.PLAYER_TWO : OmokGame.PLAYER_ONE;
	};
	
	/** Creates menu bar that is used */
	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
      
		JMenu m1 = new JMenu("Game");
		m1.setMnemonic(KeyEvent.VK_G);
      
		JMenu m2 = new JMenu("Help");
		m2.setMnemonic(KeyEvent.VK_H);
      
		menuBar.add(m1); menuBar.add(m2);        
      
		menuNewGame = new JMenuItem("New", newGameIcon);
		menuNewGame.setMnemonic(KeyEvent.VK_N);
		menuNewGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
      
		menuResetGame = new JMenuItem("Reset", resetGameIcon);
		menuResetGame.setMnemonic(KeyEvent.VK_R);
		menuResetGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
      
		menuEndGame = new JMenuItem("End", endGameIcon );
		menuEndGame.setMnemonic(KeyEvent.VK_E);
		menuEndGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
      
		menuQuitApp = new JMenuItem("Quit", quitIcon);
		menuQuitApp.setMnemonic(KeyEvent.VK_Q);
		menuQuitApp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
      
		menuHint = new JMenuItem("Hint", hintIcon);
		menuHint.setMnemonic(KeyEvent.VK_H);
		menuHint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
      
		m1.add(menuNewGame); 
		m1.add(menuResetGame); 
		m1.add(menuEndGame);
		m1.add(new JSeparator());      
		m1.add(menuQuitApp);       
		m2.add(menuHint); 
      
		menuResetGame.setEnabled(false);
      	menuEndGame.setEnabled(false);
      	menuHint.setEnabled(false);

      	return menuBar;
	}
	
	/** Create the JToolBar */
	private JToolBar createToolBar() {
		JToolBar toolBar = new JToolBar("Omok Game",JToolBar.VERTICAL);
		toolBarNewGame = new JButton(newGameIcon);
		toolBarResetGame = new JButton(resetGameIcon);
		toolBarEndGame = new JButton(endGameIcon);
		toolBarHint = new JButton(hintIcon);
		toolBarQuitApp = new JButton(quitIcon);
      
		toolBar.add(toolBarNewGame); 
		toolBar.addSeparator();
      
		toolBar.add(toolBarResetGame); toolBarResetGame.setEnabled(false);
		toolBar.add(toolBarEndGame); toolBarEndGame.setEnabled(false);
		toolBar.add(toolBarHint); toolBarHint.setEnabled(false);
		toolBar.addSeparator();
		toolBar.add(toolBarQuitApp);
      
		toolBarNewGame.setToolTipText("Start a new game");
		toolBarResetGame.setToolTipText("Reset the current game");
		toolBarEndGame.setToolTipText("End the current game");
		toolBarHint.setToolTipText("Player hint");
		toolBarQuitApp.setToolTipText("Quit Omok Game");
		toolBar.setToolTipText("These buttons control the Game");
		return toolBar;
	}
	
	/** Create the game Config box which is located on right side of panel */
	private Box createGameConfigBox() {
		Box configOpt = Box.createVerticalBox();
		JPanel gameTypeConfig = new JPanel();
		gameTypeConfig.setBorder(new TitledBorder("Opponent"));
		gameTypeConfig.setLayout(new GridLayout(2,2));
		ButtonGroup group = new ButtonGroup();
		radioButtonHuman = new JRadioButton("Human", true);
		radioButtonAI = new JRadioButton("AI");
		radioButtonAIvsAI = new JRadioButton("AI vs AI");
              
		group.add(radioButtonHuman); group.add(radioButtonAI); group.add(radioButtonAIvsAI);        
		gameTypeConfig.add(radioButtonHuman); gameTypeConfig.add(radioButtonAI); gameTypeConfig.add(radioButtonAIvsAI);
      
		JPanel gamePlayersConfig = new JPanel();
		gamePlayersConfig.setBorder(new TitledBorder("Players"));
		gamePlayersConfig.setLayout(new GridLayout(2,2));
      
		gamePlayersConfig.add(new JLabel ("Player 1"));
		p1name = new JTextField(10);
		p1name.setText("<name 1>");
		gamePlayersConfig.add(p1name);

		gamePlayersConfig.add(new JLabel ("Player 2"));
		p2name = new JTextField(10);
		p2name.setText("<name 2>");
		gamePlayersConfig.add(p2name);

		JPanel gameSizeConfig = new JPanel();
		gameSizeConfig.setBorder(new TitledBorder("Board Size"));
      	boardSlider = new JSlider(JSlider.HORIZONTAL,5,25,15);
      	boardSlider.setMajorTickSpacing(5);
      	boardSlider.setMinorTickSpacing(1);
      	boardSlider.setPaintTicks(true);
      	boardSlider.setPaintLabels(true);
      	boardSlider.setBorder(BorderFactory.createEmptyBorder(0,0,0,10));
      	gameSizeConfig.add(boardSlider);
      
      
      	JPanel buttons = new JPanel();
      	buttons.setLayout(new GridLayout(2,1 ));
      	playGameButton = new JButton("Play");
      	buttons.add(playGameButton);
      	buttons.add(new JSeparator());
      
      	configOpt.add(gameTypeConfig);
      	configOpt.add(gamePlayersConfig);
      	configOpt.add(gameSizeConfig);
      	configOpt.add(buttons);

      	return configOpt;		
	}
	
	/** create the status area and add to bottom of panel */
	private JPanel createStatusArea() {
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel.add(new JLabel("Status: "));
		textArea = new JTextArea("Configure Game and press <play> to start!");
		panel.add(textArea);
      
		return panel;		
	}
	
	/** The JPanel board panel class that extends JPanel */
	@SuppressWarnings("serial")
	private class BoardPanel extends JPanel {	

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			Color [] gameColors = { new Color(0x9B, 0x63, 0x3B) , Color.WHITE, Color.DARK_GRAY };			
			dim = getSize();		
			int size = getOmokBoard().getOmokBoardSize(); 
			
			//--- find a suitable size for the board tiles, use smallest step so it fits
			int xstep = (dim.width)  / (size+2);
			int ystep = (dim.height) / (size+2);
			int step = xstep > ystep ? ystep : xstep;
			
			//--- draw the board
			g2.setColor(gameColors[OmokGame.FREE]);
			g2.fillRect(step, step, (size-1)*step, (size-1)*step);
			
			// draw the individual tiles
			g2.setColor(Color.BLACK);
			for ( int i=0; i<size-1; ++i ) {
				for ( int j=0; j<size-1; ++j ) {
					g2.drawRect(i*step+step, j*step+step, step, step);
				}
			}
			
			//--- draw the players' moves
			for ( OmokPoint p : getOmokBoard().getOccupiedMoves() ) {
				g2.setColor(gameColors[p.val()]);
				g2.fillOval(p.x()*step+step-step/4, p.y()*step+step-step/4, step/2, step/2);
			}
			
			//--- if the game is over, highlight the winner!			
			if ( getGameOver() ) {
				g2.setColor(new Color(0xFF, 0xD7, 0x00)); //Highlight color: GOLD
				g2.setStroke(new BasicStroke(2)); //Change stroke thickness
				for ( List<Point> lp : getOmokBoard().getRowsOfLength(playerTurn, WIN_LEN)) {
					for ( Point p : lp ) {						
						g2.drawOval(p.x*step+step-step/4, p.y*step+step-step/4, step/2, step/2);						
					}
      		}
				g2.setStroke(new BasicStroke(1)); //reset thickness...
			} 
		}
	}	
	
	//--- Configure the GUI...
	void initGUI() {
		//--- Creating the Frame
		frame = new JFrame("Omok");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
		//--- Creating the MenuBar with the action menus...
		JMenuBar menuBar = createMenuBar();
		//--- Create the ToolBar with the action buttons...
		JToolBar toolBar = createToolBar();
		//--- Create the configuration panel to control the game settings
		Box configOpt = createGameConfigBox();       
		//--- Create the GameBoard Area        
		BoardPanel boardPanel = new BoardPanel();
		boardPanel.setPreferredSize(new Dimension(500,500));
		//--- Create the Game Status Area.        
		JPanel panel = createStatusArea();
            
		frame.getContentPane().add(BorderLayout.PAGE_START, menuBar);
		frame.getContentPane().add(BorderLayout.LINE_START, toolBar);
		frame.getContentPane().add(BorderLayout.CENTER, boardPanel);
		frame.getContentPane().add(BorderLayout.LINE_END, configOpt);
		frame.getContentPane().add(BorderLayout.PAGE_END, panel);
		frame.pack();
		frame.setVisible(true);
  
		//--- Action Listeners setup        
		ActionListener gameButtonListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == menuNewGame || e.getSource() == toolBarNewGame || e.getSource() == playGameButton ) {
					startOmokGame();		    		
				} else if ( e.getSource() == menuResetGame || e.getSource() == toolBarResetGame ) {
	        		resetOmokGame();					
				} else if ( e.getSource() == menuEndGame || e.getSource() == toolBarEndGame ) {
	 				stopOmokGame();					
				} else if ( e.getSource() == menuQuitApp || e.getSource() == toolBarQuitApp ) {
	        		System.exit(0);	        		
				} else if ( e.getSource() == menuHint || e.getSource() == toolBarHint ) {
					OmokAI p = new OmokAI("AI",false);
					OmokPoint m = p.aiPlayer(getOmokBoard(), playerTurn);
					textArea.setText("Hint: (" + m.x() + "," + m.y() + ")");				

				} else {
					System.exit(-1);
				}				
				boardPanel.repaint();
			}        	
		};
      
		//--- Tie listener to buttons and menus
		menuNewGame.addActionListener(gameButtonListener);
		menuResetGame.addActionListener(gameButtonListener);
		menuEndGame.addActionListener(gameButtonListener);
		menuQuitApp.addActionListener(gameButtonListener);        
		menuHint.addActionListener(gameButtonListener);
		toolBarNewGame.addActionListener(gameButtonListener);
		toolBarResetGame.addActionListener(gameButtonListener);        
		toolBarEndGame.addActionListener(gameButtonListener);
		toolBarHint.addActionListener(gameButtonListener);
		toolBarQuitApp.addActionListener(gameButtonListener); 
		playGameButton.addActionListener(gameButtonListener);
      
		ActionListener gameTypelistener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if ( e.getSource() == radioButtonHuman ) {
					p1name.setEditable(true);
					p2name.setEditable(true);
					setGameType(true);
				} else if ( e.getSource() == radioButtonAI ) {
					p1name.setEditable(true);
					p2name.setEditable(false);
					p2name.setText("AI");
					setGameType(false);
				} else if ( e.getSource() == radioButtonAIvsAI ) {
					p1name.setEditable(false);
					p1name.setText("AI#1");
					p2name.setEditable(false);	
					p2name.setText("AI#2");
					setGameType(false);
				}				
			}       	
		};

		//--- Tie listener to radio buttons
		radioButtonHuman.addActionListener(gameTypelistener);
		radioButtonAI.addActionListener(gameTypelistener);
		radioButtonAIvsAI.addActionListener(gameTypelistener);
                
		//--- add a listener to the game panel...
		boardPanel.addMouseListener(new MouseAdapter() {
      	
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		// ignore clicks until game starts, or if game is over, or if board is full
      		if ( playerTurn == FREE || getGameOver() || getOmokBoard().isBoardFull() ) return;
      		
      		OmokPoint p;
  			int size = getOmokBoard().getOmokBoardSize();
  			int xstep = (dim.width)  / (size+2);
  			int ystep = (dim.height) / (size+2);
  			int step = xstep > ystep ? ystep : xstep;

  			float fx = (e.getPoint().x - step) / (float) step;
  			float fy = (e.getPoint().y - step) / (float) step;
          	int x = (int) (fx + 0.5);
          	int y = (int) (fy + 0.5);
      		p = new OmokPoint(x,y,playerTurn);
      		
      		//--- TODO: figure out how to incorporate into playTurn
      		if ( getOmokBoard().placePoint(p) == false ) { 
      			//System.out.println("In mouseClicked(): modifying ta"); 			
      		} else {	
      			textArea.setText("last move: (" + p.y() + "," + p.x() + ") by " + getPlayer(playerTurn).getPlayerName() + " ");
      		
      			if ( testEndOfGame(playerTurn) ) {
      				stopOmokGame();
      			} else {   	
      				setPlayerTurn(); //--- go to next player
      				if ( getPlayer(playerTurn).getPlayerType() == true ) {
  						textArea.append("Next to Play: " + getPlayer(playerTurn).getPlayerName());
      				} else {
      					OmokAI aip = new OmokAI("AI",false);
      					p = aip.aiPlayer(getOmokBoard(), playerTurn);
      				
      					if ( getPlayer(playerTurn).getPlayerType() == false) {
      		      			textArea.setText( getPlayer(playerTurn-1).getPlayerName() + " selected (" + x + "," + y + ") "  +
      		      			"AI selected: (" + p.x() + "," + p.y() + ") ");
      		      		}
  						getOmokBoard().placePoint(p);
  						if ( testEndOfGame(playerTurn) ) stopOmokGame();
  						else setPlayerTurn(); //--- go to next player
      				}
      			}
      		} 
      		boardPanel.repaint();
      	}

      });
      
      //--- add a listener to the slider...
      boardSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider slider = (JSlider) e.getSource();
		        if (!slider.getValueIsAdjusting()) {
		          setOmokBoard(new OmokBoard(slider.getValue()));
		          boardPanel.repaint();
		        }
			}    	
     });

	}
	
	//--- Override OmokGame methods...
	@Override
	public void resetOmokGame() {
		getOmokBoard().boardClear();
		setGameOver(false);
		
		//--- GUI STUFF
		textArea.setText("Game restarted! ");
		textArea.append(getPlayer(playerTurn).getPlayerName());
		textArea.append(" take a turn");
	}
	
	@Override
	public void setOmokGame() {
		setOmokBoard(new OmokBoard(boardSlider.getValue()));
		setGameOver(false);
  	
		if ( radioButtonHuman.isSelected() ) {
			setGameType(true);
			setOmokPlayer1(new OmokPlayer(p1name.getText(),true));
			setOmokPlayer2(new OmokPlayer(p2name.getText(),true));
		} else if ( radioButtonAI.isSelected() ){
			setGameType(false);
			setOmokPlayer1(new OmokPlayer(p1name.getText(),true));
			setOmokPlayer2(new OmokAI(p2name.getText(),false));
		} else {
			setGameType(false);
			setOmokPlayer1(new OmokAI(p1name.getText(),false));
			setOmokPlayer2(new OmokAI(p2name.getText(),false));
		}
		playerTurn = PLAYER_ONE; 
	}
	
	@Override
	public void playTurn() {
		//--- in regular games, turns are handled by the Mouse...
		if ( radioButtonAIvsAI.isSelected() == false ) {
			textArea.setText("Game has started! ");
			textArea.append(getPlayer(playerTurn).getPlayerName());
			textArea.append(" take a turn!");  
			return;
		}
		
		//--- AUTO GAME AI vs AI takes over...
		toolBarResetGame.setEnabled(false);
		toolBarHint.setEnabled(false);
		menuResetGame.setEnabled(false);
		menuHint.setEnabled(false);    

		while(true) {
			OmokAI p = new OmokAI("AI",false);
			OmokPoint m = p.aiPlayer(getOmokBoard(), playerTurn);
			getOmokBoard().placePoint(m);
			if ( testEndOfGame(playerTurn) ) break;
			setPlayerTurn();
		}

		setGameOver(true);
		textArea.setText("Game Over: ");
		if ( getOmokBoard().isBoardFull())
			textArea.append("No Winner!");
		else
			textArea.append(getPlayer(playerTurn).getPlayerName() + " is the winner! ");
	}
	
	@Override 
	public void stopOmokGame() {
		// reset buttons and enable where necessary
		radioButtonHuman.setEnabled(true); 
		radioButtonAI.setEnabled(true);
		radioButtonAIvsAI.setEnabled(true);
		p1name.setEditable(true);
		p2name.setEditable(true);
		boardSlider.setEnabled(true);
		toolBarResetGame.setEnabled(false);
		toolBarHint.setEnabled(false);
		toolBarEndGame.setEnabled(false);
	    menuResetGame.setEnabled(false);
	    menuEndGame.setEnabled(false);
	    menuHint.setEnabled(false);
	    
	    
	    textArea.setText("Game Ended: ");
		if ( getGameOver() ) {		
			textArea.setText("Game Over: ");
			if ( getOmokBoard().isBoardFull() )
				textArea.append("No Winner!");
			else
				textArea.append(getPlayer(playerTurn).getPlayerName() + " is the winner! ");
		} else {
			playerTurn = OmokGame.FREE;
			if ( getOmokBoard().isBoardFull() ) textArea.append("Board Full");	
		}
	}
	
	@Override
	public void startOmokGame() {
		//--- user requests a new game while one is already started
		if ( playerTurn != FREE && getGameOver() == false ) {
			String msg = "Do you want to end the current game?";
			int dialogResult = JOptionPane.showConfirmDialog(frame,msg);
			if ( dialogResult == JOptionPane.YES_OPTION ) {
				stopOmokGame();				
			}
			return;
		}	

		radioButtonHuman.setEnabled(false);
		radioButtonAI.setEnabled(false);
		radioButtonAIvsAI.setEnabled(false);
		p1name.setEditable(false);
		p2name.setEditable(false);
		boardSlider.setEnabled(false);			
		toolBarResetGame.setEnabled(true);
		toolBarHint.setEnabled(true);
		toolBarEndGame.setEnabled(true);
		menuResetGame.setEnabled(true);
		menuEndGame.setEnabled(true);
		menuHint.setEnabled(true);
	    
	    setOmokGame();
	    playTurn();		 	
  }
  
}


